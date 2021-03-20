package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);
    private Book Book1 = new Book(1, "A1", 1000, "B1");
    private Book Book2 = new Book(2, "A2", 2000, "B1");
    private Smartphone Smartphone1 = new Smartphone(3, "A10", 500000, "B10");
    private Smartphone Smartphone2 = new Smartphone(4, "A20", 400000, "B10");

    @BeforeEach
    void setUp() {
        manager.add(Book1);
        manager.add(Book2);
        manager.add(Smartphone1);
        manager.add(Smartphone2);
    }

    @Test
    public void getAll() {
        Product[] expected = new Product[]{Book1, Book2, Smartphone1, Smartphone2};
        Product[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void findSeveralByBookAuthor() {
        Product[] expected = new Product[]{Book1, Book2};
        Product[] actual = manager.searchBy("B1");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void findByBookTitle() {
        Product[] expected = new Product[]{Book1};
        Product[] actual = manager.searchBy("A1");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void findBySmartphoneManufacturer() {
        Product[] expected = new Product[]{Smartphone1, Smartphone2};
        Product[] actual = manager.searchBy("B10");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void findBySmartphoneTitle() {
        Product[] expected = new Product[]{Smartphone2};
        Product[] actual = manager.searchBy("A20");
        assertArrayEquals(expected, actual);
    }
}