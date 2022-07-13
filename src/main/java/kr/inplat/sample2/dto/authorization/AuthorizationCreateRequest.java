package kr.inplat.sample2.dto.authorization;

import lombok.Data;

@Data
public class AuthorizationCreateRequest {

    private int documentCode;

    private String documentTitle;

    private String confirmId;

    private String createdBy;
}
