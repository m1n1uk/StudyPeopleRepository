package kr.inplat.sample2.dto.pay;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PayResponse {

    // 지불식별코드 PK
    private String id;
    // 지출인
    private String userId;
    // 지출일
    private Date payday;
    // 장소
    private String payPlace;
    // 총액
    private int payCost;
    // 처리여부
    private boolean payState;
}
