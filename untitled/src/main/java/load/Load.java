package load;

import dataBase.DataBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class Load {
    public static void load(HashMap<String, WebElement> webElements, DataBase dataBase, WebDriver driver){
        try{
            ResultSet resultSet=dataBase.selectStatement1.executeQuery();
            while (resultSet.next()){
                String name=resultSet.getString("name");
                String xpath=resultSet.getString("xpath");
                if(xpath!=null){
                    webElements.put(name,driver.findElement(By.xpath(xpath)));
                }
            }
        }catch (SQLException e){
            System.out.println(e);
        }
    }

    public static void loadTestCase(HashMap<String,String> testCases, DataBase dataBase, WebDriver driver,int index) {
        String caseName="case"+index;
        try {
            ResultSet resultSet = dataBase.selectStatement2.executeQuery();
            for (int i = 1;resultSet.next(); i++) {
                String name = resultSet.getString("name");
                String value= resultSet.getString(caseName);
                if (value != null) {
                    testCases.put(name, value);
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

}
