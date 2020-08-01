package br.com.tspaschoal.calculator;

import br.com.tspaschoal.calculator.capabilities.Capabilities;
import br.com.tspaschoal.calculator.utils.Input;
import br.com.tspaschoal.calculator.utils.Numbers;
import br.com.tspaschoal.calculator.utils.Operators;
import br.com.tspaschoal.calculator.utils.Utils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.*;
import static org.junit.Assert.*;

import org.openqa.selenium.remote.DesiredCapabilities;
import java.io.IOException;
import java.net.URL;

public class CalculatorTest {

    private AndroidDriver<MobileElement> driver;

    @Before
    public void setUp() throws IOException {

        final DesiredCapabilities desiredCapabilites = new Capabilities().getDesiredCapabilites();
        URL remoteUrl = new URL(Utils.loadProperties().getProperty("remote_url"));
        driver = new AndroidDriver(remoteUrl, desiredCapabilites);
    }

    @Test
    public void shouldReturnFourAsResultBySumBetweenTwoAndTwo() throws InterruptedException {

        final long expectedValue = 4;

        Thread.sleep(3000);

        driver.findElementById(Numbers.DIGIT_TWO_ID).click();
        driver.findElementByAccessibilityId(Operators.SUM).click();
        driver.findElementById(Numbers.DIGIT_TWO_ID).click();
        driver.findElementByAccessibilityId(Operators.EQUALS).click();

        MobileElement inputResult = (MobileElement) driver.findElementById(Input.INPUT_RESULT);
        inputResult.click();

        final long currentValue = Long.parseLong(inputResult.getText());
        assertEquals(expectedValue, currentValue);
    }

    @Test
    public void shouldReturnFiveAsResultByDivisionBetweenFifteenAndThree() throws InterruptedException {

        final long expectedValue = 5;

        Thread.sleep(3000);

        driver.findElementById(Numbers.DIGIT_ONE_ID).click();
        driver.findElementById(Numbers.DIGIT_FIVE_ID).click();
        driver.findElementByAccessibilityId(Operators.DIVISION).click();
        driver.findElementById(Numbers.DIGIT_THREE_ID).click();
        driver.findElementByAccessibilityId(Operators.EQUALS).click();

        MobileElement inputResult = (MobileElement) driver.findElementById(Input.INPUT_RESULT);
        inputResult.click();

        final long currentValue = Long.parseLong(inputResult.getText());
        assertEquals(expectedValue, currentValue);
    }

    @Test
    public void shouldReturnNineAsResultByMultiplyBetweenThreeAndThree() throws InterruptedException {

        final long expectedValue = 9;

        Thread.sleep(3000);

        driver.findElementById(Numbers.DIGIT_THREE_ID).click();
        driver.findElementByAccessibilityId(Operators.MULTIPLY).click();
        driver.findElementById(Numbers.DIGIT_THREE_ID).click();
        driver.findElementByAccessibilityId(Operators.EQUALS).click();

        MobileElement inputResult = (MobileElement) driver.findElementById(Input.INPUT_RESULT);
        inputResult.click();

        final long currentValue = Long.parseLong(inputResult.getText());
        assertEquals(expectedValue, currentValue);
    }

    @Test
    public void shouldReturnTwoAsResultBySubtractBetweenFourAndTwo() throws InterruptedException {

        final long expectedValue = 2;

        Thread.sleep(3000);

        driver.findElementById(Numbers.DIGIT_FOUR_ID).click();
        driver.findElementByAccessibilityId(Operators.SUBTRACT).click();
        driver.findElementById(Numbers.DIGIT_TWO_ID).click();
        driver.findElementByAccessibilityId(Operators.EQUALS).click();

        MobileElement inputResult = (MobileElement) driver.findElementById(Input.INPUT_RESULT);
        inputResult.click();

        final long currentValue = Long.parseLong(inputResult.getText());
        assertEquals(expectedValue, currentValue);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
