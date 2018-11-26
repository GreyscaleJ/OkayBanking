package com.bpcbt.OkayBanking.repisitory;

import com.bpcbt.OkayBanking.dto.Card;
import com.bpcbt.OkayBanking.utils.CardsRowMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class CardsJDBCTemplate implements OkayBankingDAO {

    private static final Logger log = LoggerFactory.getLogger(CardsJDBCTemplate.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Card> getAllCardsByClientId(String client_id) {

        String sqlQuery = "select * from cards where client_id = ?";
        List<Card> queryResult;

        queryResult = jdbcTemplate.query(sqlQuery, new Object[] {client_id}, new CardsRowMapper());

        return queryResult;
    }
}
