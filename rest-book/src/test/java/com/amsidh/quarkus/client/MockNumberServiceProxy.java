package com.amsidh.quarkus.client;

import io.quarkus.test.Mock;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.Random;

@Mock
@RestClient
public class MockNumberServiceProxy implements NumberServiceProxy {
    @Override
    public IsbnResponseModel getIsbnResponse() {
        return IsbnResponseModel.builder().isbn13("13-" + new Random().nextInt(100_100_100)).build();
    }
}
