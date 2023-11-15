package com.viepovsky.recommendation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface RecommendationRepository extends JpaRepository<Recommendation, Long> {
}
