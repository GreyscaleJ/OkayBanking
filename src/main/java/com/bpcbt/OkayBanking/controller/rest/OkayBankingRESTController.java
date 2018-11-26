package com.bpcbt.OkayBanking.controller.rest;

import com.bpcbt.OkayBanking.dto.Card;
import com.bpcbt.OkayBanking.dto.GetAllCardsByClientIdResponse;
import com.bpcbt.OkayBanking.repisitory.CardsJDBCTemplate;
import com.bpcbt.OkayBanking.repisitory.OkayBankingDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OkayBankingRESTController {

    private static final Logger log = LoggerFactory.getLogger(OkayBankingRESTController.class);
    OkayBankingDAO dao;

    @Autowired
    public OkayBankingRESTController(CardsJDBCTemplate cardsJDBCTemplate) {
        this.dao = cardsJDBCTemplate;
    }

    @RequestMapping("/rest/getAllCardsByClientId/")
    public GetAllCardsByClientIdResponse getCards(@RequestParam(value="client_id") String client_id) {

        GetAllCardsByClientIdResponse response = new GetAllCardsByClientIdResponse();
        List<Card> cardsList;

        log.info("Incoming REST request.");

        if (client_id == null || client_id.equals("")) {
            response.setErrorMsg("client_id is empty or corrupted.");
            log.info("Empty or corrupted client_id at incoming REST request.");
        } else {
            cardsList = dao.getAllCardsByClientId(client_id);
            log.info("Successful database query for cards.");
            response.setCards(cardsList);
        }

        return response;
    }
}
