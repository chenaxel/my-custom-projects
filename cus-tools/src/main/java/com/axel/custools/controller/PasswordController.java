package com.axel.custools.controller;

import com.axel.common.constant.ReturnMsgVO;
import com.axel.common.constant.password.PasswordParam;
import com.axel.common.constant.password.PasswordResult;
import com.axel.custools.utils.PasswordUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/password")
public class PasswordController {

    @PostMapping("/generate")
    public ReturnMsgVO<PasswordResult> generate(@RequestBody PasswordParam param) {
        PasswordResult result = new PasswordResult();
        String pwd = PasswordUtil.generatePassword(param);
        result.setPassword(pwd);
        result.setLevel(PasswordUtil.getPasswordLevel(param));
        return new ReturnMsgVO<PasswordResult>().ok(result);
    }
}
