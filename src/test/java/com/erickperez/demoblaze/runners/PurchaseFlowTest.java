package com.erickperez.demoblaze.runners;

import com.erickperez.demoblaze.questions.IsProductInCart;
import com.erickperez.demoblaze.tasks.AddToCart;
import com.erickperez.demoblaze.tasks.NavigateToCart;
import com.erickperez.demoblaze.tasks.PlaceOrder;
import com.erickperez.demoblaze.utils.WebDriverUtils;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.is;

@RunWith(SerenityRunner.class)
public class PurchaseFlowTest {

    WebDriver driver;

    @Before
    public void setUp() {
        driver = WebDriverUtils.initializeChromeDriver();
        driver.get("https://www.demoblaze.com");
        driver.manage().window().maximize();
    }

    @Test
    public void userShouldBeAbleToCompletePurchaseFlow() {
        Actor user = Actor.named("User").whoCan(BrowseTheWeb.with(driver));

        // Primer producto
        user.attemptsTo(AddToCart.withSelectors("div.card.h-100 a", "//a[text()='Add to cart']"));

        // Regresar a la página de inicio
        driver.navigate().to("https://www.demoblaze.com/");

        // Segundo producto
        user.attemptsTo(AddToCart.withSelectors("div:nth-child(3) div:nth-child(1) a:nth-child(1) img:nth-child(1)", "//a[text()='Add to cart']"));

        // Navegar al carrito y verificar los productos
        user.attemptsTo(NavigateToCart.now());
        user.should(seeThat(IsProductInCart.withName("Samsung galaxy s6"), is(true)));
        user.should(seeThat(IsProductInCart.withName("Nexus 6"), is(true)));

        // Realizar la compra
        user.attemptsTo(
                PlaceOrder.withDetails("Erick Perez", "Ecuador", "Quito", "123456", "Agosto", "2024")
        );
    }
}