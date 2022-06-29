package kr.inplat.sample2.protocol;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {

    // 사용자 ID
    private String id;
    // 사용자 이름
    private String name;
    // 사용자 생년월일
    private String birthday;
    // 사용자 전화번호
    private String phone;
}
