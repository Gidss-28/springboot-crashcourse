package com.example.demo.myfirstapi.repository;

import com.example.demo.myfirstapi.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {

    private ProductRepository repository;

    @BeforeEach
    void setUp() {
        repository = new ProductRepository();
    }

    @Test
    void shouldReturnAllInitialProducts() {
        List<Product> allProducts = repository.findAll();
        assertEquals(3, allProducts.size());
    }

    @Test
    void shouldFindProductByIdIfExists() {
        List<Product> all = repository.findAll();
        Long existingId = all.get(0).getId();

        Optional<Product> result = repository.findById(existingId);
        assertTrue(result.isPresent());
        assertEquals(existingId, result.get().getId());
    }

    @Test
    void shouldReturnEmptyIfProductIdDoesNotExist() {
        Optional<Product> result = repository.findById(9999L); // unlikely to exist
        assertTrue(result.isEmpty());
    }


    @Test
    void shouldSaveNewProductAndAssignId() {
        Product newProduct = new Product("Headset", 899.00);

        Product savedProduct = repository.save(newProduct);

        assertNotNull(savedProduct.getId());
        assertEquals("Headset", savedProduct.getName());
        assertEquals(899.00, savedProduct.getPrice());

        Optional<Product> found = repository.findById(savedProduct.getId());
        assertTrue(found.isPresent());
        assertEquals("Headset", found.get().getName());
    }

    @Test
    void shouldUpdateExistingProduct() {
        Product existing = repository.findAll().get(0);
        Long id = existing.getId();

        existing.setName("Updated Name");
        existing.setPrice(777.77);

        Product updated = repository.save(existing);

        assertEquals(id, updated.getId());
        assertEquals("Updated Name", updated.getName());
        assertEquals(777.77, updated.getPrice());

        Optional<Product> found = repository.findById(id);
        assertTrue(found.isPresent());
        assertEquals("Updated Name", found.get().getName());
    }

    @Test
    void shouldNotUpdateIfIdDoesNotExist() {
        Product product = new Product(9999L, "Ghost", 0.0); // ID not in list
        Product result = repository.save(product);
        Optional<Product> found = repository.findById(9999L);
        assertTrue(found.isEmpty());
    }

}
