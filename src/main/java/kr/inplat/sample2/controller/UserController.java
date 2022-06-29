package kr.inplat.sample2.controller;

import kr.inplat.sample2.domain.User;
import kr.inplat.sample2.protocol.UserRequest;
import kr.inplat.sample2.protocol.UserResponse;
import kr.inplat.sample2.service.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

// 사용자관리 서블렛
// @Slf4j4
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user-practice")
public class UserController {

    Log log = LogFactory.getLog(getClass());

    // 서비스 호출
    private final UserService userService;

    // 사용자 목록
    @GetMapping("")
    public List<UserResponse> userList(){
        return userService.userList();
    }

    // 사용자 상세
    @GetMapping("/{id}")
    public UserResponse userDetail(@PathVariable("id") User user){  // User타입이 아닌, String타입으로 id만 받아와도 가능.
        return userService.userDetail(user);
    }

    // 사용자 등록
    @PostMapping("")
    public boolean userInsert(@RequestBody UserRequest userRequest){
        return userService.userInsert(userRequest);
    }

    @PostMapping("/map")
    public Map<String,Object> postUser(@RequestBody UserRequest userRequest){
        return userService.postUser(userRequest);
    }

    // 사용자 수정
    @PutMapping("")
    public boolean userUpdate(@RequestBody UserRequest userRequest){
        return userService.userUpdate(userRequest);
    }

    @PutMapping("/{id}")
    public Map<String, Object> putUser(@PathVariable("id") User user, @RequestBody UserRequest request) {
        return userService.putUser(user, request);
    }

    // 사용자 삭제
    @DeleteMapping("/{id}")
    public boolean userDelete(@PathVariable("id")String id){
        return userService.userDelete(id);
    }

    @DeleteMapping("/map/{id}")
    public Map<String, Object> userDelete(@PathVariable("id")User user){
        return userService.deleteUser(user);
    }

    // 사용자 검색
    @GetMapping("/search")
    public List<UserResponse> searchList(UserRequest user){
        return userService.searchList(user);
    }
}
