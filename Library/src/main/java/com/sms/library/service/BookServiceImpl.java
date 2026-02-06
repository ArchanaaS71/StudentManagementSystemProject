package com.sms.library.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sms.library.dto.request.CreateBookRequest;
import com.sms.library.dto.response.BookResponse;
import com.sms.library.entities.Book;
import com.sms.library.enums.BookStatus;
import com.sms.library.mapper.BookMapper;
import com.sms.library.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public BookResponse addBook(CreateBookRequest request) {

        Book book = new Book();
        book.setIsbn(request.getIsbn());
        book.setTitle(request.getTitle());
        book.setAuthor(request.getAuthor());
        book.setStatus(BookStatus.AVAILABLE);

        return BookMapper.toResponse(bookRepository.save(book));
    }

    @Override
    public List<BookResponse> getAllBooks() {
        return bookRepository.findAll()
                .stream()
                .map(BookMapper::toResponse)
                .toList();
    }
}

