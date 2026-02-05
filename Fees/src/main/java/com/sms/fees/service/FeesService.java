package com.sms.fees.service;

import com.sms.fees.dto.request.CreateFeesRequest;
import com.sms.fees.dto.request.UpdatePaymentStatusRequest;
import com.sms.fees.dto.response.FeesResponse;
import com.sms.fees.enums.FeeType;
import com.sms.fees.enums.PaymentStatus;

import java.util.List;

public interface FeesService {

    FeesResponse createFees(CreateFeesRequest request);

    List<FeesResponse> getFeesByRollNo(Integer rollNo);

    FeesResponse updatePaymentStatus(UpdatePaymentStatusRequest request);
    
    List<FeesResponse> getFeesByRollNoAndFeeType(Integer rollNo, FeeType feeType);

    List<FeesResponse> getFeesByRollNoAndStatus(Integer rollNo, PaymentStatus status);
    
    List<FeesResponse> getFeesByStatus(PaymentStatus status);

	List<FeesResponse> getFeesByFeeType(FeeType feeType);
    
}

