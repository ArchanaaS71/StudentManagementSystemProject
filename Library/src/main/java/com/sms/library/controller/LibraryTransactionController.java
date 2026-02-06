package com.sms.library.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sms.library.dto.request.IssueBookRequest;
import com.sms.library.dto.request.ReturnBookRequest;
import com.sms.library.dto.response.LibraryTransactionResponse;
import com.sms.library.service.LibraryTransactionService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/library")
public class LibraryTransactionController {

    private final LibraryTransactionService libraryService;

    public LibraryTransactionController(
            LibraryTransactionService libraryService) {
        this.libraryService = libraryService;
    }

    @PostMapping("/issue")
    public LibraryTransactionResponse issueBook(
            @Valid @RequestBody IssueBookRequest request) {
        return libraryService.issueBook(request);
    }

    @PostMapping("/return")
    public LibraryTransactionResponse returnBook(
            @Valid @RequestBody ReturnBookRequest request) {
        return libraryService.returnBook(request);
    }

    @GetMapping("/roll/{rollNo}")
    public List<LibraryTransactionResponse> getByRoll(
            @PathVariable Integer rollNo) {
        return libraryService.getTransactionsByRollNo(rollNo);
    }
}
