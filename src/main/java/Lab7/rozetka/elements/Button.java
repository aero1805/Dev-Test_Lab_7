package Lab7.rozetka.elements;

import org.openqa.selenium.WebElement;

public class Button {
    WebElement element;

    public Button(WebElement element){
        this.element = element;
    }

    public void submit(){
        element.submit();
    }
    public void click(){
        element.click();
    }

}
