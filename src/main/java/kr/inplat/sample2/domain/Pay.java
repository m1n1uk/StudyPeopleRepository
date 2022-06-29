package kr.inplat.sample2.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
@Builder(builderClassName = "payBuilder")
@AllArgsConstructor
@NoArgsConstructor
public class Pay {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    // 지불식별코드 PK
    private String id;
    // 지불사용여부
    @Type(type = "true_false")
    private boolean able;
    // 지출 등록일
    private Date writeTime;

    // 지출인
    private String userId;
    // 지출일
    private Date payday;
    // 장소
    private String payPlace;
    // 총액
    private int payCost;
    // 처리여부
    @Type(type = "true_false")
    private boolean payState;

    // 내부클래스(빌더클래스) 변수 초기화 전달
    public static class payBuilder {
        private boolean able = true;
        private Date writeTime = new Date();
    }
}
