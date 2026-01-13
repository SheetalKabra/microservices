package com.eazybytes.accounts.service;

import com.eazybytes.accounts.dto.CustomerDetailsDto;

public interface ICustomerService {

    /**
     *
     * @param mobileNumber
     * @return Customer details based on mobile number
     */
    public CustomerDetailsDto fetchCustomerDetails(String mobileNumber);
}
