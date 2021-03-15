package ru.yuriy.springtest.dao;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductIdMapper implements RowMapper<Integer> {

    @Override
    public Integer mapRow(ResultSet resultSet, int i) throws SQLException {
        Integer id;
        id = resultSet.getInt("id");
        return id;
    }
}
