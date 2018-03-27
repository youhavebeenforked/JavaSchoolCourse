package ru.sberbank.javaschool.async.xatransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class SpringJdbcUsersDao implements UsersDao {
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public SpringJdbcUsersDao(DataSource dataSource) {
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public Long create(User user) {
        String sql = "INSERT INTO USERS(ID, FIRST_NAME, MIDDLE_NAME, LAST_NAME, BIRTHDAY) VALUES(USR_SEQ.NEXTVAL, :firstName, :middleName, :lastName, :birthday)";
        SqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(user);
        KeyHolder keyHolder = new GeneratedKeyHolder();
        namedParameterJdbcTemplate.update(sql, sqlParameterSource, keyHolder);
        Long id = (Long) keyHolder.getKey();
        user.setId(id);
        return id;
    }

    @Override
    public User read(Long id) {
        return null;
    }

    @Override
    public void update(User transientObject) {

    }

    @Override
    public void delete(User persistentObject) {

    }
}

