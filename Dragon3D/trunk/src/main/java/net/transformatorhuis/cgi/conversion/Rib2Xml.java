package net.transformatorhuis.cgi.conversion;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import java.io.FileReader;
import java.io.StreamTokenizer;
import java.io.IOException;

import net.transformatorhuis.cgi.utils.Config;

import java.util.Vector;

/**
 * @author cyberroadie
 *
 */
class Rib2Xml {

    /**
     * Logger.
     */
    private static Logger logger = Logger.getLogger(Rib2Xml.class);

    /**
     * @param ribFileReader rib file reader
     */
    public Rib2Xml(FileReader ribFileReader) {

        /* Create the ribfactory which deal with all the rib elements */
        Config config = Config.instance();
        RibFactory ribFac = new RibFactory(config);

        Vector ribNames = config.getNames();

        StreamTokenizer thTokens = new StreamTokenizer(ribFileReader);
        // thTokens.resetSyntax();
        thTokens.commentChar('#');
        thTokens.eolIsSignificant(false);
        thTokens.parseNumbers();
        thTokens.ordinaryChar('[');
        thTokens.ordinaryChar(']');
        thTokens.quoteChar('"');
        int count = 0;


            String factoryInput = "";

            try {
                while (thTokens.nextToken() != StreamTokenizer.TT_EOF) {
                    logger.debug(thTokens.lineno() + ": " + thTokens.sval
                            + ": ttype: " + thTokens.ttype);
                    if (thTokens.ttype == StreamTokenizer.TT_NUMBER) {
                        logger.debug(thTokens.lineno() + ": " + thTokens.nval);
                        factoryInput += " " + String.valueOf(thTokens.nval);
                        count++;
                    } else if (thTokens.ttype == StreamTokenizer.TT_WORD) {
                        if (ribNames.contains(thTokens.sval)) {
                            logger.debug(factoryInput);

                            // AbstractRib Factory called to add an element to xml document
                            logger
                                    .debug("Elements: " + count + ": "
                                            + factoryInput);
                            ribFac.processRibElement(factoryInput);

                            factoryInput = thTokens.sval;
                        } else {
                            factoryInput += " " + thTokens.sval;
                        }
                        logger.debug(thTokens.lineno() + ": " + thTokens.sval);
                        count++;
                    } else {
                        if (thTokens.ttype != '"') {
                            logger.debug(thTokens.lineno() + ": "
                                    + (char) thTokens.ttype);
                            factoryInput += " " + (char) thTokens.ttype;
                            count++;
                        } else if (thTokens.sval != null) {
                            logger.debug(thTokens.lineno() + ": "
                                    + (char) thTokens.ttype + thTokens.sval
                                    + (char) thTokens.ttype);
                            factoryInput += " " + (char) thTokens.ttype
                                    + thTokens.sval + (char) thTokens.ttype;
                            count++;
                        }
                    }

                }
            } catch (IOException e) {
                logger.error(e.toString());
            }

        

        logger.info("Tokens: " + count);

        RibDocument ribDoc = RibDocument.newInstance();
        ribDoc.toFile();
    }
    

    /**
     * @param argv additional arguments
     */
    public static void main(String[] argv) {

        //BasicConfigurator.configure();
        DOMConfigurator.configure("src/conf/log4j.xml");
        // is there anything to do?
        if (argv.length == 0) {
            printUsage();
            System.exit(1);
        }

        try {
            new Rib2Xml(new FileReader(argv[0]));
            logger.info("Input file: " + argv[0]);
        } catch (IOException ioe) {
            logger.info(ioe.toString());
            System.exit(1);
        }

    }
    
    /**
     * Print usage.
     */
    private static void printUsage() {
        System.err.println("Usage: java -jar ribxml.jar [rib file]");
    }

    /**
     * Start the conversion.
     */
    public void start() {
        // TODO Refactor this, get everything out of constructor
    }

}