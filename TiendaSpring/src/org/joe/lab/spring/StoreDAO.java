package org.joe.lab.spring;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.*;
import javax.sql.*;
import java.util.*;

@Repository
public class StoreDAO {

    private JdbcTemplate access;

    @Autowired
    public void setAccess(DataSource datasource){
        this.access = new JdbcTemplate(datasource);
    }

    List<Products> getProducts(String department) {
        try {
            String sql = "SELECT image, description, price FROM PRODUCTS WHERE department = ?";

            return this.access.query(sql, new Object[] {department}, new BeanPropertyRowMapper<>(Products.class));
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}