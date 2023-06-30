package com.amsidh.quarkus.client;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
@Schema(name = "ISBN_13 Number", description = "ISBN 13 book number")
public class IsbnResponseModel {

    @JsonProperty("isbn_13")
    private String isbn13;
}
