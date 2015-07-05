package excelUtils;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import model.Company;
import model.Customer;
import model.Note;
import model.Product;
import model.Supplier;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

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

public class ImportTable {
	
   static XSSFRow row;
   
   public static void main(String[] args) throws Exception 
   {
      FileInputStream fis = new FileInputStream(new File("WriteSheet.xlsx"));
      XSSFWorkbook workbook = new XSSFWorkbook(fis);
      XSSFSheet spreadsheet = workbook.getSheetAt(0);
      Iterator <Row> rowIterator = spreadsheet.iterator();
      while (rowIterator.hasNext()) 
      {
         row = (XSSFRow) rowIterator.next();
         Iterator <Cell> cellIterator = row.cellIterator();
         while (cellIterator.hasNext()) 
         {
            Cell cell = cellIterator.next();
            switch (cell.getCellType()) 
            {
               case Cell.CELL_TYPE_NUMERIC:
               System.out.print( 
               cell.getNumericCellValue() + " \t\t " );
               break;
               case Cell.CELL_TYPE_STRING:
               System.out.print(
               cell.getStringCellValue() + " \t\t " );
               break;
            }
         }
         System.out.println();
      }
      fis.close();
      workbook.close();
   }
   
   public static void importCompanyTable() throws Exception {
      FileInputStream fis = new FileInputStream(new File("C:\\Users\\Jose\\Desktop\\CompanyTable.xlsx"));
      XSSFWorkbook workbook = new XSSFWorkbook(fis);
      XSSFSheet spreadsheet = workbook.getSheetAt(0);
      Iterator <Row> rowIterator = spreadsheet.iterator();
      
      String companyName;
      String companyTelephone;
      String companyEmail;
      Company company = null;
      List<Company> companiesList = new ArrayList<Company>();
      CompanyDAO companyDao = new CompanyDAOImpl();
      
      while (rowIterator.hasNext()) 
      {
         row = (XSSFRow) rowIterator.next();
         Cell firstCell = row.createCell(0);
         Cell secondCell = row.createCell(1);
         Cell thirdCell = row.createCell(2);
         
         companyName = firstCell.getStringCellValue();
         companyTelephone = secondCell.getStringCellValue();
         companyEmail = thirdCell.getStringCellValue();
         
         company = new Company(companyName, companyTelephone, companyEmail);
             
      }
      companiesList.add(company);
      companyDao.insertList(companiesList);
      
      fis.close();
      workbook.close();
   }
   
   public static void importProductTable() throws Exception {
	      FileInputStream fis = new FileInputStream(new File("C:\\Users\\Jose\\Desktop\\ProductTable.xlsx"));
	      XSSFWorkbook workbook = new XSSFWorkbook(fis);
	      XSSFSheet spreadsheet = workbook.getSheetAt(0);
	      Iterator <Row> rowIterator = spreadsheet.iterator();
	      
	      String productCode;
	      String productDescription;
	      Product product = null;
	      List<Product> productList = new ArrayList<Product>();
	      ProductDAO productDao = new ProductDAOImpl();
	      
	      while (rowIterator.hasNext()) 
	      {
	         row = (XSSFRow) rowIterator.next();
	         Cell firstCell = row.createCell(0);
	         Cell secondCell = row.createCell(1);
	         
	         productCode = firstCell.getStringCellValue();
	         productDescription = secondCell.getStringCellValue();
	         
	         product = new Product(productCode, productDescription);
	             
	      }
	      productList.add(product);
	      productDao.insertList(productList);
	      
	      fis.close();
	      workbook.close();
	   }
   
   public static void importCustomerTable() throws Exception {
	      FileInputStream fis = new FileInputStream(new File("C:\\Users\\Jose\\Desktop\\CustomerTable.xlsx"));
	      XSSFWorkbook workbook = new XSSFWorkbook(fis);
	      XSSFSheet spreadsheet = workbook.getSheetAt(0);
	      Iterator <Row> rowIterator = spreadsheet.iterator();
	      
	      String companyId;
	      String contactName;
	      String contactTelephone;
	      Customer customer = null;
	      Company company = null;
	      List<Customer> customersList = new ArrayList<Customer>();
	      CustomerDAO customerDao = new CustomerDAOImpl();
	      CompanyDAO companyDao = new CompanyDAOImpl();
	      
	      while (rowIterator.hasNext()) 
	      {
	         row = (XSSFRow) rowIterator.next();
	         Cell firstCell = row.createCell(0);
	         Cell secondCell = row.createCell(1);
	         Cell thirdCell = row.createCell(2);
	         
	         companyId = firstCell.getStringCellValue();
	         contactName = secondCell.getStringCellValue();
	         contactTelephone = thirdCell.getStringCellValue();
	         
	         company = companyDao.getCompanyById(Integer.valueOf(companyId));
	         customer = new Customer(company, contactName, contactTelephone);
	             
	      }
	      customersList.add(customer);
	      customerDao.insertList(customersList);
	      
	      fis.close();
	      workbook.close();
	   }
   
   public static void importSupplierTable() throws Exception {
	      FileInputStream fis = new FileInputStream(new File("C:\\Users\\Jose\\Desktop\\SupplierTable.xlsx"));
	      XSSFWorkbook workbook = new XSSFWorkbook(fis);
	      XSSFSheet spreadsheet = workbook.getSheetAt(0);
	      Iterator <Row> rowIterator = spreadsheet.iterator();
	      
	      String companyId;
	      String contactName;
	      String contactTelephone;
	      Supplier supplier = null;
	      Company company = null;
	      List<Supplier> suppliersList = new ArrayList<Supplier>();
	      SupplierDAO supplierDao = new SupplierDAOImpl();
	      CompanyDAO companyDao = new CompanyDAOImpl();
	      
	      while (rowIterator.hasNext()) 
	      {
	         row = (XSSFRow) rowIterator.next();
	         Cell firstCell = row.createCell(0);
	         Cell secondCell = row.createCell(1);
	         Cell thirdCell = row.createCell(2);
	         
	         companyId = firstCell.getStringCellValue();
	         contactName = secondCell.getStringCellValue();
	         contactTelephone = thirdCell.getStringCellValue();
	         
	         company = companyDao.getCompanyById(Integer.valueOf(companyId));
	         supplier = new Supplier(company, contactName, contactTelephone);
	             
	      }
	      suppliersList.add(supplier);
	      supplierDao.insertList(suppliersList);
	      
	      fis.close();
	      workbook.close();
	   }
   
   public static void importNoteTable() throws Exception {
	      FileInputStream fis = new FileInputStream(new File("C:\\Users\\Jose\\Desktop\\NoteTable.xlsx"));
	      XSSFWorkbook workbook = new XSSFWorkbook(fis);
	      XSSFSheet spreadsheet = workbook.getSheetAt(0);
	      Iterator <Row> rowIterator = spreadsheet.iterator();
	      
	      int customerId;
	      int supplierId;
	      int productId;
	      String noteTitle;
	      String noteText;
	      Date creationDate;
	      
	      Note note = null;
	      Customer customer = null;
	      Supplier supplier = null;
	      Product product = null;
	      List<Note> notesList = new ArrayList<Note>();
	      NoteDAO noteDao = new NoteDAOImpl();
	      CustomerDAO customerDao = new CustomerDAOImpl();
	      SupplierDAO supplierDao = new SupplierDAOImpl();
	      ProductDAO productDao = new ProductDAOImpl();
	      	      
	      while (rowIterator.hasNext()) 
	      {
	         row = (XSSFRow) rowIterator.next();
	         Cell firstCell = row.createCell(0);
	         Cell secondCell = row.createCell(1);
	         Cell thirdCell = row.createCell(2);
	         Cell fourthCell = row.createCell(2);
	         Cell fifthCell = row.createCell(2);
	         Cell sixthCell = row.createCell(2);
	         
	         customerId = (int) firstCell.getNumericCellValue();
	         supplierId = (int) secondCell.getNumericCellValue();
	         productId = (int) thirdCell.getNumericCellValue();
	         noteTitle = fourthCell.getStringCellValue();
	         noteText = fifthCell.getStringCellValue();
	         creationDate = sixthCell.getDateCellValue();
	         
	         customer = customerDao.getCustomerById(customerId);
	         supplier = supplierDao.getSupplierById(supplierId);
	         product = productDao.getProductById(productId);
	         
	         note = new Note(customer, supplier, product,
	        		 		noteTitle, noteText, creationDate);
	             
	      }
	      notesList.add(note);
	      noteDao.insertList(notesList);
	      
	      fis.close();
	      workbook.close();
	   }
}
