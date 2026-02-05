package com.sms.fees.service;

import com.sms.fees.client.StudentClient;
import com.sms.fees.client.dto.StudentResponse;
import com.sms.fees.config.FeeProperties;
import com.sms.fees.dto.request.CreateFeesRequest;
import com.sms.fees.dto.request.UpdatePaymentStatusRequest;
import com.sms.fees.dto.response.FeesResponse;
import com.sms.fees.entity.Fees;
import com.sms.fees.enums.FeeType;
import com.sms.fees.enums.PaymentStatus;
import com.sms.fees.enums.StudentCategory;
import com.sms.fees.mapper.FeesMapper;
import com.sms.fees.repository.FeesRepository;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FeesServiceImpl implements FeesService {

    private final FeesRepository feesRepository;
    private final FeeProperties feeProperties;
    private final StudentClient studentClient;

    public FeesServiceImpl(FeesRepository feesRepository,
                           FeeProperties feeProperties,
                           StudentClient studentClient) {
        this.feesRepository = feesRepository;
        this.feeProperties = feeProperties;
        this.studentClient = studentClient;
    }

    @Override
    public FeesResponse createFees(CreateFeesRequest request) {

        StudentResponse student =
                studentClient.getStudentByRoll(request.getRollNo());

        StudentCategory category = student.getStudentCategory();

        Fees fees = new Fees();
        fees.setRollNo(request.getRollNo());
        fees.setFeeType(request.getFeeType());
        fees.setSemester(request.getSemester());
        fees.setStatus(PaymentStatus.PENDING);
        fees.setCreatedAt(LocalDateTime.now());

        if (request.getFeeType() == FeeType.SEMESTER) {
            fees.setAmount(feeProperties.getSemester().getAmount());
        }
        else if (request.getFeeType() == FeeType.HOSTEL) {

            if (category != StudentCategory.HOSTELLER) {
                throw new RuntimeException("Hostel fee only for hostellers");
            }
            fees.setAmount(feeProperties.getHostel().getAmount());
        }
        else if (request.getFeeType() == FeeType.BUS) {

            if (category != StudentCategory.DAY_SCHOLAR) {
                throw new RuntimeException("Bus fee only for day scholars");
            }
            fees.setAmount(feeProperties.getBus().getAmount());
        }

        return FeesMapper.toResponse(feesRepository.save(fees));
    }

    @Override
    public List<FeesResponse> getFeesByRollNo(Integer rollNo) {

        return feesRepository.findByRollNo(rollNo)
                .stream()
                .map(FeesMapper::toResponse)
                .collect(Collectors.toList());
    }
    @Override
    public FeesResponse updatePaymentStatus(UpdatePaymentStatusRequest request) {

        Fees fees = feesRepository.findById(request.getFeeId())
                .orElseThrow(() -> new RuntimeException("Fees record not found"));

        fees.setStatus(request.getStatus());

        if (request.getStatus() == PaymentStatus.PAID) {
            fees.setPaidAt(LocalDateTime.now());
        }

        Fees updated = feesRepository.save(fees);
        return FeesMapper.toResponse(updated);
    }
    
    @Override
    public List<FeesResponse> getFeesByRollNoAndFeeType(Integer rollNo, FeeType feeType) {

        return feesRepository.findByRollNoAndFeeType(rollNo, feeType)
                .stream()
                .map(FeesMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<FeesResponse> getFeesByRollNoAndStatus(Integer rollNo, PaymentStatus status) {

        return feesRepository.findByRollNoAndStatus(rollNo, status)
                .stream()
                .map(FeesMapper::toResponse)
                .collect(Collectors.toList());
    }


}
