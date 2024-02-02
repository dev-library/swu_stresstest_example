package kr.swu.spring_rest.controller;

import jakarta.xml.bind.DatatypeConverter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@RestController
public class CpuBoundController {
    // 인프라를 터뜨려버리는 어플리케이션 유형이 2가지 있음
    // 1. cpubound application : 과도한 연산으로 씨피유 자원을 소모하는 유형
    // 2. iobound application : DB등에 대해 입출력을 과도하게 해서 자원을 소모하는 유형

    @RequestMapping("/hash")
    public String getHash(String input) throws NoSuchAlgorithmException{
        String output = input;
        for(int i = 0; i < 100_000; i++){
            output = getMD5(output);
        }
        return output;
    }

    private String getMD5(String input) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(input.getBytes());
        byte[] digest = md.digest();
        String resultHash = DatatypeConverter.printHexBinary(digest).toUpperCase();
        return resultHash;
    }


}
