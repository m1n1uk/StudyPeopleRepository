package kr.inplat.sample2.service;

import kr.inplat.sample2.domain.Pay;
import kr.inplat.sample2.dto.pay.PayRequest;
import kr.inplat.sample2.dto.pay.PayResponse;
import kr.inplat.sample2.repository.PayRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PayService {

    public final PayRepository payRepository;

    // 지출목록
    @Transactional(readOnly = true)
    public List<PayResponse> payList() {
        List<Pay> payList = payRepository.findByAbleTrue();

        // map -> stream내 요소들을 하나씩 특정값으로 변환
        return payList.stream().map(pay -> {
            PayResponse payResponse = new PayResponse();
            // BeanUtils.copyProperties(source, target)
            BeanUtils.copyProperties(pay, payResponse);
            return payResponse;
        }).collect(Collectors.toList());
    }

    // 지출상세
    @Transactional(readOnly = true)
    public PayResponse payDetail(Pay pay) {
        Optional<Pay> payDetail = payRepository.findById(pay.getId());
        PayResponse payResponse = null;

        if (payDetail.isPresent()) {
            payResponse = PayResponse.builder().id(payDetail.get().getId()).userId(payDetail.get().getUserId()).payday(payDetail.get().getPayday()).payPlace(payDetail.get().getPayPlace()).payCost(payDetail.get().getPayCost())
                    // boolean타입의 경우 getter가 아닌 is형태로 도출된다.
                    .payState(payDetail.get().isPayState()).build();
        }
        return payResponse;
    }

    // 지출등록
    @Transactional
    public boolean payInsert(PayRequest request) {
        Pay pay = Pay.builder().userId(request.getUserId()).payday(request.getPayday()).payPlace(request.getPayPlace()).payCost(request.getPayCost()).payState(false).build();
        payRepository.save(pay);
        return true;
    }

    // 지출수정
    @Transactional
    public boolean payUpdate(PayRequest request) {
        Pay pay = Pay.builder().id(request.getId()).userId(request.getUserId()).payday(request.getPayday()).payPlace(request.getPayPlace()).payCost(request.getPayCost()).payState(request.isPayState()).build();
        payRepository.save(pay);
        return true;
    }
}
