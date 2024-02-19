package minu.subran.service;

import lombok.RequiredArgsConstructor;
import minu.subran.domain.*;
import minu.subran.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ReviewService {

    private final MemberRepository memberRepository;
    private final RecipeRepository recipeRepository;
    private final ReviewRepository reviewRepository;
    private final HeartRepository heartRepository;

    @Transactional
    public Long join(Long memberId, Long recipeId, Float score, String comment) {
        Optional<Member> member = memberRepository.findById(memberId);
        Recipe recipe = recipeRepository.findOne(recipeId);

        Review review = Review.createReview(member.get(), recipe, score, comment);

        reviewRepository.save(review);

        return review.getId();
    }

    public List<Review> findReviews() {
        return reviewRepository.findAll();
    }

    public List<Review> findMemberHeartReviews(Member member) {
        List<Heart> heartList = heartRepository.findByMember(member);

        List<Review> heartReviews = new ArrayList<>();
        for (Heart heart : heartList) {
            Review review = heart.getReview();
            heartReviews.add(review);
        }
        return heartReviews;
    }

    public List<Review> findReviewsByMember(Member member) {
        return reviewRepository.findByMember(member);
    }
}
