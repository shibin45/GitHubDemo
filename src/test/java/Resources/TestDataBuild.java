package Resources;

import Pojo.Request.BoqSetter;
import Pojo.Request.boq_items;
import Pojo.Response.Boq;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestDataBuild {

    Response response;
    Boq boq;
    String PM, TR;
    int count = 0, BoqCount, ArrayCount = 0;

    public BoqSetter sendBoq(int BoqCount, String[] PM_TR_data) {
        //RestAssured.baseURI="http://cerebro.dev.livspace.com/";
        BoqSetter setItem = new BoqSetter();
        this.BoqCount = BoqCount;
        List<boq_items> itemList = new ArrayList<boq_items>();
        ;
        //BoqItems itemList=new BoqItems();
        //boq_items itemDetails = new boq_items();

        for (int ItemArray = 0; ItemArray < BoqCount; ItemArray++) {
            boq_items itemDetails = new boq_items();
            int sellerId = Integer.parseInt(PM_TR_data[ArrayCount + ItemArray]);
            itemDetails.setSeller_id(sellerId);
            int BillTo = Integer.parseInt(PM_TR_data[ArrayCount + ItemArray + 1]);
            itemDetails.setBill_to(BillTo);
            int shipTo = Integer.parseInt(PM_TR_data[ArrayCount + ItemArray + 2]);
            itemDetails.setShip_to(shipTo);
            itemDetails.setCurrency(PM_TR_data[ArrayCount + ItemArray + 3]);
            int projectId = Integer.parseInt(PM_TR_data[ArrayCount + ItemArray + 4]);
            itemDetails.setProject_id(projectId);
            int setBill_to = Integer.parseInt(PM_TR_data[ArrayCount + ItemArray + 5]);
            itemDetails.setBill_to(setBill_to);
            int setSales_channel = Integer.parseInt(PM_TR_data[ArrayCount + ItemArray + 6]);
            itemDetails.setSales_channel(setSales_channel);
            itemDetails.setSku_code(PM_TR_data[ArrayCount + ItemArray + 7]);
            itemDetails.setProduct_name(PM_TR_data[ArrayCount + ItemArray + 8]);
            int setHandling_fee = Integer.parseInt(PM_TR_data[ArrayCount + ItemArray + 9]);
            itemDetails.setHandling_fee(setHandling_fee);
            int setItem_unit_price = Integer.parseInt(PM_TR_data[ArrayCount + ItemArray + 10]);
            itemDetails.setItem_unit_price(setItem_unit_price);//(123);
            int setItem_quantity = Integer.parseInt(PM_TR_data[ArrayCount + ItemArray + 11]);
            itemDetails.setItem_quantity(setItem_quantity);//(1234);
            int setItem_tax = Integer.parseInt(PM_TR_data[ArrayCount + ItemArray + 12]);
            itemDetails.setItem_tax(setItem_tax);
            int setItem_discount = Integer.parseInt(PM_TR_data[ArrayCount + ItemArray + 13]);
            itemDetails.setItem_discount(setItem_discount);
            itemDetails.setHsn_code(PM_TR_data[ArrayCount + ItemArray + 14]);
            itemDetails.setParent_id(PM_TR_data[ArrayCount + ItemArray + 15]);
            itemDetails.setEta(PM_TR_data[ArrayCount + ItemArray + 16]);
            itemDetails.setBrand_name(PM_TR_data[ArrayCount + ItemArray + 17]);
            int setCategory_id = Integer.parseInt(PM_TR_data[ArrayCount + ItemArray + 18]);
            itemDetails.setCategory_id(setCategory_id);
            itemDetails.setPayment_milestone(PM_TR_data[ArrayCount + ItemArray + 19]);
            itemDetails.setTake_rate_strategy(PM_TR_data[ArrayCount + ItemArray + 20]);
            ArrayCount = ArrayCount + 20;
            itemList.add(itemDetails);
        }
        setItem.setBoqItem(itemList);
        return setItem;
    }

    public Response methodSelector(String method, RequestSpecification req, ApiResources resourceAPI, ResponseSpecification resSpec) {
        if (method.equalsIgnoreCase("post")) {
            response = req.when().post(resourceAPI.getResources());
        } else if (method.equalsIgnoreCase("get")) {
            response = req.when().get(resourceAPI.getResources());
        }
        return response;
    }


    public void ExcelData() {
        try {
            //obtaining input bytes from a file
            FileInputStream fis = new FileInputStream(new File("/Users/shibins/OPIAutomationFramework/target/data.xls"));
//creating workbook instance that refers to .xls file
            HSSFWorkbook wb = new HSSFWorkbook(fis);
//creating a Sheet object to retrieve the object
            HSSFSheet sheet = wb.getSheetAt(0);
//evaluating cell type
            FormulaEvaluator formulaEvaluator = wb.getCreationHelper().createFormulaEvaluator();
            for (Row row : sheet)     //iteration over row using for each loop
            {
                for (Cell cell : row)    //iteration over cell using for each loop
                {
                    switch (formulaEvaluator.evaluateInCell(cell).getCellType()) {
                        case NUMERIC:   //field that represents numeric cell type
//getting the value of the cell as a number
                            System.out.print(cell.getNumericCellValue() + "\t\t");
                            break;
                        case STRING:    //field that represents string cell type
//getting the value of the cell as a string
                            System.out.print(cell.getStringCellValue() + "\t\t");
                            break;
                    }
                }
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String[] readTextFile(int BoqCount) throws IOException {
        String[] PM_TR_data = new String[BoqCount * 21];

        try {

            String fileName = "/Users/shibins/OPIAutomationFramework/target/data.txt";
            File file = new File(fileName);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            String[] PM_TR;

            while ((line = br.readLine()) != null) {
                //process the line
                PM_TR = line.split("\\|");
                for (int i = 0; i < PM_TR.length; i++) {
                    PM_TR_data[count] = PM_TR[i];
                    count++;

                }
                if(count==(BoqCount * 21))
                {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        /*for (int i = 0; i < PM_TR_data.length; i++) {
            System.out.println(PM_TR_data[i]);
        }*/
        count = 0;
        return PM_TR_data;
    }
}
