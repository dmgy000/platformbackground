package com.platform.platformbackground.Controller;

import com.platform.platformbackground.Entity.User;
import com.platform.platformbackground.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import com.platform.platformbackground.util.JwtUtil;
import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Slf4j
@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/find")
    public User login(User user){
        String name=user.getUserName();
        User user1=userRepository.selectUser(name);
        if(user1==null) return null;
        String password=user.getPassword();
        if(password.equals(user1.getPassword())){
            user1.setToken(JwtUtil.createtoken());
            return user1;
        }else{
            return null;
        }
    }

    @GetMapping("insert/{name}/{pwd}/{school}/{num}")
    public String insert(@PathVariable("name")String name,@PathVariable("pwd")String password,
                         @PathVariable("school")String school,@PathVariable("num")Integer number){
        if(StringUtils.isEmpty(name)||StringUtils.isEmpty(password)||StringUtils.isEmpty(school)||number==null){
            return "不能为空";
        }
        User user = userRepository.selectUser(name);
        if(user==null){
            int result=userRepository.insertUser(name,password,school,number);
            if(result!=0)return "成功";
            else return "密码错误";
        }
        return "已有此人";

    }

    @GetMapping("/checkToken")
    public boolean checkToken(HttpServletRequest request){
        String token = request.getHeader("token");
        return JwtUtil.checkToken(token);
    }

}
