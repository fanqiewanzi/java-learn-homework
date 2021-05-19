package utils;

import dataBase.DataBase;
import load.Load;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class LoopTest {
    public static void loopTest(HashMap<String,WebElement> webElements ,HashMap<String,String> testCases, DataBase dataBase, WebDriver driver){
        //脚本执行
        JavascriptExecutor js=(JavascriptExecutor) driver;

        int num=0;
        try {
            ResultSet resultSet=dataBase.selectStatement3.executeQuery();
            while (resultSet.next()){
                num=resultSet.getInt("COUNT(*)");
            }
        }catch (SQLException e){
            System.out.println(e);
        }

        for (int i=1;i<=2;i++){
            webElements.clear();
            testCases.clear();
            //从数据库中读取初始化原件及测试用例
            Load.load(webElements,dataBase,driver);
            Load.loadTestCase(testCases,dataBase,driver,i);

            //执行测试用例，设定的是按钮元件前面都以B开头，值为1时执行点击操作，为其他值则不执行点击
            //不为B开头则清空文本框并将测试用例中的文本放进去
            webElements.forEach((k,v)-> {
                if(k.startsWith("B")){
                    if(testCases.get(k).equals("1")){
                        js.executeScript("arguments[0].click();",v);
                    }
                }else{
                    js.executeScript("arguments[0].setAttribute('value',arguments[1]);",v,testCases.get(k));
                }
            });

            WebElement label=driver.findElement(By.xpath("/html[1]/body[1]/div[10]/div[1]/div[1]/div[2]"));
            WebElement flag=driver.findElement(By.xpath("/html[1]/body[1]/div[10]/div[1]/div[1]/div[3]/button[1]"));
                    if(testCases.get("预估结果").equals(label.getAttribute("innerText")))
                    {
                        System.out.println("CASE"+i+"PASS");
                        Reporter.log("CASE"+i+"PASS"+'\r'+label.getAttribute("innerText"));
                    }else {
                        System.out.println("CASE"+i+"BUG");
                        Reporter.log("CASE"+i+"BUG"+'\r'+label.getAttribute("innerText"));
                    }
            flag.click();
            driver.navigate().refresh();
        }
    }
}
