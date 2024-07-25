package com.example.day_20_exercise_bank.Controller;

import com.example.day_20_exercise_bank.Api.ApiResponse;
import com.example.day_20_exercise_bank.Model.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    ArrayList<Customer> customers = new ArrayList<Customer>();


    @GetMapping("/get")
    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    @PostMapping("/add")
    public ApiResponse addCustomer(@RequestBody Customer customer){
        customers.add(customer);
        return new ApiResponse("Customer added successfully");
    }

    @PutMapping("update/{index}")
    public ApiResponse updateCustomer(@PathVariable int index,@RequestBody Customer customer){
        customers.set(index, customer);
        return new ApiResponse("Customer updated successfully");
    }

    @DeleteMapping("/delete/{index}")
    public ApiResponse deleteCustomer(@PathVariable int index){
        customers.remove(index);
        return new ApiResponse("Customer deleted successfully");
    }

    @PutMapping("/deposit/{index}")
    public ApiResponse deposit (@PathVariable int index , @RequestBody double balance){
        customers.get(index).setBalance(customers.get(index).getBalance() + balance);
        return new ApiResponse("Customer deposited successfully");
    }

    @PutMapping("/withdraw/{index}")
    public ApiResponse withdraw (@PathVariable int index , @RequestBody double balance){
        if (customers.get(index).getBalance() - balance > 0) {
            customers.get(index).setBalance(customers.get(index).getBalance() - balance);
            return new ApiResponse("Customer withdrawal successfully");
        }else{
            return new ApiResponse("Customer withdrawal failed");
        }
    }




}
