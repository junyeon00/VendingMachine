package spring_practice.vendingmachine.dto;

import lombok.Getter;
import lombok.Setter;
import spring_practice.vendingmachine.entity.Product;

@Getter
@Setter
public class ProductDto {
    private String name;
    private int price;
    private int quantity;

    public ProductDto(Product product) {
        this.name = product.getName();
        this.price = product.getPrice();
        this.quantity = product.getQuantity();
    }

}
