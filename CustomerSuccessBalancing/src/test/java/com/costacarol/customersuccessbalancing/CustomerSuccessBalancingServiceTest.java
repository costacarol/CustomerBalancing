package com.costacarol.customersuccessbalancing;

import com.costacarol.customersuccessbalancing.service.CustomerSuccessBalancingService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CustomerSuccessBalancingServiceTest {

    @Test
    public void shouldReturnIdOfCSWithMoreCustomers() {
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

        Assertions.assertEquals(2, customerSuccessBalancingService
                .calculateCustomerSuccessWithMoreClients(
                        customerSuccessBalancingService.getCustomersList(),
                        customerSuccessBalancingService.getCustomersSuccessList()));
    }

    @Test
    public void shouldReturnIdOfCSWithMoreCustomersContainingAbsentCSs () {
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

        Assertions.assertEquals(4, customerSuccessBalancingService
                .calculateCustomerSuccessWithMoreClients(
                        customerSuccessBalancingService.getCustomersList(),
                        customerSuccessBalancingService.getCustomersSuccessList(),
                        2));
    }

    @Test
    public void shouldReturnZeroForDrawInCustomerSuccessWithMoreClients() {
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

        Assertions.assertEquals(0, customerSuccessBalancingService
                .calculateCustomerSuccessWithMoreClients(
                        customerSuccessBalancingService.getCustomersList(),
                        customerSuccessBalancingService.getCustomersSuccessList()));
    }

    @Test
    public void shouldReturnFalseToAddNewCustomerSuccessWithHighId() {
        CustomerSuccessBalancingService customerSuccessBalancingService = new CustomerSuccessBalancingService();
        Assertions.assertFalse(customerSuccessBalancingService
                .addNewCustomerSuccess(1001, 54));
    }

    @Test
    public void shouldReturnFalseToAddNewCustomerWithHighId() {
        CustomerSuccessBalancingService customerSuccessBalancingService = new CustomerSuccessBalancingService();
        Assertions.assertFalse(customerSuccessBalancingService
                .addNewCustomer(1000001, 54));
    }

    @Test
    public void shouldReturnFalseToAddNewCustomerSuccessWithHighLevel() {
        CustomerSuccessBalancingService customerSuccessBalancingService = new CustomerSuccessBalancingService();
        Assertions.assertFalse(customerSuccessBalancingService
                .addNewCustomerSuccess(1, 10001));
    }

    @Test
    public void shouldReturnFalseToAddNewCustomerWithHighLevel() {
        CustomerSuccessBalancingService customerSuccessBalancingService = new CustomerSuccessBalancingService();
        Assertions.assertFalse(customerSuccessBalancingService
                .addNewCustomer(1, 1000001));
    }

    @Test
    public void shouldReturnFalseToIncludeDuplicatedCustomerSuccessLevel(){
        CustomerSuccessBalancingService customerSuccessBalancingService = new CustomerSuccessBalancingService();
        customerSuccessBalancingService.addNewCustomerSuccess(1,50);
        Assertions.assertFalse(customerSuccessBalancingService
                .addNewCustomerSuccess(2, 50));
    }
}
