package minu.subran.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import minu.subran.domain.Member;
import minu.subran.dto.LoginRequest;
import minu.subran.dto.RecipeRequest;
import minu.subran.service.MemberService;
import minu.subran.service.RecipeService;
import minu.subran.service.SaveService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/recipe")
public class RecipeController {

    private final MemberService memberService;
    private final RecipeService recipeService;
    private final SaveService saveService;

    @GetMapping("/custom")
    public String custom(Model model) {

        model.addAttribute("recipeRequest", new RecipeRequest());

        return "custom";
    }

    @PostMapping("/custom")
    public String customSave(@Valid @ModelAttribute RecipeRequest recipeRequest,
                             @SessionAttribute(name = "memberId", required = false) Long memberId,
                             Model model) {

        Member loginMember = memberService.getLoginMemberById(memberId);
        System.out.println("loginMember = " + loginMember);

        if (loginMember != null) {
            Long recipeId = recipeService.join(recipeRequest);
            saveService.join(memberId, recipeId);
        }
        if (loginMember == null) {
            model.addAttribute("loginType", "session-login");
            model.addAttribute("pageName", "세션 로그인");

            model.addAttribute("loginRequest", new LoginRequest());

            return "login";
        }

        return "redirect:/";
    }
}
