package com.amsidh.quarkus;

import com.amsidh.quarkus.client.IsbnResponseModel;
import com.amsidh.quarkus.client.NumberServiceProxy;
import com.amsidh.quarkus.model.BookRequestModel;
import com.amsidh.quarkus.model.BookResponseModel;
import io.netty.handler.codec.http.HttpResponseStatus;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.time.Instant;

@Path("/api/books")
@Tag(name = "Book Rest endpoint", description = "Book Rest API")
@Slf4j
public class BookResource {

    @RestClient
    private NumberServiceProxy numberServiceProxy;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Create a book", description = "Create Book with ISBN number")
    public Response createBook(BookRequestModel bookRequestModel) {
        log.info("Request received to createBook");
        IsbnResponseModel isbnResponse = numberServiceProxy.getIsbnResponse();
        log.info("Response received from Number-Service {}", isbnResponse.getIsbn13());
        return Response.status(HttpResponseStatus.CREATED.code())
                .entity(BookResponseModel.builder()
                        .isbn13(isbnResponse.getIsbn13())
                        .author(bookRequestModel.getAuthor())
                        .title(bookRequestModel.getTitle())
                        .genre(bookRequestModel.getGenre())
                        .yearOfPublication(bookRequestModel.getYearOfPublication())
                        .creationDate(Instant.now())
                        .build())
                .build();
    }
}
