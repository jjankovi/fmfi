package sk.fmfi.resource.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class FeeDTO {

    private String transactionId;
    private String acno;
    private BigDecimal transactionAmount;

}
