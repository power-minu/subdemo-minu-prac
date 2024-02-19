package minu.subran.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/prac")
public class PracticeController {

    @GetMapping("")
    public String prac() {
        return "로그인 인증을 테스트합시다.";
    }
}
