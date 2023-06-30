package com.amsidh.quarkus.openapi;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import org.eclipse.microprofile.openapi.annotations.ExternalDocumentation;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@ApplicationPath("/")
@OpenAPIDefinition(info = @Info(
        title = "Number Microservice",
        version = "1.0",
        description = "This microservice is for generating ISBN numbers for book",
        contact = @Contact(name = "Amsidh Lokhande", email = "amsidhlokhande@gmail.com")),
        externalDocs = @ExternalDocumentation(url = "http://github.com/amsidhlokhande"),
        tags = {
                @Tag(name = "api", description = "Public API that can be used by anybody"),
                @Tag(name = "numbers", description = "Anybody interested to generate ISBN number")
        }
)
public class NumberServiceOpenApiSpecification extends Application {
}
