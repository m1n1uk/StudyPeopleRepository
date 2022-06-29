package kr.inplat.sample2.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
// 1. 2. https://www.baeldung.com/lombok-builder-default-value
@Builder(toBuilder = true, builderClassName = "userBuilder")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {

    @Id
    @GeneratedValue(generator="UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    // 사용자 ID
    private String id;
    // 사용자 사용여부
    @Type(type="true_false")
//    @Builder.Default
    private boolean able = true;
    // 사용자 등록일
//    @Builder.Default
    @Column(updatable = false)
    private Date createDate = new Date();

    // 사용자 이름
    private String name;
    // 사용자 생년월일
    private String birthday;
    // 사용자 전화번호
    private String phone;

    private LocalDateTime updateTime;

    // 내부클래스(빌더클래스) 변수 초기화 전달
    public static class userBuilder {
        private boolean able = true;
        private Date createDate = new Date();
    }
}
