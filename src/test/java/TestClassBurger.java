import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
@RunWith(MockitoJUnitRunner.class)

public class TestClassBurger {

    Burger burger = new Burger();
    @Mock
    Bun mockedBun;

    Bun bun = new Bun("black bun", 100);
    Ingredient ingredient1 = new Ingredient(IngredientType.SAUCE, "ketchup", 100);
    Ingredient ingredient2 = new Ingredient(IngredientType.FILLING, "cutlet", 300);
    Ingredient ingredient3 = new Ingredient(IngredientType.SAUCE, "caesar", 100);
    List<Ingredient> startIngredients = Arrays.asList(new Ingredient[]{ingredient1, ingredient2, ingredient3});

    private void makeBurger() {
        burger.addIngredient(startIngredients.get(0));
        burger.addIngredient(startIngredients.get(1));
        burger.addIngredient(startIngredients.get(2));
    }

    @Test
    public void checkMockedBunPriceIsCorrectInBurger() {
        burger.setBuns(mockedBun);
        burger.getPrice();
        Mockito.verify(mockedBun).getPrice();
    }

    @Test
    public void checkIfSetBunsAreCorrectInBurger() {
        burger.setBuns(bun);
        Assert.assertEquals(bun, burger.bun);
    }

    @Test
    public void checkAddingIngredients() {
        makeBurger();
        assertEquals(startIngredients, burger.ingredients);

    }

    @Test
    public void checkRemovingIngredients() {
        List<Ingredient> finalIngredients = Arrays.asList(new Ingredient[]{startIngredients.get(0), startIngredients.get(2)});
        makeBurger();
        burger.removeIngredient(1);
        assertEquals(finalIngredients, burger.ingredients);

    }

    @Test
    public void checkMovingIngredients() {
        List<Ingredient> expectedIngredients = Arrays.asList(new Ingredient[]{startIngredients.get(0), startIngredients.get(2), startIngredients.get(1)});
        makeBurger();
        burger.moveIngredient(1, 2);
        assertEquals(expectedIngredients, burger.ingredients);

    }

    @Test
    public void getPriceWorksCorrectly() {
        burger.setBuns(bun);
        makeBurger();
        assertEquals(700, burger.getPrice(), 0);
    }

    @Test
    public void getReceiptWorksCorrectly() {
        makeBurger();
        burger.setBuns(bun);
        String expected = "(==== black bun ====)\r\n= sauce ketchup =\r\n= filling cutlet =\r\n= sauce caesar =\r\n(==== black bun ====)\r\n\r\nPrice: 700,000000\r\n";
        assertEquals(expected, burger.getReceipt());
    }
}
