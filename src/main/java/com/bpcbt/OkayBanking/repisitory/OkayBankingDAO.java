package com.bpcbt.OkayBanking.repisitory;

import com.bpcbt.OkayBanking.dto.Card;

import java.util.List;

public interface OkayBankingDAO {

    public List<Card> getAllCardsByClientId(String client_id);
}
