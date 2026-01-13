package com.eazybytes.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(
        name = "Customer Details",
        description = "Schema to hold Customer Details, Accounts, Loans and Cards information"
)
public class CustomerDetailsDto {
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

    private LoansDto loansDto;
    private CardsDto cardsDto;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public AccountsDto getAccountsDto() {
        return accountsDto;
    }

    public void setAccountsDto(AccountsDto accountsDto) {
        this.accountsDto = accountsDto;
    }

    public LoansDto getLoansDto() {
        return loansDto;
    }

    public void setLoansDto(LoansDto loansDto) {
        this.loansDto = loansDto;
    }

    public CardsDto getCardsDto() {
        return cardsDto;
    }

    public void setCardsDto(CardsDto cardsDto) {
        this.cardsDto = cardsDto;
    }
}
