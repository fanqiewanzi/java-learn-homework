package pageTests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;


/**
 * @author BAZINGA
 */
public class Login {

    private static final String  ADDRESS="http://zy-shop.91jkys.com/web/index.php?r=admin%2Fpassport%2Flogin";
    private static final String INDEX_ADDRESS="http://zy-shop.91jkys.com/web/index.php?r=admin%2Fuser%2Fme";

    public static void login(WebDriver driver) {

        WebDriver webDriver=driver;

        webDriver.get(ADDRESS);

        webDriver.manage().deleteAllCookies();

        Cookie cookie=new Cookie("_admin_identity", "a3c60ef73de25a2269099b57a7da2b34c2cba699a8eea1f6c02a611a310874f0a%3A2%3A%7Bi%3A0%3Bs%3A15%3A%22_admin_identity%22%3Bi%3A1%3Bs%3A49%3A%22%5B10009%2C%22Tkfmmo8QbBK88_H_21Ine6N9PbyE7DXV%22%2C259200%5D%22%3B%7D");

        webDriver.manage().addCookie(cookie);

        webDriver.get(INDEX_ADDRESS);
        webDriver.navigate().refresh();

        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
}

}


