package com.eazybytes.loans.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

@Schema(
        name = "Loans Request",
        description = "Schema to hold Loan information while creating the loan"
)
@Data
public class LoanRequestDto {
    @Schema(
            description = "Mobile number of Customer"
    )
    @NotNull(message = "Mobile number can not be null or empty.")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits.")
    private String mobileNumber;

    @Schema(
            description = "Loan Type of loan"
    )
    @NotNull(message = "Loan Type can not be null or empty.")
    private String loanType;

    @Schema(
            description = "Total loan amount against the loan"
    )
    @NotNull(message = "Total loan can not be null or empty.")
    @Positive(message = "Total loan should be greater than zero.")
    private int totalLoan;

    @Schema(
            description = "Total outstanding amount against the loan"
    )
    @NotNull(message = "Outstanding amount can not be null or empty.")
    @Positive(message = "Outstanding amount should be greater than zero.")
    private int outstandingAmount;

    @Schema(
            description = "Amount paid till now"
    )
    @NotNull(message = "Amount Paid can not be null or empty.")
    @PositiveOrZero(message = "Amount Paid should be greater than zero or equals to zero.")
    private int amountPaid;

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getLoanType() {
        return loanType;
    }

    public int getTotalLoan() {
        return totalLoan;
    }

    public void setTotalLoan(int totalLoan) {
        this.totalLoan = totalLoan;
    }

    public int getOutstandingAmount() {
        return outstandingAmount;
    }

    public void setOutstandingAmount(int outstandingAmount) {
        this.outstandingAmount = outstandingAmount;
    }

    public int getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(int amountPaid) {
        this.amountPaid = amountPaid;
    }

}
