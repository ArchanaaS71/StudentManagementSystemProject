package com.sms.library.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sms.library.entities.LibraryTransaction;

public interface LibraryTransactionRepository
        extends JpaRepository<LibraryTransaction, Long> {

    List<LibraryTransaction> findByRollNo(Integer rollNo);
}

