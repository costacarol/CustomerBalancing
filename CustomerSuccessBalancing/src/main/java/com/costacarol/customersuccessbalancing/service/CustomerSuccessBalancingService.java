package com.costacarol.customersuccessbalancing.service;

import com.costacarol.customersuccessbalancing.model.Customer;
import com.costacarol.customersuccessbalancing.model.CustomerSuccess;

import java.util.*;
import java.util.stream.Collectors;

public class CustomerSuccessBalancingService {

    private final List<Customer> customersList;
    private final List<CustomerSuccess> customersSuccessList;

    public CustomerSuccessBalancingService() {
        this.customersList = new ArrayList<>();
        this.customersSuccessList = new ArrayList<>();
    }

    public List<Customer> getCustomersList(){
        return customersList;
    }

    public List<CustomerSuccess> getCustomersSuccessList(){
        return customersSuccessList;
    }

    public Boolean addNewCustomer(Integer customerId,
                                  Integer customerLevel){
        if((0 < customerId
                && customerId < 1000000)
                && (0 < customerLevel
                && customerLevel < 100000)
                && customersList.size() < 1000000){

            Customer customer = new Customer(customerId, customerLevel);
            customersList.add(customer);
            return true;
        } else {
            return false;
        }
    }

    public Boolean addNewCustomerSuccess(Integer customerSuccessId,
                                         Integer customerSuccessLevel){

        if((0 < customerSuccessId
                && customerSuccessId < 1000)
                && (0 < customerSuccessLevel
                && customerSuccessLevel < 10000)
                && customersSuccessList.size() < 1000
                && customersSuccessList.stream()
                .noneMatch(customerSuccess -> customerSuccess.getLEVEL().equals(customerSuccessLevel))
        ){

            CustomerSuccess customerSuccess = new CustomerSuccess(
                    customerSuccessId,
                    customerSuccessLevel);

            customersSuccessList.add(customerSuccess);
            return true;
        } else
            return false;
    }

    public Object findTheApproximateNumberOnList(Double margin,
                                                  List<Customer> customersList,
                                                  List<CustomerSuccess> customersSuccessList) {
        for (Customer customer : customersList)
            for (CustomerSuccess customerSuccess : customersSuccessList) {
                if (customer.getLEVEL().equals(customerSuccess.getLEVEL())) {
                    customer.setIdCS(customerSuccess.getID());
                } else if ((customerSuccess.getLEVEL() < ((customer.getLEVEL() * margin) + customer.getLEVEL()))
                        && (customerSuccess.getLEVEL() > customer.getLEVEL()))
                    customer.setIdCS(customerSuccess.getID());
            }
        return Optional.empty();
    }

    private void removeNotAvailableCustomerSuccess(Integer... notAvailableCustomerSuccessIds){
        if(notAvailableCustomerSuccessIds.length > (Math.floor(customersSuccessList.size()/2)){
        for (Integer number: notAvailableCustomerSuccessIds) {
            customersSuccessList.removeIf(cs -> number.equals(cs.getID()));
        }
    }

    public Object calculateCustomerSuccessWithMoreClients(List<Customer> customersList,
                                                          List<CustomerSuccess> customersSuccessList,
                                                          Integer... notAvailableCustomerSuccessIds){
        if(notAvailableCustomerSuccessIds.length > Math.floor   )
        this.removeNotAvailableCustomerSuccess(notAvailableCustomerSuccessIds);
        this.findTheApproximateNumberOnList(0.1, customersList, customersSuccessList);
        Map<Integer, Integer> customerSuccessWithMoreClients = new HashMap<>();
        customersList.forEach(customer -> customerSuccessWithMoreClients
                .compute(customer.getIdCS(), (k, v) -> (v == null ? 1 : v + 1)));

        List<Integer> draw = customerSuccessWithMoreClients.values()
                .stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        if(draw.get(0).equals(draw.get(1))){
            return 0;
        }else
            return customerSuccessWithMoreClients.entrySet()
                    .stream()
                    .min(Map.Entry.comparingByValue(Comparator.reverseOrder())).get().getKey();
    }
}
