package com.amsidh.quarkus.client;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

@RegisterRestClient(configKey = "number.service.isbn.endpoint")
public interface NumberServiceProxy {
    Logger log = LoggerFactory.getLogger(NumberServiceProxy.class);

    @GET
    @Path("/api/numbers")
    @Produces(MediaType.APPLICATION_JSON)
    @Fallback(fallbackMethod = "getIsbnResponseFallback")
    @Retry(maxRetries = 3, delay = 3000)
    IsbnResponseModel getIsbnResponse();

    default IsbnResponseModel getIsbnResponseFallback() {
        log.info("Returning fallback response as number-service is having some issue");
        return IsbnResponseModel.builder().isbn13("13-" + new Random().nextInt(100_100_100)).build();
    }

}

