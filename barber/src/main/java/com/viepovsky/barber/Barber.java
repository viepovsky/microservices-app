package com.viepovsky.barber;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
class Barber {
    @Id
    @SequenceGenerator(
            name = "barber_id_sequence",
            sequenceName = "barber_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "barber_id_sequence",
            strategy = GenerationType.SEQUENCE
    )
    private Long id;
    private String firstName;
    private String lastName;
    private String company;
    private String email;
}
