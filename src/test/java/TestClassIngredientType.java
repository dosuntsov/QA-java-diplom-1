import org.junit.Assert;
import org.junit.Test;
import praktikum.IngredientType;

public class TestClassIngredientType {
    @Test
    public void checkIngTypeNotNull(){
        Assert.assertFalse(IngredientType.values().length==0);
    }
}
