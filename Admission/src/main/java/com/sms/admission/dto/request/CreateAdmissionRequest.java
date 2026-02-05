package com.sms.admission.dto.request;


import jakarta.validation.constraints.*;

public class CreateAdmissionRequest {

    @NotBlank(message = "Student name is required")
    private String name;

    @Email(message = "Invalid email format")
    @NotBlank(message = "Email is required")
    private String email;

    @NotBlank(message = "Phone number is required")
    @Pattern(regexp = "^[6-9]\\d{9}$", message = "Invalid phone number")
    private String phone;

    @NotBlank(message = "Address is required")
    private String address;

    @NotBlank(message = "Father name is required")
    private String fatherName;

    @NotBlank(message = "Mother name is required")
    private String motherName;

    @NotBlank(message = "Parent phone number is required")
    @Pattern(regexp = "^[6-9]\\d{9}$", message = "Invalid parent phone number")
    private String parentPhone;

    @NotBlank(message = "School name is required")
    private String school;

    @NotNull(message = "10th percentage is required")
    @Min(value = 0)
    @Max(value = 100)
    private Byte tenthPercentage;

    @NotNull(message = "12th percentage is required")
    @Min(value = 0)
    @Max(value = 100)
    private Byte twelfthPercentage;

    @NotBlank(message = "Department is required")
    private String department;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public String getParentPhone() {
		return parentPhone;
	}

	public void setParentPhone(String parentPhone) {
		this.parentPhone = parentPhone;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public Byte getTenthPercentage() {
		return tenthPercentage;
	}

	public void setTenthPercentage(Byte tenthPercentage) {
		this.tenthPercentage = tenthPercentage;
	}

	public Byte getTwelfthPercentage() {
		return twelfthPercentage;
	}

	public void setTwelfthPercentage(Byte twelfthPercentage) {
		this.twelfthPercentage = twelfthPercentage;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
    
    
}

