package com.bpcbt.OkayBanking.controller.soap;


import com.bpcbt.OkayBanking.dto.GetAllCardsByClientIdRequest;
import com.bpcbt.OkayBanking.dto.GetAllCardsByClientIdResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class OkayBankingEndpoint {

    private static final Logger log = LoggerFactory.getLogger(OkayBankingEndpoint.class);
    private static final String NAMESPACE_URI ="http://bpc/";
    OkayBankingSOAPController okayBankingSOAPController;

    @Autowired
    public OkayBankingEndpoint(OkayBankingSOAPController okayBankingSOAPController) {
        this.okayBankingSOAPController = okayBankingSOAPController;
    }


    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllCardsByClientIdRequest")
    @ResponsePayload
    public GetAllCardsByClientIdResponse getCards(@RequestPayload GetAllCardsByClientIdRequest getCardsRequest) {

        GetAllCardsByClientIdResponse response;

        log.info("Incoming SOAP request.");
        response = okayBankingSOAPController.getAllCardsByClientId(getCardsRequest);
        log.info("Attempt to send SOAP response.");

        return response;
    }
}
