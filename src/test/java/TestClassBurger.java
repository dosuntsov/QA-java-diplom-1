import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.Arrays;
import java.util.List;

public class TestClassBurger {
    Burger burger = new Burger();
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

    //    @Test
//    public void checkSetterBun(){
//        burger.setBuns(bun);
//        Assert.assertEquals(bun, burger.bun );
//    }
    @Test
    public void checkAddingIngredients() {
        makeBurger();
        Assert.assertEquals(startIngredients, burger.ingredients);

    }

    @Test
    public void checkRemovingIngredients() {
        List<Ingredient> finalIngredients = Arrays.asList(new Ingredient[]{startIngredients.get(0), startIngredients.get(2)});
        makeBurger();
        burger.removeIngredient(1);
        Assert.assertEquals(finalIngredients, burger.ingredients);

    }

    @Test
    public void checkMovingIngredients() {
        List<Ingredient> finalIngredients = Arrays.asList(new Ingredient[]{startIngredients.get(0), startIngredients.get(2), startIngredients.get(1)});
        makeBurger();
        burger.moveIngredient(1, 2);
        Assert.assertEquals(finalIngredients, burger.ingredients);

    }

    @Test
    public void getPrice() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        Assert.assertEquals(300, burger.getPrice(), 0);
    }
}
