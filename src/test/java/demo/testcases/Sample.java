package demo.testcases;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Sample {

    private static final Logger logger = LogManager.getLogger(Sample.class);
    public static void main(String[] args) {
        System.out.println("Hi");
        BasicConfigurator.configure();
        logger.info("I am logger");
    }
}
