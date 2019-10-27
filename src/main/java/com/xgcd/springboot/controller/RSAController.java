package com.xgcd.springboot.controller;

import com.xgcd.springboot.utils.RSAEnDeUtils;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.KeyPair;

import static com.xgcd.springboot.utils.RSAEnDeUtils.sign;

@Component
@RequestMapping("/rsa")
public class RSAController {

    @ResponseBody
    @RequestMapping("/responseEncryptContent")
    public String responseEncryptContent() {
        String data = "123456";
        String sign = null;
        try {
            KeyPair keyPair = RSAEnDeUtils.getKeyPair();
            String privateKey = new String(Base64.encodeBase64(keyPair.getPrivate().getEncoded()));
            sign = sign(data, RSAEnDeUtils.getPrivateKey(privateKey));
            System.out.println("签名:" + sign);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sign;
    }
}
