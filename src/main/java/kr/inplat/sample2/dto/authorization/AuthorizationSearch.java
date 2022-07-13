package kr.inplat.sample2.dto.authorization;

import lombok.Data;

@Data
public class AuthorizationSearch {

    private int documentCode;

    private String documentTitle;

    private String confirm;
}
