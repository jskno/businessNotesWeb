package excelUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
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

public class ExportTable 
{
	public static void main (String [] args) {
		try {
			exportNoteTable();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void exportCompanyTable()
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
      for (int i = 0; i < companiesList.size(); i++) {
         row = spreadsheet.createRow(i + 1);
         int cellid = 0;
         eachCompany = companiesList.get(i);
         for (Field field : eachCompany.getClass().getDeclaredFields()) {
             field.setAccessible(true); // if you want to modify private fields
             Cell cell = row.createCell(cellid);
             try {
				cell.setCellValue("" + field.get(eachCompany));
			} catch (IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
			}
             if(i == 0) {
            	 Cell headerCell = headerRow.createCell(cellid);
            	 headerCell.setCellValue(field.getName());
             }
             cellid++;
         }
      }
      
      //Write the workbook in file system
      FileOutputStream out = null;
	try {
		out = new FileOutputStream(new File("C:\\Users\\Jose\\Desktop\\CompanyTable.xlsx"));
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
      try {
		workbook.write(out);
		out.close();
		System.out.println("CompanyTable.xlsx written successfully" );
		workbook.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
   
   public static void exportProductTable() throws Exception 
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
      FileOutputStream out = new FileOutputStream(new File("C:\\Users\\Jose\\Desktop\\ProductTable.xlsx"));
      workbook.write(out);
      out.close();
      System.out.println( 
      "ProductTable.xlsx written successfully" );
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
   
   public static void exportCustomerTable() throws Exception 
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
      FileOutputStream out = new FileOutputStream(new File("C:\\Users\\Jose\\Desktop\\CustomerTable.xlsx"));
      workbook.write(out);
      out.close();
      System.out.println( 
      "CustomerTable.xlsx written successfully" );
      workbook.close();
   }
   
   public static void exportSupplierTable() throws Exception 
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
      FileOutputStream out = new FileOutputStream(new File("C:\\Users\\Jose\\Desktop\\SupplierTable.xlsx"));
      workbook.write(out);
      out.close();
      System.out.println( 
      "SupplierTable.xlsx written successfully" );
      workbook.close();
   }
   
   public static void exportNoteTable() throws Exception 
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
      FileOutputStream out = new FileOutputStream(new File("C:\\Users\\Jose\\Desktop\\NoteTable.xlsx"));
      workbook.write(out);
      out.close();
      System.out.println( 
      "NoteTable.xlsx written successfully" );
      workbook.close();
   }


}
