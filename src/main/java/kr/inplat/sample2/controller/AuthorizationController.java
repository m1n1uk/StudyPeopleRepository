package kr.inplat.sample2.controller;

import kr.inplat.sample2.domain.Authorization;
import kr.inplat.sample2.dto.authorization.AuthorizationCreateRequest;
import kr.inplat.sample2.dto.authorization.AuthorizationUpdateRequest;
import kr.inplat.sample2.service.AuthorizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/authorization-practice")
@RequiredArgsConstructor
public class AuthorizationController {

    public final AuthorizationService authorizationService;

    @GetMapping("")
    public ResponseEntity<List<Authorization>> getAuthorizationList() {
        return new ResponseEntity<>(authorizationService.getAuthorizationList(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Authorization> getAuthorization(@PathVariable("id") Authorization authorization) {
        return new ResponseEntity<>(authorizationService.getAuthorization(authorization), HttpStatus.OK);
    }

    @PostMapping("/{createdBy}")
    public ResponseEntity<String> createAuthorization(@PathVariable("createdBy") String createdBy, @RequestBody AuthorizationCreateRequest authorizationCreateRequest) {
        return ResponseEntity.ok()
                .body(authorizationService.createAuthorization(createdBy, authorizationCreateRequest).getId());
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateAuthorization(@PathVariable("id") String id, @RequestBody AuthorizationUpdateRequest authorizationUpdateRequest) {
        return ResponseEntity.ok()
                .body(authorizationService.updateAuthorization(id, authorizationUpdateRequest).getId());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAuthorization(@PathVariable("id") String id) {
        return ResponseEntity.ok()
                .body(authorizationService.deleteAuthorization(id).getId());
    }
}
