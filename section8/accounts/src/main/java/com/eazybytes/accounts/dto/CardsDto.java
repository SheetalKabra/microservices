package com.eazybytes.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

@Schema(
        name = "Loans",
        description = "Schema to hold Loans information"
)
@Data
public class CardsDto {
    @Schema(
            description = "Mobile number of Customer"
    )
    @NotNull(message = "Mobile Number can not be null or empty.")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile Number must be 10 digits.")
    private String mobileNumber;

    @Schema(
            description = "Card number of Customer"
    )
    @NotNull(message = "Card Number can not be null or empty.")
    private String cardNumber;

    @Schema(
            description = "Card Type of Card"
    )
    @NotNull(message = "Card Type can not be null or empty.")
    private String cardType;

    @Schema(
            description = "Total Limit of Card"
    )
    @NotNull(message = "Total Limit can not be null or empty.")
    @PositiveOrZero(message = "Total Limit can be zero or positive.")
    private int totalLimit;

    @Schema(
            description = "Amount Used of Card"
    )
    @NotNull(message = "Amount Used can not be null or empty.")
    @PositiveOrZero(message = "Amount Used can be zero or positive.")
    private int amountUsed;

    @Schema(
            description = "Available Amount of Card"
    )
    @NotNull(message = "Available Amount can not be null or empty.")
    @Positive(message = "Available Amount should be greater than zero.")
    private int availableAmount;

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public int getTotalLimit() {
        return totalLimit;
    }

    public void setTotalLimit(int totalLimit) {
        this.totalLimit = totalLimit;
    }

    public int getAmountUsed() {
        return amountUsed;
    }

    public void setAmountUsed(int amountUsed) {
        this.amountUsed = amountUsed;
    }

    public int getAvailableAmount() {
        return availableAmount;
    }

    public void setAvailableAmount(int availableAmount) {
        this.availableAmount = availableAmount;
    }
}
