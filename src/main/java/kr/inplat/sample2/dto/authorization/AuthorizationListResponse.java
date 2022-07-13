package kr.inplat.sample2.dto.authorization;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AuthorizationListResponse {

    private String id;

    private int documentCode;

    private String documentTitle;

    private String confirmId;

    private Boolean confirm;

    private String createdBy;

    private LocalDateTime createdDate;

    private String modifiedBy;

    private LocalDateTime modifiedDate;
}
