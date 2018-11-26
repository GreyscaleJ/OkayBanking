package com.bpcbt.OkayBanking.utils;

import com.bpcbt.OkayBanking.dto.Card;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CardsRowMapper implements RowMapper<Card> {

    private static final Logger log = LoggerFactory.getLogger(CardsRowMapper.class);

    @Override
    public Card mapRow(ResultSet rs, int rowNum) throws SQLException {

        Card payloadCard = new Card();

        payloadCard.setCardId(rs.getString("card_id"));
        payloadCard.setCardNum(rs.getString("card_num"));
        payloadCard.setExpDate(rs.getString("exp_date"));
        payloadCard.setCardHolderName(rs.getString("cardholder_name"));
        payloadCard.setStatusCardId(rs.getString("card_status"));

        return payloadCard;
    }
}
