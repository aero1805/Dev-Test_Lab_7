package Lab7.rozetka.elements;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class TextField {
    WebElement element;
    public TextField(WebElement element){
        this.element = element;
    }
    public void sendKeys(String inputString){
        element.sendKeys(Keys.chord(Keys.CONTROL, "a"),inputString);
    }
    public void submit(){
        element.submit();
    }
}
