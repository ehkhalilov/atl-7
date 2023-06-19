package az.example.atl7.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Loan")
public class LoanDto {
    @ApiModelProperty("this is loan number")
    private String number;
    private Double rate;

    public LoanDto() {
    }

    public LoanDto(String number, Double rate) {
        this.number = number;
        this.rate = rate;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "LoanDto{" +
                "number='" + number + '\'' +
                ", rate=" + rate +
                '}';
    }
}
