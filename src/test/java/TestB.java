

import mul_div.Div;
import mul_div.Mul;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestB {
    Div d = new Div();
    Mul m = new Mul();

    @Test
    @DisplayName("Multiply two integers")
    public void intMul() {
        assertEquals(32,m.mul1(4,8),"Test Passed");

    }
    @Test
    @DisplayName("Multiply two floats")
    public void floatMul() {
        assertEquals(32,m.mul2(4,8),"Test Passed");

    }

    @Test
    @DisplayName("divide two integers")
    public void intDiv() {
        assertEquals(2,d .div1(4, 2),"Test Passed");

    }



}



