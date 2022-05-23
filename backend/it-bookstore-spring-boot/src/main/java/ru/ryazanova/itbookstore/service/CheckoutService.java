package ru.ryazanova.itbookstore.service;

import ru.ryazanova.itbookstore.dto.Purchase;
import ru.ryazanova.itbookstore.dto.PurchaseResponse;

public interface CheckoutService {

    PurchaseResponse placeOrder(Purchase purchase);
}
