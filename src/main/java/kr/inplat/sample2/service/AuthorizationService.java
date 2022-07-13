package kr.inplat.sample2.service;

import kr.inplat.sample2.domain.Authorization;
import kr.inplat.sample2.dto.authorization.*;
import kr.inplat.sample2.repository.AuthorizationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorizationService {

    private final AuthorizationRepository authorizationRepository;

    @Transactional(readOnly = true)
    public List<AuthorizationListResponse> getAuthorizationList(AuthorizationSearch authorizationSearch){
        return null;
    }

    @Transactional(readOnly = true)
    public AuthorizationResponse getAuthorization(Authorization authorization){
        return null;
    }

    @Transactional
    public Authorization createAuthorization(AuthorizationCreateRequest authorizationCreateRequest){
        return null;
    }

    @Transactional
    public Authorization updateAuthorization(String id, AuthorizationUpdateRequest authorizationUpdateRequest){
        return null;
    }

    @Transactional
    public Authorization deleteAuthorization(String id){
        return null;
    }

    @Transactional
    public Authorization confirmAuthorization(AuthorizationUpdateRequest authorizationUpdateRequest){
        return null;
    }
}
