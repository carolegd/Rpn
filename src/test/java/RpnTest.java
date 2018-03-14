import org.junit.Assert;
import org.junit.Test;

public class RpnTest {

    @Test
    public void zeroAddition() {
        Rpn rpn = new Rpn();
        int result = rpn.calculate("0 0 +");
        Assert.assertEquals(0, result);
    }

    @Test
    public void onePlusTwo() {
        Rpn rpn = new Rpn();
        int result = rpn.calculate("1 2 +");
        Assert.assertEquals(3, result);
    }

    @Test
    public void twoPlusThree() {
        Rpn rpn = new Rpn();
        int result = rpn.calculate("2 3 +");
        Assert.assertEquals(5, result);
    }

    @Test
    public void twoAdditionsAtTheEnd() {
        Rpn rpn = new Rpn();
        int result = rpn.calculate("2 3 4 + +");
        Assert.assertEquals(9, result);
    }

    @Test
    public void anAdditionInTheMiddleAndOneAtTheEnd() {
        Rpn rpn = new Rpn();
        int result = rpn.calculate("1 2 + 3 +");
        Assert.assertEquals(6, result);
    }

    @Test
    public void bigCombinationOfAddition() {
        Rpn rpn = new Rpn();
        int result = rpn.calculate("7 4 3 1 2 + + + + 3 +");
        Assert.assertEquals(20, result);
    }




}
