package br.com.zubokoff.loans.controller.dto;

import br.com.zubokoff.loans.domain.Customer;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record RequestDto(@NotNull(message = "Por favor, informar a idade")
                         @Min(value = 18, message = "Empresto indisponível para menores de 18 anos") Integer age,
                         @NotNull(message = "Por favor, informe o cpf")
                         String cpf,
                         @NotNull(message = "Por favor, informe o nome")
                         String name,
                         @NotNull(message = "Por favor, informe o salário")
                         Double income,
                         @NotNull(message = "Por favor, informe a localização")
                         String location) {

    public Customer toCustomer() {
        return new Customer(age, cpf, name, income, location);
    }
}
