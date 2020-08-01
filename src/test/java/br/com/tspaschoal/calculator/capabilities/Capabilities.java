package br.com.tspaschoal.calculator.capabilities;

import br.com.tspaschoal.calculator.utils.Utils;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Properties;

public class Capabilities {

    public DesiredCapabilities getDesiredCapabilites() {
        final Properties bundle = Utils.loadProperties();
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", bundle.getProperty("platformName"));
        desiredCapabilities.setCapability("deviceName", bundle.getProperty("deviceName"));
        desiredCapabilities.setCapability("app", Utils.getFullPath() + bundle.getProperty("app"));
        desiredCapabilities.setCapability("ensureWebviewsHavePages", true);
        return desiredCapabilities;
    }

}
