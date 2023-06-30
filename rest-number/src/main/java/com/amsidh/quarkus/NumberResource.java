package com.amsidh.quarkus;

import com.amsidh.quarkus.model.IsbnNumber;
import io.vertx.core.json.JsonObject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.eclipse.microprofile.openapi.annotations.tags.Tags;

import java.time.Instant;
import java.util.Random;

@Path("/api/numbers")
@Slf4j
@Tag(name = "Number REST Endpoint")
public class NumberResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(
            summary = "Generate book numbers",
            description = "ISBN 13 and ISBN 10 numbers"
    )
    public IsbnNumber getIsbnNumber() {
        log.info("Generating ISBN number");
        IsbnNumber isbnNumber = IsbnNumber.builder()
                .isbn13("13-" + new Random().nextInt(100_100_100))
                .isbn10("10-" + new Random().nextInt(100_100))
                .createdDate(Instant.now())
                .build();
        log.info("Returning response {}", JsonObject.mapFrom(isbnNumber).encode());
        return isbnNumber;
    }
}
