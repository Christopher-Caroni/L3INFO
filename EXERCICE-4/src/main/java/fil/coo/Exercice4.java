package fil.coo;

import org.apache.log4j.Logger;

import java.io.IOException;

public class Exercice4 {

    private static final Logger logger = Logger.getLogger(Exercice4.class.getSimpleName());

    public static void main(String[] args) {

        SimplePluginObserver simplePluginObserver = null;
        try {
//            Staticallly use resources folder because it must be in the classpath beforehand
            simplePluginObserver = new SimplePluginObserver("resources/plugin");
        } catch (IOException e) {
            logger.info(e.getMessage());
            System.exit(1);
        }


        simplePluginObserver.start();
        while (true) ;
    }

}
