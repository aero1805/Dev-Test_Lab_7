package Lab7.rozetka;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import Lab7.rozetka.context.Cont;
import Lab7.rozetka.context.Manager;
import Lab7.rozetka.elements.Button;
import Lab7.rozetka.elements.GoodTile;
import Lab7.rozetka.elements.FilterPrice;
import Lab7.rozetka.elements.TextField;

import java.io.Closeable;
import java.util.ArrayList;
import java.util.List;

public class Rozetka implements Closeable {
    private WebDriver driver;
    public Rozetka(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-extensions");
        driver = new ChromeDriver(options);
        driver.get("https://rozetka.com.ua/notebooks/c80004/filter/preset=workteaching/");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public FilterPrice filterPrice(){
        return new FilterPrice(driver.findElement(
                By.ByCssSelector.cssSelector("#sort_price .price-input")));
    }
    public List<GoodTile> set1(){
        //data-view_type="catalog_with_hover"
        List<WebElement> tiles = driver.
                findElements(By.ByCssSelector.cssSelector("[data-view_type=catalog_with_hover]"));
        List<GoodTile> result = new ArrayList<>();
        for(WebElement tile:tiles){
            String goodName = tile.findElement(By.className("g-i-tile-i-title")).getText();
            String priceRaw = tile.findElement(By.className("g-price-uah")).getText();
            int price = Integer.valueOf(priceRaw
                    .substring(0,priceRaw.length()-3)
                    .replace("\u2009","")
                    .replace(" ",""));
            result.add(new GoodTile(tile,goodName,price));
        }

        return result;
    }

    public void search(String string){
        WebElement searchElement = driver.findElement(By.className("rz-header-search-input-text"));
        TextField searchField = new TextField(searchElement);
        searchField.sendKeys(string);
        WebElement searchButtonElement = driver.findElement(By.className("js-rz-search-button"));
        Button searchButton = new Button(searchButtonElement);
        searchButton.submit();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Cont getCont(String Name){
        Cont context = Manager.getContext(Name);
        context.setRozetka(this);
        return context;
    }



    public WebDriver getDriver(){
        return this.driver;
    }

    @Override
    public void close()  {
        driver.close();
    }
}
