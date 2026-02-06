package com.sms.library.service;

import com.sms.library.dto.request.IssueBookRequest;
import com.sms.library.dto.request.ReturnBookRequest;
import com.sms.library.dto.response.LibraryTransactionResponse;

import java.util.List;

public interface LibraryTransactionService {

    LibraryTransactionResponse issueBook(IssueBookRequest request);

    LibraryTransactionResponse returnBook(ReturnBookRequest request);

    List<LibraryTransactionResponse> getTransactionsByRollNo(Integer rollNo);
}
