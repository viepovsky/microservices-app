package com.viepovsky.barber;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
class Barber {
    private Integer id;
    private String firstName;
    private String lastName;
    private String company;
    private String email;
}
