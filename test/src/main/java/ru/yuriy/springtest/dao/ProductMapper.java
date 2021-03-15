package ru.yuriy.springtest.dao;

import org.springframework.jdbc.core.RowMapper;
import ru.yuriy.springtest.models.Product;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductMapper implements RowMapper<Product> {
    @Override
    public Product mapRow(ResultSet resultSet, int i) throws SQLException {
        Product product = new Product();

        product.setId(resultSet.getInt("id"));
        product.setName(resultSet.getString("name"));
        product.setPrice(resultSet.getInt("price"));
        product.setDescription(resultSet.getString("description"));
        product.setCreationDate((resultSet.getString("creationDate")));
        product.setModificationDate(resultSet.getString("modificationDate"));

        return product;
    }
}
