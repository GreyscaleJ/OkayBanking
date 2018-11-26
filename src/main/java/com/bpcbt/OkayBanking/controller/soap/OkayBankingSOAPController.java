package com.bpcbt.OkayBanking.controller.soap;

import com.bpcbt.OkayBanking.dto.Card;
import com.bpcbt.OkayBanking.dto.GetAllCardsByClientIdRequest;
import com.bpcbt.OkayBanking.dto.GetAllCardsByClientIdResponse;
import com.bpcbt.OkayBanking.repisitory.CardsJDBCTemplate;
import com.bpcbt.OkayBanking.repisitory.OkayBankingDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OkayBankingSOAPController {

    private static final Logger log = LoggerFactory.getLogger(OkayBankingSOAPController.class);
    OkayBankingDAO dao;

    @Autowired
    public OkayBankingSOAPController(CardsJDBCTemplate cardsJDBCTemplate) {
        this.dao = cardsJDBCTemplate;
    }

    public GetAllCardsByClientIdResponse getAllCardsByClientId(GetAllCardsByClientIdRequest request) {

        GetAllCardsByClientIdResponse response = new GetAllCardsByClientIdResponse();
        String client_id = request.getClientId();
        List<Card> cardsList;

        if (client_id == null || client_id.equals("")) {
            response.setErrorMsg("client_id is empty or corrupted.");
            log.info("Empty or corrupted client_id at incoming SOAP request.");
        } else {
            cardsList = dao.getAllCardsByClientId(client_id);
            response.setCards(cardsList);
            log.info("Successful database query for cards.");
        }

        return response;
    }
}
