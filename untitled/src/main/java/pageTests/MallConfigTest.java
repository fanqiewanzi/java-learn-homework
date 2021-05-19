package pageTests;

import dataBase.DataBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;
import org.testng.annotations.Test;
import utils.LoopTest;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class MallConfigTest {
    public DataBase dataBase;
    private WebDriver driver;
    static final String INTERFACE_ADDRESS="http://zy-shop.91jkys.com/web/index.php?r=admin%2Fapp%2Findex";

    @Test()
    public void MallCfTest(){
        Reporter.log("start");
        dataBase=new DataBase();
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        ChromeOptions chromeOptions=new ChromeOptions();
//        chromeOptions.addArguments("--headless");
        driver=new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        //登录
        Login.login(driver);

        //我的小程序商城
        WebElement mallInterface=driver.findElement(By.xpath("/html/body/main/div/div[1]/div/ul/li[2]/ul[1]/li/a/span"));
        mallInterface.click();

        //进入商城
        WebElement jrsc=driver.findElement(By.xpath("/html/body/main/div/div[2]/div/table/tbody/tr/td[3]/a[1]"));
        jrsc.click();

        //系统管理
        WebElement xtgl=driver.findElement(By.xpath("/html/body/div[5]/div[1]/div[2]/a[1]/span[2]"));
        xtgl.click();

        //用来放页面元件及测试用例的哈希表
        HashMap<String,WebElement> webElements=new HashMap<>();
        HashMap<String,String> testCases=new HashMap<>();

        //循环测试将所有测试用例执行完
        LoopTest.loopTest(webElements,testCases,dataBase,driver);

        //关闭浏览器
        driver.quit();
        Reporter.log("end");
    }
}
