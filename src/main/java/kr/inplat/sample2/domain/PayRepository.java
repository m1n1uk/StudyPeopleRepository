package kr.inplat.sample2.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

// 지출 repository
public interface PayRepository extends JpaRepository<Pay, String> {

    // 지출 목록
    List<Pay> findByAbleTrue();

    // 지출 상세
    Optional<Pay> findById(String id);
}
