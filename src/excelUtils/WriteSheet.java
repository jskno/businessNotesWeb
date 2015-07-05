package excelUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import model.Company;
import model.Product;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import persistence.PersistenceCustomer;
import persistence.PersistenceNote;
import persistence.PersistenceSupplier;

import java.lang.reflect.Field;

import dao.CompanyDAO;
import dao.CompanyDAOImpl;
import dao.CustomerDAO;
import dao.CustomerDAOImpl;
import dao.NoteDAO;
import dao.NoteDAOImpl;
import dao.ProductDAO;
import dao.ProductDAOImpl;
import dao.SupplierDAO;
import dao.SupplierDAOImpl;

public class WriteSheet 
{
   public static void main(String[] args) throws Exception 
   {
	   importProductTable();
   }
   
   public static void importCompanyTable() throws Exception 
   {
      //Create blank workbook
      XSSFWorkbook workbook = new XSSFWorkbook(); 
      //Create a blank sheet
      XSSFSheet spreadsheet = workbook.createSheet(" Table Info ");
      //Create row objects
      XSSFRow row;
      XSSFRow headerRow = spreadsheet.createRow(0);
      //This data needs to be written.
      CompanyDAO companyDao = new CompanyDAOImpl();
      List<Company> companiesList = companyDao.getCompaniesList();
      //Iterate over data and write to sheet
      Object eachCompany;
      for (int i = 0; i < companiesList.size(); i++)
      {
         row = spreadsheet.createRow(i + 1);
         int cellid = 0;
         eachCompany = companiesList.get(i);
         for (Field field : eachCompany.getClass().getDeclaredFields()) {
             field.setAccessible(true); // if you want to modify private fields
             Cell cell = row.createCell(cellid);
             cell.setCellValue("" + field.get(eachCompany));
             if(i == 0) {
            	 Cell headerCell = headerRow.createCell(cellid);
            	 headerCell.setCellValue(field.getName());
             }
             cellid++;
         }
      }
      //Write the workbook in file system
      FileOutputStream out = new FileOutputStream(new File("CompanyTable.xlsx"));
      workbook.write(out);
      out.close();
      System.out.println( 
      "Writesheet.xlsx written successfully" );
      workbook.close();
   }
   
   public static void importProductTable() throws Exception 
   {
      //Create blank workbook
      XSSFWorkbook workbook = new XSSFWorkbook(); 
      //Create a blank sheet
      XSSFSheet spreadsheet = workbook.createSheet(" Table Info ");
      //Create row objects
      XSSFRow row;
      XSSFRow headerRow = spreadsheet.createRow(0);
      //This data needs to be written.
      ProductDAO productDao = new ProductDAOImpl();
      List<Product> productsList = productDao.getProductsList();
      //Iterate over data and write to sheet
      Object eachProduct;
      for (int i = 0; i < productsList.size(); i++)
      {
         row = spreadsheet.createRow(i + 1);
         int cellid = 0;
         eachProduct = productsList.get(i);
         for (Field field : eachProduct.getClass().getDeclaredFields()) {
             field.setAccessible(true); // if you want to modify private fields
             Cell cell = row.createCell(cellid);
             cell.setCellValue("" + field.get(eachProduct));
             if(i == 0) {
            	 Cell headerCell = headerRow.createCell(cellid);
            	 headerCell.setCellValue(field.getName());
             }
             cellid++;
         }
      }
      //Write the workbook in file system
      FileOutputStream out = new FileOutputStream(new File("ProductTable.xlsx"));
      workbook.write(out);
      out.close();
      System.out.println( 
      "Writesheet.xlsx written successfully" );
      workbook.close();
   }

   private static void createHeader(XSSFSheet spreadsheet) {
	
	   XSSFRow row;
	   row = spreadsheet.createRow(1);
	   int cellid = 0;
		for (Field field : Company.class.getClass().getDeclaredFields())
	    {
	       Cell cell = row.createCell(cellid++);
	       cell.setCellValue(field.getName());
	    }
	
   }
   
   public static void importCustomerTable() throws Exception 
   {
      //Create blank workbook
      XSSFWorkbook workbook = new XSSFWorkbook(); 
      //Create a blank sheet
      XSSFSheet spreadsheet = workbook.createSheet(" Table Info ");
      //Create row objects
      XSSFRow row;
      XSSFRow headerRow = spreadsheet.createRow(0);
      //This data needs to be written.
      CustomerDAO customerDao = new CustomerDAOImpl();
      List<PersistenceCustomer> persistenceCustomersList = customerDao.getPersistenceCustomerList();
      //Iterate over data and write to sheet
      Object eachCustomer;
      for (int i = 0; i < persistenceCustomersList.size(); i++)
      {
         row = spreadsheet.createRow(i + 1);
         int cellid = 0;
         eachCustomer = persistenceCustomersList.get(i);
         for (Field field : eachCustomer.getClass().getDeclaredFields()) {
             field.setAccessible(true); // if you want to modify private fields
             Cell cell = row.createCell(cellid);
             cell.setCellValue("" + field.get(eachCustomer));
             if(i == 0) {
            	 Cell headerCell = headerRow.createCell(cellid);
            	 headerCell.setCellValue(field.getName());
             }
             cellid++;
         }
      }
      //Write the workbook in file system
      FileOutputStream out = new FileOutputStream(new File("CustomerTable.xlsx"));
      workbook.write(out);
      out.close();
      System.out.println( 
      "Writesheet.xlsx written successfully" );
      workbook.close();
   }
   
   public static void importSupplierTable() throws Exception 
   {
      //Create blank workbook
      XSSFWorkbook workbook = new XSSFWorkbook(); 
      //Create a blank sheet
      XSSFSheet spreadsheet = workbook.createSheet(" Table Info ");
      //Create row objects
      XSSFRow row;
      XSSFRow headerRow = spreadsheet.createRow(0);
      //This data needs to be written.
      SupplierDAO supplierDao = new SupplierDAOImpl();
      List<PersistenceSupplier> persistenceSuppliersList = supplierDao.getPersistenceCustomerList();
      //Iterate over data and write to sheet
      Object eachCustomer;
      for (int i = 0; i < persistenceSuppliersList.size(); i++)
      {
         row = spreadsheet.createRow(i + 1);
         int cellid = 0;
         eachCustomer = persistenceSuppliersList.get(i);
         for (Field field : eachCustomer.getClass().getDeclaredFields()) {
             field.setAccessible(true); // if you want to modify private fields
             Cell cell = row.createCell(cellid);
             cell.setCellValue("" + field.get(eachCustomer));
             if(i == 0) {
            	 Cell headerCell = headerRow.createCell(cellid);
            	 headerCell.setCellValue(field.getName());
             }
             cellid++;
         }
      }
      //Write the workbook in file system
      FileOutputStream out = new FileOutputStream(new File("SupplierTable.xlsx"));
      workbook.write(out);
      out.close();
      System.out.println( 
      "Writesheet.xlsx written successfully" );
      workbook.close();
   }
   
   public static void importNoteTable() throws Exception 
   {
      //Create blank workbook
      XSSFWorkbook workbook = new XSSFWorkbook(); 
      //Create a blank sheet
      XSSFSheet spreadsheet = workbook.createSheet(" Table Info ");
      //Create row objects
      XSSFRow row;
      XSSFRow headerRow = spreadsheet.createRow(0);
      //This data needs to be written.
      NoteDAO noteDao = new NoteDAOImpl();
      List<PersistenceNote> persistenceNotesList = noteDao.getPersistenceCustomerList();
      //Iterate over data and write to sheet
      Object eachNote;
      for (int i = 0; i < persistenceNotesList.size(); i++)
      {
         row = spreadsheet.createRow(i + 1);
         int cellid = 0;
         eachNote = persistenceNotesList.get(i);
         for (Field field : eachNote.getClass().getDeclaredFields()) {
             field.setAccessible(true); // if you want to modify private fields
             Cell cell = row.createCell(cellid);
             cell.setCellValue("" + field.get(eachNote));
             if(i == 0) {
            	 Cell headerCell = headerRow.createCell(cellid);
            	 headerCell.setCellValue(field.getName());
             }
             cellid++;
         }
      }
      //Write the workbook in file system
      FileOutputStream out = new FileOutputStream(new File("NoteTable.xlsx"));
      workbook.write(out);
      out.close();
      System.out.println( 
      "Writesheet.xlsx written successfully" );
      workbook.close();
   }


}
