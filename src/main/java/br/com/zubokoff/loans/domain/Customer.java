package br.com.zubokoff.loans.domain;


public class Customer {
    private Integer age;
    private String cpf;
    private String name;
    private Double income;
    private String location;

    public Customer(Integer age, String cpf, String name, Double income, String location) {
        this.age = age;
        this.cpf = cpf;
        this.name = name;
        this.income = income;
        this.location = location;
    }

    public boolean isIncomeEqualOrLower(double value) {
        return income <= value;
    }

    public boolean isIncomeBetween(double minValue, double maxValue) {
        return income >= minValue && income <= maxValue;
    }

    public boolean isAgeLower(int value) {
        return age < value;
    }

    public boolean isLocation(String value) {
        return location.equals(value);
    }

    public String getName() {
        return name;
    }
}
