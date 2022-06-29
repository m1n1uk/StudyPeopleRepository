package kr.inplat.sample2.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

// 사용자 repository
public interface UserRepository extends JpaRepository<User, String> {

    // 사용자 목록
    List<User> findByAbleTrue();

    @Query("SELECT u FROM User u WHERE u.able = true AND u.name = :name ORDER BY u.createDate")
    List<User> findByAbleTrueAndName(@Param("name") String user);

    // 이름과 날짜 값을 포함한 목록
    @Query("SELECT u FROM User u WHERE u.able = true AND u.name LIKE CONCAT('%',:name,'%') AND DATE_FORMAT(u.birthday, '%Y-%m') = :birthday ORDER BY u.createDate")
    List<User> searchNameAndBirthday(@Param("name")String name, @Param("birthday")String birthday);

    // 이름 값을 포함한 목록
    @Query("SELECT u FROM User u WHERE u.able = true AND u.name LIKE CONCAT('%',:name,'%') ORDER BY u.createDate")
    List<User> searchName(@Param("name")String name);
    // List<User> findByAbleTrueAndNameLikeOrderByCreateDate(@Param("name") String name);

    // 날짜 값을 포함한 목록
    // List<User> findByAbleTrueAndBirthdaygreatThenEqualOrderByCreateDate(String birthday);

    // @Query("SELECT u FROM User u WHERE u.able = true AND u.birthday >= :birthday ORDER BY u.createDate")
    @Query("SELECT u FROM User u WHERE u.able = true AND DATE_FORMAT(u.birthday, '%Y-%m') = :birthday ORDER BY u.createDate")
    List<User> searchBirthday(@Param("birthday") String birthday);

    // findBy -> Containing = like와 같은 의미**
    List<User> findByAbleTrueAndBirthdayContainingOrderByCreateDate(String birthday);
    // List<User> findByAbleTrueBrithDayLessThen(String birthDay);
    // lessThen(lessThenEqual)->작다 greatThen(greatThenEqual)->크다

    @Query("SELECT u FROM User u WHERE u.name = :name")
    Optional<User> getByName(@Param("name") String name);

    // 사용자 상세
    Optional<User> findById(String id);

    @Query("SELECT u FROM User u WHERE u.id = :id")
    Optional<User> userDetail(@Param("id")String userId);
}
