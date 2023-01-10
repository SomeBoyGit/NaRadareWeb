package ru.someboy.naradareweb.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.someboy.naradareweb.model.Product;
import ru.someboy.naradareweb.services.SearchService;

import java.util.List;


/**
 * @author Slipets Artem
 */
@Component
public class ProductDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ProductDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Product> index() {
        return jdbcTemplate.query("SELECT * FROM moba", new BeanPropertyRowMapper<>(Product.class));
    }

    public List<Product> searchInDB(String searchText) {
        if (searchText.split(" ").length < 2) {
            String query = "%" + searchText + "%";
            return jdbcTemplate.query(SearchService.sqlQueryGenerate(searchText),
                    new BeanPropertyRowMapper<>(Product.class), query);
        } else {
            return jdbcTemplate.query(SearchService.sqlQueryGenerate(searchText),
                    new BeanPropertyRowMapper<>(Product.class), (Object[]) SearchService.method(searchText));
        }
    }

    public Product show(int idProduct) {
        return jdbcTemplate.query("SELECT * FROM moba WHERE idProduct =?", new Object[]{idProduct},
                        new BeanPropertyRowMapper<>(Product.class))
                .stream().findAny().orElse(null);
    }
}
