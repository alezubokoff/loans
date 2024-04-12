package br.com.zubokoff.loans.service;

import br.com.zubokoff.loans.controller.dto.RequestDto;
import br.com.zubokoff.loans.controller.dto.ResponseDto;
import br.com.zubokoff.loans.domain.Customer;
import br.com.zubokoff.loans.domain.Loan;
import br.com.zubokoff.loans.domain.LoanType;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    public ResponseDto loans(RequestDto requestDto) {
        var customer = requestDto.toCustomer();
        List<Loan> loanList = new ArrayList<>();

        this.validPersonalLoan(customer, loanList);
        this.validConsignment(customer, loanList);
        this.validGuaranteed(customer, loanList);
        return new ResponseDto(customer.getName(), loanList);
    }

    private void validPersonalLoan(Customer customer, List<Loan> loanList) {
        if (customer.isIncomeEqualOrLower(3000.0)) {
            loanList.add(new Loan(LoanType.PERSONAL, 4));
        }

        if(customer.isIncomeBetween(3000.0, 5000.0) && customer.isAgeLower(30) && customer.isLocation("SP")) {
            loanList.add(new Loan(LoanType.PERSONAL, 4));
        }
    }

    private void validConsignment(Customer customer, List<Loan> loanList) {
        if (customer.isIncomeEqualOrUpper(5000.0)) {
            loanList.add(new Loan(LoanType.CONSIGNMENT, 2));
        }
    }

    private void validGuaranteed(Customer customer, List<Loan> loanList) {
        if (customer.isIncomeEqualOrLower(3000.0)) {
            loanList.add(new Loan(LoanType.GUARANTEED, 3));
        }

        if(customer.isIncomeBetween(3000.0, 5000.0) && customer.isAgeLower(30) && customer.isLocation("SP")) {
            loanList.add(new Loan(LoanType.GUARANTEED, 3));
        }
    }
}
