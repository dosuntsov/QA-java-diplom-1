import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)

public class TestClassBunGetPriceParametrized {
    public float price;
    public float expectedPrice;

    public TestClassBunGetPriceParametrized(float expectedPrice, float price) {
        this.expectedPrice = expectedPrice;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] differentPrices() {
        return new Object[][]{
                {100, 100},
                {150.00F, 150.00F},
                {0, 0},
        };
    }

    @Test
    public void checkDifferentPrices() {
        Bun bun = new Bun("name", price);
        assertEquals(expectedPrice, bun.getPrice(), 0);
    }

}
