package io.syndesis.example;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SalesforceIdentifier {

    @JsonProperty("Id")
    private String id;

    @JsonCreator
    public SalesforceIdentifier(@JsonProperty("Id") final String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return id;
    }
}
