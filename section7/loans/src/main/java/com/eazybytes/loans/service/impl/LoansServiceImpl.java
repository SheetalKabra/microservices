package com.eazybytes.loans.service.impl;

import com.eazybytes.loans.dto.LoanRequestDto;
import com.eazybytes.loans.dto.LoansDto;
import com.eazybytes.loans.entity.Loans;
import com.eazybytes.loans.exception.LoanAlreadyExistsException;
import com.eazybytes.loans.exception.ResourceNotFoundException;
import com.eazybytes.loans.mapper.LoansMapper;
import com.eazybytes.loans.repository.LoanRepository;
import com.eazybytes.loans.service.ILoansService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class LoansServiceImpl implements ILoansService {
    private LoanRepository loanRepository;

    public LoansServiceImpl(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    @Override
    public void createLoans(LoanRequestDto loanRequestDto) {
        Optional<Loans> optionalLoans = loanRepository.findByMobileNumber(loanRequestDto.getMobileNumber());
        if(optionalLoans.isPresent()){
            throw new LoanAlreadyExistsException("Loan already registered with this mobile number : "+loanRequestDto.getMobileNumber());
        }
        loanRepository.save(createNewLoan(loanRequestDto));
    }

    private Loans createNewLoan(LoanRequestDto loanRequestDto){
        Loans loans = new Loans();
        long randLoanNumber = 100000000000L + new Random().nextInt(900000000);
        loans.setLoanNumber(Long.toString(randLoanNumber));
        loans.setLoanType(loanRequestDto.getLoanType());
        loans.setMobileNumber(loanRequestDto.getMobileNumber());
        loans.setTotalLoan(loanRequestDto.getTotalLoan());
        loans.setOutstandingAmount(loanRequestDto.getOutstandingAmount());
        loans.setAmountPaid(loanRequestDto.getAmountPaid());
        return loans;
    }

    @Override
    public LoansDto fetchLoan(String mobileNumber) {
        Loans loans = loanRepository.findByMobileNumber(mobileNumber)
                .orElseThrow(() -> new ResourceNotFoundException("Loan", "mobileNumber", mobileNumber));
        return LoansMapper.mapToLoansDto(loans, new LoansDto());
    }

    @Override
    public boolean updateLoan(LoansDto loansDto) {
        Loans loans = loanRepository.findByMobileNumber(loansDto.getMobileNumber())
                .orElseThrow(() -> new ResourceNotFoundException("Loan", "mobileNumber", loansDto.getMobileNumber()));
        LoansMapper.mapToLoans(loansDto, loans);
        loanRepository.save(loans);
        return true;
    }

    @Override
    public boolean deleteLoan(String mobileNumber) {
        Loans loans = loanRepository.findByMobileNumber(mobileNumber)
                .orElseThrow(() -> new ResourceNotFoundException("Loan", "mobileNumber", mobileNumber));
        loanRepository.deleteByMobileNumber(mobileNumber);
        return true;
    }
}
