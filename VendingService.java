package spring_practice.vendingmachine.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring_practice.vendingmachine.dto.MoneyDto;
import spring_practice.vendingmachine.dto.ProductDto;
import spring_practice.vendingmachine.dto.SalesDto;
import spring_practice.vendingmachine.entity.Product;
import spring_practice.vendingmachine.entity.Sales;
import spring_practice.vendingmachine.repository.ProductRepository;
import spring_practice.vendingmachine.repository.SalesRepository;

import java.util.List;

@Service
public class VendingService {
    final private ProductRepository productRepository;
    final private SalesRepository salesRepository;
    private MoneyDto moneyDto;

    @Autowired
    public VendingService(ProductRepository productRepository, SalesRepository salesRepository) {
        this.productRepository = productRepository;
        this.salesRepository = salesRepository;
        this.moneyDto = new MoneyDto();
    }

    public MoneyDto chargeMoney(int money) {
        moneyDto.setMoney(moneyDto.getMoney() + money);
        return moneyDto;
    }

    public ProductDto buying(ProductDto productDto) {
        Product product = productRepository.findById(productDto.getName())
                .orElseThrow(() -> new IllegalArgumentException("에러 발생"));

        // 음료 재고 없을 시
        if (product.getQuantity() <= 0) {
            throw new IllegalArgumentException("재고가 없습니다.");
        }

        // 잔액이 없을 시
        if (moneyDto.getMoney() < product.getPrice()) {
            throw new IllegalArgumentException("잔액이 없습니다.");
        }

        // 음료 구매 시 잔액 차감
        moneyDto.setMoney(moneyDto.getMoney() - product.getPrice());

        // 음료 구매 시 재고 차감
        product.setQuantity(product.getQuantity() - 1);
        productRepository.save(product);

        // 음료 구매 시 수익 반영
        Sales sales = salesRepository.findById(product.getName())
                .orElseThrow(() -> new IllegalArgumentException("에러 발생"));
        sales.setProfit(sales.getProfit() + product.getPrice());
        salesRepository.save(sales);

        return new ProductDto(product);
    }

    // 수익 총계 리스트 형식으로 반환
    public List<SalesDto> getProfit() {
        return salesRepository.findAllByOrderByProfitDesc().stream()
                .map(SalesDto::new).toList();
    }
}



