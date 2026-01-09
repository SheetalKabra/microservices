package com.eazybytes.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Schema(
        name = "Accounts",
        description = "Schema to hold Accounts information"
)
@Data
public class AccountsDto {
    @Schema(
            description = "Account number of Eazy bank"
    )
    @NotEmpty(message = "Account Number can not be null or empty.")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Account number must be 10 digits.")
    private Long accountNumber;
    @Schema(
            description = "Account type of Eazy bank", example = "Savings or current"
    )
    @NotEmpty(message = "Account Type can not be null or empty.")
    private String accountType;
    @Schema(
            description = "Branch address of Eazy bank"
    )
    @NotEmpty(message = "Branch address can not be null or empty.")
    private String branchAddress;
}
