package Lab7;

import Lab7.rozetka.Rozetka;
import Lab7.rozetka.context.buyCont;

public class Main {

    public static void main(String[] args) throws Exception {
        try(Rozetka rozetka = new Rozetka()){
            buyCont buyContext = (buyCont) rozetka.getCont("buy");
            buyContext.setToBuy("macbook");
            buyContext.setMinPrice(40000);
            Thread.sleep(4000);
            buyContext.setMaxPrice(50000);
            buyContext.execute();
        }
    }
}