package com.sms.fees.mapper;

import com.sms.fees.dto.response.FeesResponse;
import com.sms.fees.entity.Fees;

public class FeesMapper {

    private FeesMapper() {}

    public static FeesResponse toResponse(Fees fees) {

        FeesResponse response = new FeesResponse();
        response.setId(fees.getId());
        response.setRollNo(fees.getRollNo());
        response.setFeeType(fees.getFeeType());
        response.setAmount(fees.getAmount());
        response.setSemester(fees.getSemester());
        response.setStatus(fees.getStatus());
        response.setPaidAt(fees.getPaidAt());

        return response;
    }
}
