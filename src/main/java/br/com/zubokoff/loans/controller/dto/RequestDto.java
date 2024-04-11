package br.com.zubokoff.loans.controller.dto;

import br.com.zubokoff.loans.domain.Customer;

public record RequestDto(Integer age, String cpf, String name, Double income, String location) {

    public Customer toCustomer() {
        return new Customer(age, cpf, name, income, location);
    }
}
