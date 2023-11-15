package com.viepovsky.recommendation;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
class Recommendation {
    @Id
    @SequenceGenerator(
            name = "recommendation_id_sequence",
            sequenceName = "recommendation_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "recommendation_id_sequence",
            strategy = GenerationType.SEQUENCE
    )
    private Long id;
    private Long barberId;
    private boolean isRecommended;
    private LocalDateTime recommendationCheckTime;
}
