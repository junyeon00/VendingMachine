package spring_practice.vendingmachine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring_practice.vendingmachine.dto.MoneyDto;
import spring_practice.vendingmachine.dto.ProductDto;
import spring_practice.vendingmachine.dto.SalesDto;
import spring_practice.vendingmachine.service.VendingService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class VendingController {
    final private VendingService vendingService;

    @Autowired
    public VendingController(VendingService vendingService) {
        this.vendingService = vendingService;
    }

    // 현금 충전
    @PutMapping("/charge/{money}")
    public MoneyDto charge(@PathVariable int money) {
        return vendingService.chargeMoney(money);
    }

    // 수익 총계
    @GetMapping("/viewprofit")
    public List<SalesDto> getProfit() {
        return vendingService.getProfit();
    }

    // 상품 구입 및 재고 차감
    @PutMapping("/buy")
    public ProductDto buyProduct(@RequestBody ProductDto productDto) {
        return vendingService.buying(productDto);
    }
}


