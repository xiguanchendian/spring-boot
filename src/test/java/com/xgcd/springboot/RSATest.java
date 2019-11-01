package com.xgcd.springboot;

import java.util.UUID;

public class RSATest {
    public static void main(String[] args) {
//        String privateKey = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAMlEZXt7J32l4s84\n" +
//                "ioWDeiKidaqmauNWKTbDInNaq/yK3fIC+j+jg5HjTJutk8ernbqTqeC+oc4I0m+G\n" +
//                "s3vBc1QQhP49fIu7B9Y/TgjgQMFLcGfctxMwCcZWgiRrR/k7qWjcjRi09bCfKFxC\n" +
//                "Gsda5OJ60YLQI3C54jXUm6rw1XafAgMBAAECgYAii9PjcwsfPQcGTI0yR5QCN+J8\n" +
//                "jR4RsWtXk/zo0eptaaSY8rvjinx94Qb4Pb386s8jBE+HXRFG3SrJq9RI7LaPrGjU\n" +
//                "3qbURTExr9qRo9//eR9VahCKyftryRkeXGqBcOreDgbiTb6wYzUL9OdgSV4to4hz\n" +
//                "7oIBmnal3+oy5grpIQJBAOgQwoMgAQfjfDSeBcXRklLestWvHRxLu3mpgcvcqHWm\n" +
//                "eH6HdSxBidJlu0U14QkruvxOZAeW0Y4iu20LY0JKZY8CQQDeBneXmEJr1Pnd/GAU\n" +
//                "o61i9xpKJOmGmFaiM78DE+JYFdnim+wdye1z/u7GPuD6HmcQC3kb7zpSRVSdOWsn\n" +
//                "xvXxAkEAhJBWXMsia5wybmg6ifcebAJVDCW9LlXAoU4IHClPfe17dWPxtjc2AJ8m\n" +
//                "a/HMPA3kAY7SK1enG1eR00enCs4u1wJBAJitY9H4Xzyd0VGIul2XDKVwfUCdT4VB\n" +
//                "/tk9sk2gf9bI9/Mv+9ekQ0iv92yWUslM3NyYtyixgq6OhJg1ou1QkVECQB3Vu4Kv\n" +
//                "KafP5ejMPe3XplyDI20HJbHlAWH5NGZ67oRWLsVnKAIyLxZRhF4LPXew3gC9BVFC\n" +
//                "w8zj1geO42oOAso=\n";
        String privateKey = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAMlEZXt7J32l4s84" +
                "ioWDeiKidaqmauNWKTbDInNaq/yK3fIC+j+jg5HjTJutk8ernbqTqeC+oc4I0m+G" +
                "s3vBc1QQhP49fIu7B9Y/TgjgQMFLcGfctxMwCcZWgiRrR/k7qWjcjRi09bCfKFxC" +
                "Gsda5OJ60YLQI3C54jXUm6rw1XafAgMBAAECgYAii9PjcwsfPQcGTI0yR5QCN+J8" +
                "jR4RsWtXk/zo0eptaaSY8rvjinx94Qb4Pb386s8jBE+HXRFG3SrJq9RI7LaPrGjU" +
                "3qbURTExr9qRo9//eR9VahCKyftryRkeXGqBcOreDgbiTb6wYzUL9OdgSV4to4hz" +
                "7oIBmnal3+oy5grpIQJBAOgQwoMgAQfjfDSeBcXRklLestWvHRxLu3mpgcvcqHWm" +
                "eH6HdSxBidJlu0U14QkruvxOZAeW0Y4iu20LY0JKZY8CQQDeBneXmEJr1Pnd/GAU" +
                "o61i9xpKJOmGmFaiM78DE+JYFdnim+wdye1z/u7GPuD6HmcQC3kb7zpSRVSdOWsn" +
                "xvXxAkEAhJBWXMsia5wybmg6ifcebAJVDCW9LlXAoU4IHClPfe17dWPxtjc2AJ8m" +
                "a/HMPA3kAY7SK1enG1eR00enCs4u1wJBAJitY9H4Xzyd0VGIul2XDKVwfUCdT4VB" +
                "/tk9sk2gf9bI9/Mv+9ekQ0iv92yWUslM3NyYtyixgq6OhJg1ou1QkVECQB3Vu4Kv" +
                "KafP5ejMPe3XplyDI20HJbHlAWH5NGZ67oRWLsVnKAIyLxZRhF4LPXew3gC9BVFC" +
                "w8zj1geO42oOAso=";

        String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDJRGV7eyd9peLPOIqFg3oionWq" +
                "pmrjVik2wyJzWqv8it3yAvo/o4OR40ybrZPHq526k6ngvqHOCNJvhrN7wXNUEIT+" +
                "PXyLuwfWP04I4EDBS3Bn3LcTMAnGVoIka0f5O6lo3I0YtPWwnyhcQhrHWuTietGC" +
                "0CNwueI11Juq8NV2nwIDAQAB";

        System.out.println(privateKey);
        System.out.println(publicKey);

        double random = Math.random();
        System.out.println(random);

        UUID uuid = UUID.randomUUID();
        System.out.println(uuid.toString().replace("-",""));
    }
}
