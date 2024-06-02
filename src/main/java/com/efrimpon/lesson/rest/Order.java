package com.efrimpon.lesson.rest;


import com.fasterxml.jackson.annotation.JsonProperty;

public record Order(
        @JsonProperty("c-name") String customerName,
        @JsonProperty("p-name") String productName,
        @JsonProperty("q") int quantity) {
}