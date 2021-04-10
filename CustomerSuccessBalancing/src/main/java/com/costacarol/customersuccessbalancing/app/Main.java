package com.costacarol.customersuccessbalancing.app;

import com.costacarol.customersuccessbalancing.service.CustomerSuccessBalancingService;

public class Main {

    public static void main(String[] args) {

        CustomerSuccessBalancingService customerSuccessBalancingService = new CustomerSuccessBalancingService();

        customerSuccessBalancingService
                .addNewCustomerSuccess(1, 54);
        customerSuccessBalancingService
                .addNewCustomerSuccess(2, 20);
        customerSuccessBalancingService
                .addNewCustomerSuccess(3, 43);
        customerSuccessBalancingService
                .addNewCustomerSuccess(4, 77);
        customerSuccessBalancingService
                .addNewCustomerSuccess(5, 90);

        customerSuccessBalancingService
                .addNewCustomer(1, 50);
        customerSuccessBalancingService
                .addNewCustomer(2, 20);
        customerSuccessBalancingService
                .addNewCustomer(3, 19);
        customerSuccessBalancingService
                .addNewCustomer(4, 90);
        customerSuccessBalancingService
                .addNewCustomer(5, 75);
        customerSuccessBalancingService
                .addNewCustomer(6, 74);


        System.out.println(customerSuccessBalancingService.
                calculateCustomerSuccessWithMoreClients(customerSuccessBalancingService.getCustomersList(),
                        customerSuccessBalancingService.getCustomersSuccessList(), 2));

        customerSuccessBalancingService.getCustomersSuccessList()));

        System.out.println(customerSuccessBalancingService.getCustomersList());
    }
}
