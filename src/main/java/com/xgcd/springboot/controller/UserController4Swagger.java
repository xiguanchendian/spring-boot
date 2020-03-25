package com.xgcd.springboot.controller;

import com.xgcd.springboot.bean.RespBean4Swagger;
import com.xgcd.springboot.bean.User4Swagger;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = "用户管理相关接口")
@RequestMapping("/user")
public class UserController4Swagger {

    @PostMapping("/")
    @ApiOperation("添加用户的接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", defaultValue = "张三"),
            @ApiImplicitParam(name = "address", value = "用户地址", defaultValue = "北京", required = true)
    })
    public RespBean4Swagger addUser(String username, @RequestParam(required = true) String address) {

        User4Swagger user = new User4Swagger();
        user.setUsername(username);
        user.setAddress(address);

        RespBean4Swagger resp = RespBean4Swagger.ok("添加用户成功", user);
        return resp;
    }

    @GetMapping("/{id}")
    @ApiOperation("根据id查询用户的接口")
    @ApiImplicitParam(name = "id", value = "用户id", defaultValue = "99", required = true)
    public User4Swagger getUserById(@PathVariable Integer id) {
        User4Swagger user = new User4Swagger();
        user.setId(id);
        return user;
    }

    @PutMapping("/")
    @ApiOperation("根据id更新用户的接口")
    public User4Swagger updateUserById(@RequestBody User4Swagger user) {

        return user;
    }
}
