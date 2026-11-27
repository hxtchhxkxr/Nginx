package com.example.backend;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestHeader;

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

    @GetMapping("/api/host")
    public String getHost(@RequestHeader("Host") String host) {
        return host;
    }

    @GetMapping("/api/client-ip")
    public String getClientIp(
            @RequestHeader(value = "X-Forwarded-For", defaultValue = "없음") String forwardedFor) {
        return forwardedFor;
    }

    @GetMapping("/api/proto")
    public String getProto(
            @RequestHeader(name = "X-Forwarded-Proto", defaultValue = "없음") String proto) {
        return proto;
    }

    public record Product(long id, String name, int price) {}
}