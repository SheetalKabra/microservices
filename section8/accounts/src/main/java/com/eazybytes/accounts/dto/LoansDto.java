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
public class LoansDto {

    @Schema(
            description = "Mobile number of Customer"
    )
    @NotNull(message = "Mobile Number can not be null or empty.")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile Number must be 10 digits.")
    private String mobileNumber;

    @Schema(
            description = "Loan number of Customer"
    )
    @NotNull(message = "Loan Number can not be null or empty.")
    @Pattern(regexp = "(^$|[0-9]{12})", message = "Loan Number must be 12 digits.")
    private String loanNumber;

    @Schema(
            description = "Type of Loan", example = "Home Loan"
    )
    @NotNull(message = "Loan Type can not be null or empty.")
    private String loanType;

    @Schema(
            description = "Total Loan Amount"
    )
    @Positive(message = "Total Loan Amount should be greater than zero.")
    private int totalLoan;

    @Schema(
            description = "Amount paid till now"
    )
    @PositiveOrZero(message = "Total Amount Paid should be greater than or equals to zero.")
    private int amountPaid;

    @Schema(
            description = "Total outstanding amount against the loan"
    )
    @PositiveOrZero(message = "Total Outstanding Amount should be greater than or equals to zero.")
    private int outstandingAmount;

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getLoanNumber() {
        return loanNumber;
    }

    public void setLoanNumber(String loanNumber) {
        this.loanNumber = loanNumber;
    }

    public String getLoanType() {
        return loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    public int getTotalLoan() {
        return totalLoan;
    }

    public void setTotalLoan(int totalLoan) {
        this.totalLoan = totalLoan;
    }

    public int getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(int amountPaid) {
        this.amountPaid = amountPaid;
    }

    public int getOutstandingAmount() {
        return outstandingAmount;
    }

    public void setOutstandingAmount(int outstandingAmount) {
        this.outstandingAmount = outstandingAmount;
    }
}
