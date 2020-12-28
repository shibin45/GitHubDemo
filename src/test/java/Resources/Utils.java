package Resources;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.io.*;
import java.util.Properties;
import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Utils {

    public static RequestSpecification reqSpec;
    public static ResponseSpecification resSpec;


    public RequestSpecification requestSpecification() throws IOException {
        //RestAssured.baseURI="http://cerebro.dev.livspace.com/";
        if (reqSpec == null) {
            PrintStream logFile = new PrintStream(new FileOutputStream("logging.txt"));
            reqSpec = new RequestSpecBuilder().setBaseUri(GlobalVariable("baseURI"))
                    .addFilter(RequestLoggingFilter.logRequestTo(logFile))
                    .addFilter(ResponseLoggingFilter.logResponseTo(logFile))
                    .setContentType(ContentType.JSON).build();
            return reqSpec;
        }
        return reqSpec;
    }

    public ResponseSpecification responseSpecification() {
        resSpec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
        return resSpec;
    }

    public String GlobalVariable(String key) throws IOException {
        Properties fileProperties = new Properties();
        FileInputStream fis = new FileInputStream("/Users/shibins/OPIAutomationFramework/src/test/java/Resources/Global.properties");
        fileProperties.load(fis);
        return fileProperties.getProperty(key);


    }

    public void createFile() {

        try {
            PrintStream logFile = new PrintStream(new FileOutputStream("/Users/shibins/OPIAutomationFramework/target/data.txt"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
