package kr.inplat.sample2.dto.authorization;

import lombok.Getter;

@Getter
public class AuthorizationUpdateRequest {

    private String modifiedBy;

    private int documentCode;

    private String documentTitle;
}
