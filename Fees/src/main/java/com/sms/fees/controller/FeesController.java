package com.sms.fees.controller;

import com.sms.fees.dto.request.CreateFeesRequest;
import com.sms.fees.dto.request.UpdatePaymentStatusRequest;
import com.sms.fees.dto.response.FeesResponse;
import com.sms.fees.enums.FeeType;
import com.sms.fees.enums.PaymentStatus;
import com.sms.fees.service.FeesService;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fees")
public class FeesController {

    private final FeesService feesService;

    public FeesController(FeesService feesService) {
        this.feesService = feesService;
    }

    @PostMapping
    public FeesResponse createFees(
            @Valid @RequestBody CreateFeesRequest request) {
        return feesService.createFees(request);
    }

    @GetMapping("/roll/{rollNo}")
    public List<FeesResponse> getFees(
            @PathVariable Integer rollNo) {
        return feesService.getFeesByRollNo(rollNo);
    }

    @PutMapping("/payment")
    public FeesResponse updatePaymentStatus(
            @Valid @RequestBody UpdatePaymentStatusRequest request) {
        return feesService.updatePaymentStatus(request);
    }
    @GetMapping("/roll/{rollNo}/type/{feeType}")
    public List<FeesResponse> getFeesByType(
            @PathVariable Integer rollNo,
            @PathVariable FeeType feeType) {

        return feesService.getFeesByRollNoAndFeeType(rollNo, feeType);
    }

    @GetMapping("/roll/{rollNo}/status/{status}")
    public List<FeesResponse> getFeesByStatus(
            @PathVariable Integer rollNo,
            @PathVariable PaymentStatus status) {

        return feesService.getFeesByRollNoAndStatus(rollNo, status);
}
}
