package kr.inplat.sample2.controller;

import kr.inplat.sample2.domain.Authorization;
import kr.inplat.sample2.dto.authorization.*;
import kr.inplat.sample2.service.AuthorizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/authorization-practice")
@RequiredArgsConstructor
public class AuthorizationController {

    private final AuthorizationService authorizationService;

    @GetMapping("")
    public ResponseEntity<List<AuthorizationListResponse>> getAuthorizationList(AuthorizationSearch authorizationSearch){
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorizationResponse> getAuthorization(@PathVariable("id")Authorization authorization){
        return null;
    }

    @PostMapping("")
    public ResponseEntity<String> createAuthorization(@RequestBody AuthorizationCreateRequest authorizationCreateRequest){
        return null;
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateAuthorization(@PathVariable("id")String id, AuthorizationUpdateRequest authorizationUpdateRequest){
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAuthorization(@PathVariable("id")String id){
        return null;
    }
    // enum타입 목록도출
//    @GetMapping("/document-type")
//    public ResponseEntity<List<DocumentType>> getDocumentType(){
//    }

    // 승인
    @PostMapping("/confirm")
    public ResponseEntity<String> confirmAuthorization(@RequestBody AuthorizationUpdateRequest authorizationUpdateRequest){
        return null;
    }
}
