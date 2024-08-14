package com.erickperez.demoblaze.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Scroll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class AddToCart implements Task {

    private final String productCssSelector;
    private final String productAddToCartXPath;

    public AddToCart(String productCssSelector, String productAddToCartXPath) {
        this.productCssSelector = productCssSelector;
        this.productAddToCartXPath = productAddToCartXPath;
    }

    public static AddToCart withSelectors(String productCssSelector, String productAddToCartXPath) {
        return instrumented(AddToCart.class, productCssSelector, productAddToCartXPath);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // Esperar a que el producto esté disponible y seleccionarlo
        WebElement productElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(productCssSelector)));
        productElement.click();

        // Esperar y hacer scroll hasta el botón "Add to cart"
        WebElement addToCartButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(productAddToCartXPath)));
        actor.attemptsTo(Scroll.to(addToCartButton));
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
        addToCartButton.click();

        // Esperar y aceptar la alerta
        wait.until(ExpectedConditions.alertIsPresent()).accept();
    }
}
