package Lab7.rozetka.context;

import java.util.HashMap;
import java.util.Map;

public class Manager {
    private static Manager instance = getInstance();
    static Map<String, Cont> contextMap = new HashMap<>();
    static {
        contextMap.put("buy", new buyCont());
    }
    private Manager(){}
    public static Manager getInstance(){
        if(instance == null){
            return new Manager();
        }else{
            return instance;
        }
    }
    public static Cont getContext(String contextName){
        return contextMap.get(contextName);
    }
}
