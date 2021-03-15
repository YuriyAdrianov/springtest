package ru.yuriy.springtest.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.yuriy.springtest.models.Person;
import ru.yuriy.springtest.models.Product;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductDAO {
    private final JdbcTemplate jdbcTemplate;

    private ProductId productId = new ProductId();
    private ArrayList<Integer> idList = new ArrayList<Integer>();

    @Autowired
    public ProductDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Product> index() {
        return jdbcTemplate.query("SELECT * FROM Product", new ProductMapper());
    }

    public Product show(int id) {
        return jdbcTemplate.query("SELECT * FROM Product WHERE id=?", new Object[]{id}, new ProductMapper())
                .stream().findAny().orElse(null);
    }

    public void save(Product product) {

        idList.addAll(jdbcTemplate.query("SELECT id FROM Product", new ProductIdMapper()));

        jdbcTemplate.update("INSERT INTO Product VALUES(?,?,?,?,?,?)",
                productId.idCreator(idList), product.getName(), product.getPrice(), product.getDescription(),
                java.time.LocalDate.now(), "--");
    }

    public void update(int id, Product updatedProduct) {

        jdbcTemplate.update("UPDATE Product SET name=?, price=?, description=?, modificationdate=? WHERE id=?",
                updatedProduct.getName(), updatedProduct.getPrice(), updatedProduct.getDescription(),
                java.time.LocalDate.now(), id);
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM Product WHERE id=?", id);

    }
}
