import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;

public class TestClassBun {
    Bun bun = new Bun("red", 100);

    @Test
    public void checkIfGetNameWorksFine(){
        Assert.assertEquals("red", bun.getName());
    }
    @Test
    public void checkIfGetPriceWorksFine(){
        Assert.assertEquals(100, bun.getPrice(),0);
    }

}
