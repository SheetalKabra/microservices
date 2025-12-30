package com.eazybytes.accounts.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class AccountsDto {
    @NotEmpty(message = "Account Number can not be null or empty.")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Account number must be 10 digits.")
    private Long accountNumber;
    @NotEmpty(message = "Account Type can not be null or empty.")
    private String accountType;
    @NotEmpty(message = "Branch address can not be null or empty.")
    private String branchAddress;
}
