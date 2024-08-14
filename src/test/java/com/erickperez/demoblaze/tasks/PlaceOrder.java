package com.erickperez.demoblaze.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class PlaceOrder implements Task {

    private final String name;
    private final String country;
    private final String city;
    private final String card;
    private final String month;
    private final String year;

    public PlaceOrder(String name, String country, String city, String card, String month, String year) {
        this.name = name;
        this.country = country;
        this.city = city;
        this.card = card;
        this.month = month;
        this.year = year;
    }

    public static PlaceOrder withDetails(String name, String country, String city, String card, String month, String year) {
        return instrumented(PlaceOrder.class, name, country, city, card, month, year);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Asegurarse de que el botón "Place Order" es visible y hacer clic en él
        WebElement placeOrderButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".btn.btn-success")));
        placeOrderButton.click();

        // Llenar el formulario emergente
        actor.attemptsTo(
                Enter.theValue(name).into(By.id("name")),
                Enter.theValue(country).into(By.id("country")),
                Enter.theValue(city).into(By.id("city")),
                Enter.theValue(card).into(By.id("card")),
                Enter.theValue(month).into(By.id("month")),
                Enter.theValue(year).into(By.id("year"))
        );

        // Esperar a que el botón "Purchase" sea visible y hacer clic en él
        WebElement purchaseButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[onclick='purchaseOrder()']")));

        // Si es necesario, desplazarse hasta el botón antes de hacer clic
        Actions actions = new Actions(driver);
        actions.moveToElement(purchaseButton).perform();

        // Hacer clic en el botón "Purchase"
        purchaseButton.click();
    }
}
