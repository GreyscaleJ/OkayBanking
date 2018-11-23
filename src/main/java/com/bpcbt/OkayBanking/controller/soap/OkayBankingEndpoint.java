package com.bpcbt.OkayBanking.controller.soap;

import bpc.GetAllCardsByClientIdRequest;
import bpc.GetAllCardsByClientIdResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class OkayBankingEndpoint {

    private static final Logger log = LoggerFactory.getLogger(OkayBankingEndpoint.class);
    private static final String NAMESPACE_URI ="http://bpc/";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllCardsByClientIdRequest")
    @ResponsePayload
    public GetAllCardsByClientIdResponse getCards(@RequestPayload GetAllCardsByClientIdRequest getCardsRequest) {

        //MOCK
        return new GetAllCardsByClientIdResponse();
    }
}
