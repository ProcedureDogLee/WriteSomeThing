package com.dragon.hei.wsth.controller;

import com.dragon.hei.wsth.mapper.TmpUserMapper;
import com.dragon.hei.wsth.mapper.po.TmpUser;
import com.dragon.hei.wsth.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: lilong
 **/
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private TmpUserMapper tmpUserMapper;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseVo<Integer> addUser(@RequestBody TmpUser user){
        try {
            return ResponseVo.success(tmpUserMapper.insert(user));
        }catch (Exception e){
            log.error("创建用户失败: {}", e);
            return ResponseVo.fail(e.getMessage());
        }
    }



}
