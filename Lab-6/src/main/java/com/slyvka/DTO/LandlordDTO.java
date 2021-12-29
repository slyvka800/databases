package com.slyvka.DTO;

import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class LandlordDTO {
    private Integer id;
    private String name;
    private String surname;
    private BigDecimal moneyBalance;
}
