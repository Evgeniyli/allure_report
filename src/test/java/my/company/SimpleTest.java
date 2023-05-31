package my.company;

import org.testng.annotations.Test;

import static io.qameta.allure.Allure.step;

/**
 * @author baev (Dmitry Baev)
 */
public class SimpleTest {

    @Test
    public void simpleTestOne() {
        step("step 1");
    }
    @Test
    public void simpleTestTwo() {
        step("step 1");
        step("step 2");
    }

    @Test
    public void simpleTestThree() {
        step("step 4");
        step("step 55");
    }

    @Test
    public void simpleTestFourth() {
        step("step 77777");
        step("step 888888");
    }
}

