package kr.inplat.sample2.dto.authorization;

import lombok.Getter;

@Getter
public class AuthorizationCreateRequest {

    private int documentCode;

    private String documentTitle;

    private String confirmId;
}
