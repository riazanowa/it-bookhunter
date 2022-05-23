package ru.ryazanova.itbookstore.dto;

import lombok.Data;

// Use this class to send back a Java object as JSON
@Data
public class PurchaseResponse {
    private final String orderTrackingNumber;
}
