import org.junit.Assert;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class TestClassIngredient {
    Ingredient ig = new Ingredient(IngredientType.SAUCE, "name", 100);

    @Test
    public void checkGetName() {
        Assert.assertEquals("name", ig.getName());
    }

    @Test
    public void checkGetPrice() {
        Assert.assertEquals(100, ig.getPrice(), 0);

    }

    @Test
    public void checkGetType() {
        Assert.assertEquals("SAUCE", ig.getType().toString());
    }

}
