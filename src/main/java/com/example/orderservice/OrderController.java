package com.example.orderservice;

import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @GetMapping
    public List<Map<String, Object>> orders() {
        return List.of(
            Map.of("orderId", "ORD-1001", "item", "Laptop", "quantity", 1, "status", "CONFIRMED"),
            Map.of("orderId", "ORD-1002", "item", "Keyboard", "quantity", 2, "status", "PROCESSING"),
            Map.of("orderId", "ORD-1003", "item", "Mouse", "quantity", 1, "status", "SHIPPED")
        );
    }
}
