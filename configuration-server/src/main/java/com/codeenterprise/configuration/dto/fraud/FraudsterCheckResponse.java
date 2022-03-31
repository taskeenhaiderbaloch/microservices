package com.codeenterprise.configuration.dto.fraud;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FraudsterCheckResponse {

    private Boolean isFraudster;
}
