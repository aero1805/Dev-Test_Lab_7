package Lab7.rozetka.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GoodTile implements Comparable{
    private WebElement tileElement;
    private String goodName;
    private int price;

    public GoodTile(WebElement tileElement, String goodName, int price) {
        this.goodName = goodName;
        this.price = price;
        this.tileElement = tileElement;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "GoodTile{" +
                "goodName='" + goodName + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        if(o == null){
            throw new NullPointerException();
        }
        if(o.getClass() != getClass()){
            throw new ClassCastException();
        }
        GoodTile leftTile = (GoodTile) o;

        if(price < leftTile.price){
            return -1;
        }else if(price > leftTile.price){
            return 1;
        }else{
            return 0;
        }
    }
    public void buy(){
        WebElement buyBtn = tileElement.findElement(By.cssSelector("[name=topurchasesfromcatalog]"));
        buyBtn.click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
