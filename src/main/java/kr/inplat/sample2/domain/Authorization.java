package kr.inplat.sample2.domain;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;
public class Authorization {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @Type(type = "true_false")
    private boolean deleted = false;
    private int documentCode;
    private String documentTitle;
    private String confirmId;

    @Type(type = "yes_no")
    private String confirm = "N";
    @Column(updatable = false)
    private String createdBy;

    @Column(updatable = false)
    private LocalDateTime createdDate = LocalDateTime.now();
    private String modifiedBy;
    private LocalDateTime modifiedDate = LocalDateTime.now();

}
