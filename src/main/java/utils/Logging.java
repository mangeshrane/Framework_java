package utils;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


public class Logging {

    private static boolean root = false;
    public static Logger getLogger(@SuppressWarnings("rawtypes") Class clas) {
        if(root)
            return Logger.getLogger(clas);
        PropertyConfigurator.configure(new ResourceProvider().getResource("logger/log.properties"));
        root = true;
        return Logger.getLogger(clas);
    }
}
