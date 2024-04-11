package br.com.zubokoff.loans.controller;

import br.com.zubokoff.loans.controller.dto.RequestDto;
import br.com.zubokoff.loans.controller.dto.ResponseDto;
import br.com.zubokoff.loans.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoansController {

    private final CustomerService customerService;

    public LoansController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping(value = "/customer-loans")
    public ResponseEntity<ResponseDto> loans(@RequestBody RequestDto requestDto) {
        return ResponseEntity.ok().body(customerService.loans(requestDto));
    }
}
