package minu.subran.controller;

import lombok.RequiredArgsConstructor;
import minu.subran.service.ReviewService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("reviews/")
public class ReviewController {

    private ReviewService reviewService;

    @GetMapping(value = {"", "/"})
    public String reviews(Model model) {

        model.addAttribute("reviews", reviewService.findReviews());

        return "reviews";
    }
}
