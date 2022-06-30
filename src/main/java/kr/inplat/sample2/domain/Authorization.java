package kr.inplat.sample2.domain;

import kr.inplat.sample2.dto.authorization.AuthorizationCreateRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
    @Column(updatable = false)
    private String createdBy;

    @Column(updatable = false)
    private LocalDateTime createdDate = LocalDateTime.now();
    private String modifiedBy;

    private LocalDateTime modifiedDate = LocalDateTime.now();

    // create 시작
    public Authorization(AuthorizationCreateRequest authorizationCreateRequest) {
        this.documentCode = authorizationCreateRequest.getDocumentCode();
        this.documentTitle = authorizationCreateRequest.getDocumentTitle();
        this.confirmId = authorizationCreateRequest.getConfirmId();
    }

    public void createdBy(String createdBy) {
        this.createdBy = createdBy;
        this.modifiedBy = createdBy;
    }
    // create 종료

    public void update(String modifiedBy, int documentCode, String documentTitle) {
        this.modifiedBy = modifiedBy;
        this.documentCode = documentCode;
        this.documentTitle = documentTitle;
        this.modifiedDate = LocalDateTime.now();
    }

    public void delete() {
        this.deleted = true;
    }
}
