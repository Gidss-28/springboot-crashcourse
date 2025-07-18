package com.example.demo.myfirstapi.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProductTest {

    @Test
    void shouldCreateProductWithNameAndPrice() {
        Product product = new Product("Cellphone", 1999.99);
        assertEquals("Cellphone",product.getName());
        assertEquals(1999.99,product.getPrice());
    }

    @Test
    void shouldCreateProductWithIdNameAndPrice() {
        Product product = new Product(123456789L,"Cellphone", 1999.99);
        assertEquals(123456789L, product.getId());
        assertEquals("Cellphone",product.getName());
        assertEquals(1999.99,product.getPrice());
    }

    @Test
    void changeProductId() {
        Product product = new Product("Book", 2000.99);
        assertNull(product.getId());

        product.setId(98765L);
        assertEquals(98765L, product.getId());
    }

    @Test
    void changeProductName() {
        Product product = new Product(98765L, "Book", 2000.99);
        product.setName("Notebook");
        assertEquals("Notebook", product.getName());
    }

    @Test
    void changeProductPrice() {
        Product product = new Product(12345L, "Book", 2000.99);
        product.setPrice(1000.99);
        assertEquals(1000.99, product.getPrice());
    }

    @Test
    void changeProductProperties() {
        Product product = new Product(12345L, "Laptop", 45999.99);
        product.setId(6789L);
        product.setName("MacBook");
        product.setPrice(89999.99);

        assertEquals(6789L, product.getId());
        assertEquals("MacBook", product.getName());
        assertEquals(89999.99, product.getPrice());
    }

    @Test
    void shouldCreateHashCode() {
        Product product1 = new Product(12345L, "Laptop", 45999.99);
        Product product2 = new Product(12345L, "Laptop", 45999.99);

        assertEquals(product1, product2);
        assertEquals(product1.hashCode(), product2.hashCode());

    }


}
