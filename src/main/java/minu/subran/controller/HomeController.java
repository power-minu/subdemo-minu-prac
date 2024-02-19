package minu.subran.controller;

import lombok.RequiredArgsConstructor;
import minu.subran.argumentresolver.Login;
import minu.subran.domain.Member;
import minu.subran.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = {"", "/"})
public class HomeController {

    private final MemberService memberService;

    @GetMapping(value = {"", "/"})
    public String home(@Login Long memberId, Model model) {

        Member loginMember = memberService.getLoginMemberById(memberId);

        if (loginMember != null) {
            model.addAttribute("memberName", loginMember.getName());
        }
        return "main";
    }
}
