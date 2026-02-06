package com.sms.library.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sms.library.client.StudentClient;
import com.sms.library.dto.request.IssueBookRequest;
import com.sms.library.dto.request.ReturnBookRequest;
import com.sms.library.dto.response.LibraryTransactionResponse;
import com.sms.library.entities.Book;
import com.sms.library.entities.LibraryTransaction;
import com.sms.library.enums.BookStatus;
import com.sms.library.enums.TransactionStatus;
import com.sms.library.mapper.LibraryTransactionMapper;
import com.sms.library.repository.BookRepository;
import com.sms.library.repository.LibraryTransactionRepository;

@Service
public class LibraryTransactionServiceImpl
        implements LibraryTransactionService {

    private final LibraryTransactionRepository txRepo;
    private final BookRepository bookRepo;
    private final StudentClient studentClient;

    public LibraryTransactionServiceImpl(
            LibraryTransactionRepository txRepo,
            BookRepository bookRepo,
            StudentClient studentClient) {

        this.txRepo = txRepo;
        this.bookRepo = bookRepo;
        this.studentClient = studentClient;
    }

    @Override
    public LibraryTransactionResponse issueBook(
            IssueBookRequest request) {

       
        studentClient.getStudentByRoll(request.getRollNo());

        Book book = bookRepo.findById(request.getBookId())
                .orElseThrow(() ->
                        new RuntimeException("Book not found"));

        if (book.getStatus() == BookStatus.ISSUED) {
            throw new RuntimeException("Book already issued");
        }

        book.setStatus(BookStatus.ISSUED);
        bookRepo.save(book);

        LibraryTransaction tx = new LibraryTransaction();
        tx.setRollNo(request.getRollNo());
        tx.setBookId(book.getId());
        tx.setIssueDate(LocalDate.now());
        tx.setDueDate(LocalDate.now().plusDays(14));
        tx.setStatus(TransactionStatus.ISSUED);
        tx.setFine(0.0);

        return LibraryTransactionMapper.toResponse(txRepo.save(tx));
    }

    @Override
    public LibraryTransactionResponse returnBook(
            ReturnBookRequest request) {

        LibraryTransaction tx = txRepo.findById(
                request.getTransactionId())
                .orElseThrow(() ->
                        new RuntimeException("Transaction not found"));

        tx.setReturnDate(LocalDate.now());

        if (LocalDate.now().isAfter(tx.getDueDate())) {
            long daysLate =
                    ChronoUnit.DAYS.between(
                            tx.getDueDate(), LocalDate.now());
            tx.setFine(daysLate * 5.0);
            tx.setStatus(TransactionStatus.OVERDUE);
        } else {
            tx.setStatus(TransactionStatus.RETURNED);
        }

        Book book = bookRepo.findById(tx.getBookId())
                .orElseThrow();
        book.setStatus(BookStatus.AVAILABLE);
        bookRepo.save(book);

        return LibraryTransactionMapper.toResponse(txRepo.save(tx));
    }

    @Override
    public List<LibraryTransactionResponse> getTransactionsByRollNo(
            Integer rollNo) {

        return txRepo.findByRollNo(rollNo)
                .stream()
                .map(LibraryTransactionMapper::toResponse)
                .toList();
    }
}

