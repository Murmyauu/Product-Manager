import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.productmanager.Book;
import ru.netology.productmanager.Product;
import ru.netology.productmanager.ProductManager;
import ru.netology.productmanager.Smartphone;
import ru.netology.repository.ProductRepository;

public class ProductRepositoryTest {

    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);

    Product product1 = new Book(
            1,
            "Книга",
            100,
            "Война и мир",
            "Л.Н.Толстой"
    );
    Product product2 = new Book(
            2,
            "Книга 2",
            120,
            "Горе от ума",
            "Л.Н.Толстой"
    );
    Product product3 = new Smartphone(
            3,
            "Телефон",
            150_000,
            "Самсунг Е5",
            "Samsung"
    );
    Product product4 = new Smartphone(
            4,
            "Телефон 2",
            200_000,
            "Самсунг Е6",
            "Samsung"
    );
    Product product5 = new Smartphone(
            5,
            "Телефон 3",
            350_000,
            "Самсунг Е9",
            "Samsung"
    );
    Product product6 = new Product(
            5,
            "Телефон 3",
            350_000,
            "Самсунг Е9"
    );

    @Test
    public void shouldSaveProduct() {
        repo.saveProduct(product1);
        repo.saveProduct(product2);
        repo.saveProduct(product3);
        repo.saveProduct(product4);
        repo.saveProduct(product5);

        Product[] expected = {product1, product2, product3, product4, product5};
        Product[] actual = repo.getProducts();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddProductInManager() {
        manager.add(product1);
        manager.add(product2);
        manager.add(product3);

        Product[] expected = {product1, product2, product3};
        Product[] actual = repo.getProducts();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveById() {
        ProductRepository repo = new ProductRepository();
        repo.saveProduct(product1);
        repo.saveProduct(product2);
        repo.saveProduct(product3);
        repo.removeById(product1.getId());

        Product[] expected = {product2, product3};
        Product[] actual = repo.getProducts();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByText() {
        manager.add(product1);
        manager.add(product2);
        manager.add(product3);

        Product[] expected = {product1};
        Product[] actual = manager.searchBy("Война и мир");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByMatches() {
        manager.add(product4);
        manager.add(product5);
        manager.add(product6);

        Product[] expected = {product4};
        Product[] actual = manager.searchBy("Самсунг Е6");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByAuthor() {
        manager.add(product1);
        manager.add(product2);
        manager.add(product3);

        Product[] expected = {product1, product2};
        Product[] actual = manager.searchBy("Л.Н.Толстой");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByProducer() {
        manager.add(product3);
        manager.add(product4);
        manager.add(product5);
        manager.add(product6);

        Product[] expected = {product3, product4, product5};
        Product[] actual = manager.searchBy("Samsung");

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldSearchWhenNoSuitableProduct() {
        manager.add(product1);
        manager.add(product2);
        manager.add(product3);
        manager.add(product4);
        manager.add(product5);
        manager.add(product6);

        Product[] expected = {};
        Product[] actual = manager.searchBy("Nokia");

        Assertions.assertArrayEquals(expected, actual);
    }
}
