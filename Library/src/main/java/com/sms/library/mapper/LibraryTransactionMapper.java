package com.sms.library.mapper;

import com.sms.library.dto.response.LibraryTransactionResponse;
import com.sms.library.entities.LibraryTransaction;
public class LibraryTransactionMapper {

    private LibraryTransactionMapper() {}

    public static LibraryTransactionResponse toResponse(
            LibraryTransaction tx) {

        LibraryTransactionResponse response =
                new LibraryTransactionResponse();

        response.setId(tx.getId());
        response.setRollNo(tx.getRollNo());
        response.setBookId(tx.getBookId());
        response.setIssueDate(tx.getIssueDate());
        response.setDueDate(tx.getDueDate());
        response.setReturnDate(tx.getReturnDate());
        response.setFine(tx.getFine());
        response.setStatus(tx.getStatus());

        return response;
    }
}
