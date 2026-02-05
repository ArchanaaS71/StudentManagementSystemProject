package com.sms.fees.repository;


import com.sms.fees.entity.Fees;
import com.sms.fees.enums.FeeType;
import com.sms.fees.enums.PaymentStatus;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FeesRepository extends JpaRepository<Fees, Long> {

    List<Fees> findByRollNo(Integer rollNo);
    List<Fees> findByRollNoAndFeeType(Integer rollNo, FeeType feeType);

    List<Fees> findByRollNoAndStatus(Integer rollNo, PaymentStatus status);
    List<Fees> findByStatus(PaymentStatus status);
    List<Fees> findByFeeType(FeeType feeType);
 }
