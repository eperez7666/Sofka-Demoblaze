package com.erickperez.demoblaze.ui;

import net.serenitybdd.screenplay.targets.Target;

public class CartPage {
    public static final Target CART_ITEMS = Target.the("Cart items")
            .locatedBy(".success > td:nth-child(2)");
    public static final Target PLACE_ORDER_BUTTON = Target.the("Place Order button")
            .locatedBy(".btn.btn-success");
    public static final Target NAME_INPUT = Target.the("Name input")
            .locatedBy("#name");
    public static final Target COUNTRY_INPUT = Target.the("Country input")
            .locatedBy("#country");
    public static final Target CITY_INPUT = Target.the("City input")
            .locatedBy("#city");
    public static final Target CARD_INPUT = Target.the("Credit card input")
            .locatedBy("#card");
    public static final Target MONTH_INPUT = Target.the("Month input")
            .locatedBy("#month");
    public static final Target YEAR_INPUT = Target.the("Year input")
            .locatedBy("#year");
    public static final Target PURCHASE_BUTTON = Target.the("Purchase button")
            .locatedBy("button[onclick='purchaseOrder()']");
}