package com.amsidh.quarkus.model;

import jakarta.json.bind.annotation.JsonbProperty;
import lombok.*;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
@Schema(name = "BookRequestModel Details", description = "This is a book request model")
public class BookRequestModel implements Serializable {

    @Schema(required = true)
    private String title;

    private String author;

    @JsonbProperty("year_of_publication")
    private int yearOfPublication;

    private String genre;

}
