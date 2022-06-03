package ru.ryazanova.itbookstore.service;

import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import ru.ryazanova.itbookstore.dto.PaymentInfo;
import ru.ryazanova.itbookstore.dto.Purchase;
import ru.ryazanova.itbookstore.dto.PurchaseResponse;

public interface CheckoutService {

    PurchaseResponse placeOrder(Purchase purchase);

    PaymentIntent createPaymentIntent(PaymentInfo paymentInfo) throws StripeException;
}
