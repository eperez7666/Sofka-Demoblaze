package com.erickperez.demoblaze.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import com.erickperez.demoblaze.ui.CartPage;

public class IsProductInCart implements Question<Boolean> {

    private final String productName;

    public IsProductInCart(String productName) {
        this.productName = productName;
    }

    public static IsProductInCart withName(String productName) {
        return new IsProductInCart(productName);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return CartPage.CART_ITEMS.resolveAllFor(actor)
                .stream()
                .anyMatch(element -> element.getText().contains(productName));
    }
}