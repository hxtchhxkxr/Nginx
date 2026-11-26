package com.example.backend;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @GetMapping("/api/products")
    public List<Product> getProducts() {
        return List.of(
                new Product(1, "초코 케이크", 17000),
                new Product(2, "딸기 케이크", 20000)
        );
    }

    public record Product(long id, String name, int price) {}
}