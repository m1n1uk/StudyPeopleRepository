package kr.inplat.sample2.service;

import kr.inplat.sample2.domain.User;
import kr.inplat.sample2.domain.UserRepository;
import kr.inplat.sample2.protocol.UserRequest;
import kr.inplat.sample2.protocol.UserResponse;
import lombok.RequiredArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    Log log = LogFactory.getLog(getClass());

    private final UserRepository userRepository;

    // 사용자 목록
    @Transactional(readOnly = true)
    public List<UserResponse> userList() {
        List<User> users = userRepository.findByAbleTrue();
        return users.stream().map(user -> {
            UserResponse userResponse = new UserResponse();
            BeanUtils.copyProperties(user, userResponse);
            return userResponse;
        }).collect(Collectors.toList());
    }
    
    // 사용자 상세
    @Transactional(readOnly = true)
    public UserResponse userDetail(User user) {
        // 레포지토리에서 id값으로 상세정보 받아온다
        Optional<User> repositoryUser = userRepository.userDetail(user.getId());
        UserResponse response = null;

        // User userEntity = user.orElse(null); => user가 null일 경우, null로 대입하라.
        // BeanUtils.copyProperties(userEntity, response);  => Entity에서 받은 값을 response instance에 대입

        if(repositoryUser.isPresent()){   // user != null
            // 반환할 UserResponse instance 생성 도출시킬 값들을 set
            response = UserResponse.builder()
                    .id(repositoryUser.get().getId())
                    .name(repositoryUser.get().getName())
                    .birthday(repositoryUser.get().getBirthday())
                    .phone(repositoryUser.get().getPhone())
                    .build();
        }
        return response;
    }

    // 사용자 등록
    @Transactional
    public boolean userInsert(UserRequest request) {
        log.info("request : " + request);
        User user = User.builder()
                .name(request.getName())
                .birthday(request.getBirthday())
                .phone(request.getPhone())
                .build();
        log.info("user : " + user);
        userRepository.save(user);

        return true;
    }

    @Transactional
    public Map<String, Object> postUser(UserRequest request) {
        Map<String, Object> result = new HashMap<String, Object>();
        
        // db에서 name과 같은 값을 가진 정보를 가져와, 해당 정보의 이름을 변수에 담는다.
        String name = userRepository.getByName(request.getName()).get().getName();
        // 해당 이름이 받아온 요청이름과 같다면
        if (request.getName().equals(name)) {
            // 중복메세지를 도출하는 순서
            result.put("success", false);
            result.put("message", "이미 등록된 사용자 입니다.");
            return result;
        }
        
        // 새로운 user객체를 생성
        User user = new User();
        user.setName(request.getName());
        user.setBirthday(request.getBirthday());
        user.setPhone(request.getPhone());
        // 해당객체의 정보를 모두 담아 save -> insert(식별자가 없으므로)
        userRepository.save(user);

        // result success
        result.put("success", true);
        result.put("message", "작성 성공");
        return result;
    }

    // 사용자 수정
    @Transactional
    public boolean userUpdate(UserRequest request) {
        User user = User.builder()
                .id(request.getId())
                .name(request.getName())
                .birthday(request.getBirthday())
                .phone(request.getPhone())
                .build();
        userRepository.save(user);

        return true;
    }

    @Transactional
    public Map<String, Object> putUser(User user, UserRequest request) {
        Map<String, Object> result = new HashMap<>();
        user.setName(request.getName());
        user.setBirthday(request.getBirthday());
        user.setPhone(request.getPhone());
        user.setUpdateTime(LocalDateTime.now());
        userRepository.save(user);

        result.put("success", true);
        result.put("message", "수정 성공");
        return result;
    }

    // 사용자 삭제
    @Transactional
    public boolean userDelete(String id){
        User user = User.builder()
                .id(id)
                .able(false)
                .build();
        userRepository.save(user);
        return true;
    }

    @Transactional
    public Map<String, Object> deleteUser(User user) {
        Map<String, Object> result = new HashMap<>();

        user.setAble(false);
        user.setUpdateTime(LocalDateTime.now());
        userRepository.save(user);

        result.put("success", true);
        result.put("message", "삭제 성공");
        return result;
    }

    // 사용자 검색
    @Transactional
    public List<UserResponse> searchList(UserRequest user){
        // 리스트 선언
        List<User> searchList;

        log.info("user -> " + user );
        
        // 매개변수 값 비교
        if(user.getName() != ""){ // 이름 값이 있는지
            if(user.getBirthday() != ""){   // 날짜 값 확인
                log.info("(전체)유저값에 담긴 NAME : " + user.getName());
                log.info("(전체)유저값에 담긴 BIRTHDAY : " + user.getBirthday());
                // 두 값을 포함한 데이터 도출
                searchList = userRepository.searchNameAndBirthday(user.getName(), user.getBirthday());
            }else {
                log.info("유저값에 담긴 NAME : " + user.getName());
                // 이름 값 리스트 도출
                searchList = userRepository.searchName(user.getName());
            }
        }else{
            if(user.getBirthday() != "") {   // 날짜 값 확인
                log.info("유저값에 담긴 BIRTHDAY : " + user.getBirthday());
                // 날짜 값 리스트 도출
                searchList = userRepository.findByAbleTrueAndBirthdayContainingOrderByCreateDate(user.getBirthday());
            }else{
                log.info("둘 다 null일 경우");
                searchList = userRepository.findByAbleTrue();
            }
        }
        // 리스트형식 response형식으로 변환
        return searchList.stream().map(search -> {
            UserResponse userResponse = new UserResponse();
            BeanUtils.copyProperties(search, userResponse);
            return userResponse;
        }).collect(Collectors.toList());
    }
}
