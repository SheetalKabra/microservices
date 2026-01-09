package com.eazybytes.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(
        name = "Customer",
        description = "Schema to hold Customer and Accounts information"
)
public class CustomerDto {
    @Schema(
            description = "Name of the customer", example = "Eazy bytes"
    )
    @NotEmpty(message = "Name can not be null or empty.")
    @Size(min=3, max=30, message = "The length of customer name should be in between 3 to 30.")
    private String name;
    @Schema(
            description = "Email of the customer", example = "tutor@eazybytes.com"
    )
    @NotEmpty(message = "Email address can not be null or empty.")
    @Email(message = "Email should be in valid format")
    private String email;
    @Schema(
            description = "Mobile of the customer", example = "8971897011"
    )
    @NotEmpty(message = "Mobile number can not be null or empty.")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits.")
    private String mobileNumber;

    private AccountsDto accountsDto;
}
