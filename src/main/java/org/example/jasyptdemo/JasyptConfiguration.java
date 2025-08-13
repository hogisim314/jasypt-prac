package org.example.jasyptdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class JasyptConfiguration {

    @Autowired
    private Environment env;
    @Bean("jasyptStringEncryptor")
    public StringEncryptor stringEncryptor() {

        String password = "LOCAL";

        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
        // 암호화 키 (환경변수나 외부 설정에서 주입)
        config.setPassword(password);
        // 알고리즘 설정
        config.setAlgorithm("PBEWithMD5AndDES");
        // 풀 크기
        config.setPoolSize("1");
        // 출력 인코딩
        config.setStringOutputType("base64");
        // 반복 횟수
        config.setKeyObtentionIterations("1000");
        // 솔트 생성기
        config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
        encryptor.setConfig(config);
        return encryptor;
    }
}