package kr.inplat.sample2.service;

import kr.inplat.sample2.domain.Authorization;
import kr.inplat.sample2.dto.authorization.AuthorizationCreateRequest;
import kr.inplat.sample2.dto.authorization.AuthorizationUpdateRequest;
import kr.inplat.sample2.repository.AuthorizationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorizationService {
    public final AuthorizationRepository authorizationRepository;

    @Transactional(readOnly = true)
    public List<Authorization> getAuthorizationList() {
        return authorizationRepository.findByDeletedFalse();
    }

    @Transactional(readOnly = true)
    public Authorization getAuthorization(Authorization authorization) {
        return authorization;
    }

    @Transactional
    public Authorization createAuthorization(String createdBy, AuthorizationCreateRequest authorizationCreateRequest) {
        Authorization createAuthorization = new Authorization(authorizationCreateRequest);
        createAuthorization.createdBy(createdBy);
        return authorizationRepository.save(createAuthorization);
    }

    @Transactional
    public Authorization updateAuthorization(String id, AuthorizationUpdateRequest authorizationUpdateRequest) {
        Authorization authorizationUpdate = authorizationRepository.getReferenceById(id);
        authorizationUpdate.update(
                authorizationUpdateRequest.getModifiedBy(),
                authorizationUpdateRequest.getDocumentCode(),
                authorizationUpdateRequest.getDocumentTitle()
        );
        return authorizationUpdate;
    }

    @Transactional
    public Authorization deleteAuthorization(String id) {
        Authorization authorization = authorizationRepository.getReferenceById(id);
        authorization.delete();
        return authorization;
    }
}
