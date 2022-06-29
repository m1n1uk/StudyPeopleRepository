package kr.inplat.sample2.controller;

import kr.inplat.sample2.domain.Pay;
import kr.inplat.sample2.protocol.PayRequest;
import kr.inplat.sample2.protocol.PayResponse;
import kr.inplat.sample2.service.PayService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// 지출관리 서블렛
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/pay-practice")
public class PayController {
    
    // 서비스 호출
    private final PayService payService;

    // 지출목록
    @GetMapping("")
    public List<PayResponse> payList(){
        return payService.payList();
    }

    // 지출상세
    @GetMapping("/{id}")
    public PayResponse payDetail(@PathVariable("id")Pay pay){
        return payService.payDetail(pay);
    }

    // 지출등록
    @PostMapping("")
    public boolean payInsert(@RequestBody PayRequest payRequest){
        return payService.payInsert(payRequest);
    }

    // 지출수정
    @PutMapping("")
    public boolean payUpdate(@RequestBody PayRequest payRequest){
        return payService.payUpdate(payRequest);
    }
}
