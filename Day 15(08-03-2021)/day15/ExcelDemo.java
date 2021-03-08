package day15;

import jxl.Workbook;
import jxl.write.*;

import java.io.File;
import java.io.IOException;

public class ExcelDemo {

    private static final String EXCEL_FILE_LOCATION = "MyFirstExcel.xls";

    public static void main(String[] args) {

        //1. Create an Excel file
        WritableWorkbook myFirstWbook = null;
        try {

            myFirstWbook = Workbook.createWorkbook(new File(EXCEL_FILE_LOCATION));

            // create an Excel sheet
            WritableSheet excelSheet = myFirstWbook.createSheet("Sheet 1", 0);

            // add something into the Excel sheet
            Label label = new Label(0, 0, "Customer Name");
            excelSheet.addCell(label);

            label = new Label(0, 1, "Akshay");
            excelSheet.addCell(label);

            label = new Label(3, 0, "Bill No");
            excelSheet.addCell(label);

            label = new Label(3, 1, "123243534");
            excelSheet.addCell(label);
            
            label = new Label(5, 0, "Bill Date");
            excelSheet.addCell(label);

            label = new Label(5, 1, "08/03/2021");
            excelSheet.addCell(label);
            
            label = new Label(0, 3, "s.no");
            excelSheet.addCell(label);         
          
            label = new Label(1, 3, "Item");
            excelSheet.addCell(label);        
            
            label = new Label(2, 3, "Item No");
            excelSheet.addCell(label);        
            
            label = new Label(3, 3, "Price");
            excelSheet.addCell(label);        
            
            label = new Label(4, 3, "Quantity");
            excelSheet.addCell(label);        
            
            label = new Label(5, 3, "Amount");
            excelSheet.addCell(label);   
            
            String ip[]= {"0","Item","324234","100","1","700"};
            for(int j=4;j<=20;j++) {
            	int amt=0;
            for(int i=0;i<=5;i++) {
            	if(i==0) {
            		label = new Label(i, j, Integer.toString((j-3)));
            	}
               else if(i==1) {
            	   label = new Label(i, j, ip[i]+Integer.toString((j-3)));
               }
               else if(i==2){
            	   label = new Label(i, j, ip[i]+Integer.toString((j+678)));
               }
               else if(i==3){
            	   label = new Label(i, j, Integer.toString((j*i+647)));
            	   amt+=(j*i+647);
               }
               else if(i==4){
            	   label = new Label(i, j,Integer.toString((j+i)));
            	   amt*=(j+i);
               }
            	else {
            		label = new Label(i, j, Integer.toString(amt));
            	}
                excelSheet.addCell(label);
               
            }
            amt=0;
            }
            myFirstWbook.write();


        } catch (IOException e) {
            e.printStackTrace();
        } catch (WriteException e) {
            e.printStackTrace();
        } finally {

            if (myFirstWbook != null) {
                try {
                    myFirstWbook.close();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (WriteException e) {
                    e.printStackTrace();
                }
            }


        }

    }

}