package spring_practice.vendingmachine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring_practice.vendingmachine.entity.Sales;

import java.util.List;

@Repository
public interface SalesRepository extends JpaRepository<Sales, String> {
    List<Sales> findAllByOrderByProfitDesc();
}
