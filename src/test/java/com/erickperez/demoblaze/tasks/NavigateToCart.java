package com.erickperez.demoblaze.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class NavigateToCart implements Task {

    private static final String CART_URL = "https://www.demoblaze.com/cart.html";

    public static NavigateToCart now() {
        return instrumented(NavigateToCart.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.url(CART_URL)
        );
    }
}
