package com.amsidh.quarkus.model;

import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.json.bind.annotation.JsonbTransient;
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
@Schema(description = "Several ISBN numbers for books")
public class IsbnNumber implements Serializable {

    @JsonbProperty("isbn_13")
    @Schema(required = true, description = "isbn13 is required")
    private String isbn13;

    @JsonbProperty("isbn_10")
    @Schema(required = true, description = "isbn10 is required")
    private String isbn10;

    @JsonbTransient
    private Instant createdDate;
}
