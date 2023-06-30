package com.amsidh.quarkus.model;

import jakarta.json.bind.annotation.JsonbDateFormat;
import jakarta.json.bind.annotation.JsonbProperty;
import lombok.*;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.io.Serializable;
import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
@Schema(name = "BookResponseModel Details", description = "This is a book response model")
public class BookResponseModel implements Serializable {

    @Schema(required = true)
    @JsonbProperty("isbn_13")
    private String isbn13;

    @Schema(required = true)
    private String title;

    private String author;

    @JsonbProperty("year_of_publication")
    private int yearOfPublication;

    private String genre;

    @JsonbProperty("creation_date")
    @JsonbDateFormat("yyyy-MM-dd")
    @Schema(implementation = String.class, format = "date")
    private Instant creationDate;
}
