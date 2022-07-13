package kr.inplat.sample2.dto.authorization;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AuthorizationResponse {

    private String id;

    private int documentCode;

    private String documentTitle;

    private String confirmId;

    private String confirm;

    private String createdBy;

    private LocalDateTime createdDat;

    private String modifiedBy;

    private LocalDateTime modifiedDate;
}
