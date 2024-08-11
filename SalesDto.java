package spring_practice.vendingmachine.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import spring_practice.vendingmachine.entity.Sales;

@Getter
public class SalesDto {
    private String name;
    private int profit;

    public SalesDto(Sales sales) {
        this.name = sales.getName();
        this.profit = sales.getProfit();
    }
}
