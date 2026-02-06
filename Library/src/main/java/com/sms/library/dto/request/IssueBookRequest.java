package com.sms.library.dto.request;

import jakarta.validation.constraints.NotNull;

public class IssueBookRequest {

    @NotNull
    private Integer rollNo;

    @NotNull
    private Long bookId;

	public Integer getRollNo() {
		return rollNo;
	}

	public void setRollNo(Integer rollNo) {
		this.rollNo = rollNo;
	}

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

    
}
