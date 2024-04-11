package br.com.zubokoff.loans.controller.dto;

import br.com.zubokoff.loans.domain.Loan;

import java.util.List;

public record ResponseDto(String name, List<Loan> loans) {
}
