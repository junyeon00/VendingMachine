package spring_practice.vendingmachine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring_practice.vendingmachine.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

}
