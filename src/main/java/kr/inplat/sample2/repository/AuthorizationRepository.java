package kr.inplat.sample2.repository;

import kr.inplat.sample2.domain.Authorization;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorizationRepository extends JpaRepository<Authorization, String> {
    List<Authorization> findByDeletedFalse();
}
