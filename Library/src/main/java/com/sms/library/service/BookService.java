package com.sms.library.service;

import com.sms.library.dto.request.CreateBookRequest;
import com.sms.library.dto.response.BookResponse;

import java.util.List;

public interface BookService {

    BookResponse addBook(CreateBookRequest request);

    List<BookResponse> getAllBooks();
}
