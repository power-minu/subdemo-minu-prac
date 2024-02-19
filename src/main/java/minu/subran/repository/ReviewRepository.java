package minu.subran.repository;

import minu.subran.domain.Member;
import minu.subran.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    List<Review> findByMember(Member member);
}
