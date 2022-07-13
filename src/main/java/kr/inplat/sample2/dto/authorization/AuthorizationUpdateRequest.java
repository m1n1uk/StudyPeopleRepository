package kr.inplat.sample2.dto.authorization;

import lombok.Data;

@Data
public class AuthorizationUpdateRequest {

    private int documentCode;

    private String documentTitle;

    private String confirmId;

    private String modifiedBy;
}
