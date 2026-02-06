package com.sms.library.mapper;

import com.sms.library.dto.response.BookResponse;
import com.sms.library.entities.Book;


public class BookMapper {

    private BookMapper() {}

    public static BookResponse toResponse(Book book) {

        BookResponse response = new BookResponse();
        response.setId(book.getId());
        response.setIsbn(book.getIsbn());
        response.setTitle(book.getTitle());
        response.setAuthor(book.getAuthor());
        response.setStatus(book.getStatus());

        return response;
    }
}
