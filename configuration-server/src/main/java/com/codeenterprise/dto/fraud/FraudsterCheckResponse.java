package com.codeenterprise.dto.fraud;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FraudsterCheckResponse {

    private Boolean isFraudster;
}
