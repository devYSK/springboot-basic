package org.prgrms.springorder.domain.customer.api;

import java.util.List;
import org.prgrms.springorder.domain.customer.model.Customer;
import org.prgrms.springorder.domain.customer.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/api/v1/customers")
@RestController
public class CustomerRestController {

    private final CustomerService customerService;

    public CustomerRestController(
        CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> customers = customerService.findAllCustomers();

        return ResponseEntity.ok(customers);
    }


}
