package excelUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import model.CompanyVO;
import model.CustomerVO;
import model.NoteVO;
import model.ProductVO;
import model.SupplierVO;

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

	private static XSSFRow row;
	private static final String PATH = "C:\\Users\\Jose\\Desktop\\";

	public static void main(String[] args) throws Exception {
		FileInputStream fis = new FileInputStream(new File("WriteSheet.xlsx"));
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet spreadsheet = workbook.getSheetAt(0);
		Iterator<Row> rowIterator = spreadsheet.iterator();
		while (rowIterator.hasNext()) {
			row = (XSSFRow) rowIterator.next();
			Iterator<Cell> cellIterator = row.cellIterator();
			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();
				switch (cell.getCellType()) {
				case Cell.CELL_TYPE_NUMERIC:
					System.out.print(cell.getNumericCellValue() + " \t\t ");
					break;
				case Cell.CELL_TYPE_STRING:
					System.out.print(cell.getStringCellValue() + " \t\t ");
					break;
				}
			}
			System.out.println();
		}
		fis.close();
		workbook.close();
	}

	public static void importCompanyTable(String file) throws Exception {
		FileInputStream fis = new FileInputStream(new File(PATH + file));
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet spreadsheet = workbook.getSheetAt(0);
		Iterator<Row> rowIterator = spreadsheet.iterator();

		String companyName;
		String companyTelephone;
		String companyEmail;
		CompanyVO company = null;
		List<CompanyVO> companiesList = new ArrayList<CompanyVO>();
		CompanyDAO companyDao = new CompanyDAOImpl(null, null);

		while (rowIterator.hasNext()) {
			row = (XSSFRow) rowIterator.next();
			Cell firstCell = row.createCell(0);
			Cell secondCell = row.createCell(1);
			Cell thirdCell = row.createCell(2);

			companyName = firstCell.getStringCellValue();
			companyTelephone = secondCell.getStringCellValue();
			companyEmail = thirdCell.getStringCellValue();

			company = new CompanyVO(companyName, companyTelephone, companyEmail);

		}
		companiesList.add(company);
		companyDao.insertList(companiesList);

		fis.close();
		workbook.close();
	}

	public static void importProductTable(String file) throws Exception {
		FileInputStream fis = new FileInputStream(new File(PATH + file));
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet spreadsheet = workbook.getSheetAt(0);
		Iterator<Row> rowIterator = spreadsheet.iterator();

		String productCode;
		String productDescription;
		ProductVO product = null;
		List<ProductVO> productList = new ArrayList<ProductVO>();
		ProductDAO productDao = new ProductDAOImpl(null, null);

		while (rowIterator.hasNext()) {
			row = (XSSFRow) rowIterator.next();
			Cell firstCell = row.createCell(0);
			Cell secondCell = row.createCell(1);

			productCode = firstCell.getStringCellValue();
			productDescription = secondCell.getStringCellValue();

			product = new ProductVO(productCode, productDescription);

		}
		productList.add(product);
		productDao.insertList(productList);

		fis.close();
		workbook.close();
	}

	public static void importCustomerTable(String file) throws Exception {
		FileInputStream fis = new FileInputStream(new File(PATH + file));
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet spreadsheet = workbook.getSheetAt(0);
		Iterator<Row> rowIterator = spreadsheet.iterator();

		String companyId;
		String contactName;
		String contactTelephone;
		CustomerVO customer = null;
		CompanyVO company = null;
		List<CustomerVO> customersList = new ArrayList<CustomerVO>();
		CustomerDAO customerDao = new CustomerDAOImpl(null, null);
		CompanyDAO companyDao = new CompanyDAOImpl(null, null);

		while (rowIterator.hasNext()) {
			row = (XSSFRow) rowIterator.next();
			Cell firstCell = row.createCell(0);
			Cell secondCell = row.createCell(1);
			Cell thirdCell = row.createCell(2);

			companyId = firstCell.getStringCellValue();
			contactName = secondCell.getStringCellValue();
			contactTelephone = thirdCell.getStringCellValue();

			company = companyDao.getCompanyById(Integer.valueOf(companyId));
			customer = new CustomerVO(company, contactName, contactTelephone);

		}
		customersList.add(customer);
		customerDao.insertList(customersList);

		fis.close();
		workbook.close();
	}

	public static void importSupplierTable(String file)
			throws FileNotFoundException {
		FileInputStream fis = new FileInputStream(new File(PATH + file));
		XSSFWorkbook workbook = null;
		try {
			workbook = new XSSFWorkbook(fis);
			XSSFSheet spreadsheet = workbook.getSheetAt(0);
			Iterator<Row> rowIterator = spreadsheet.iterator();

			String companyId;
			String contactName;
			String contactTelephone;
			SupplierVO supplier = null;
			CompanyVO company = null;
			List<SupplierVO> suppliersList = new ArrayList<SupplierVO>();
			SupplierDAO supplierDao = new SupplierDAOImpl(null, null);
			CompanyDAO companyDao = new CompanyDAOImpl(null, null);

			while (rowIterator.hasNext()) {
				row = (XSSFRow) rowIterator.next();
				Cell firstCell = row.createCell(0);
				Cell secondCell = row.createCell(1);
				Cell thirdCell = row.createCell(2);

				companyId = firstCell.getStringCellValue();
				contactName = secondCell.getStringCellValue();
				contactTelephone = thirdCell.getStringCellValue();

				company = companyDao.getCompanyById(Integer.valueOf(companyId));
				supplier = new SupplierVO(company, contactName, contactTelephone);

			}
			suppliersList.add(supplier);
			supplierDao.insertList(suppliersList);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fis.close();
				workbook.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public static void importNoteTable(String file)
			throws FileNotFoundException {
		// FileInputStream fis = new FileInputStream(
		// new File("C:\\Users\\Jose\\Desktop\\NoteTableImport.xlsx"));
		FileInputStream fis = new FileInputStream(new File(PATH + file));
		XSSFWorkbook workbook = null;
		try {
			workbook = new XSSFWorkbook(fis);
			XSSFSheet spreadsheet = workbook.getSheetAt(0);
			Iterator<Row> rowIterator = spreadsheet.iterator();
			rowIterator.next();

			int customerId;
			int supplierId;
			int productId;
			String noteTitle;
			String noteText;
			Date creationDate;

			NoteVO note = null;
			CustomerVO customer = null;
			SupplierVO supplier = null;
			ProductVO product = null;
			List<NoteVO> notesList = new ArrayList<NoteVO>();
			NoteDAO noteDao = new NoteDAOImpl(null, null);
			CustomerDAO customerDao = new CustomerDAOImpl(null, null);
			SupplierDAO supplierDao = new SupplierDAOImpl(null, null);
			ProductDAO productDao = new ProductDAOImpl(null, null);

			while (rowIterator.hasNext()) {
				row = (XSSFRow) rowIterator.next();
				Cell firstCell = row.getCell(0);
				Cell secondCell = row.getCell(1);
				Cell thirdCell = row.getCell(2);
				Cell fourthCell = row.getCell(3);
				Cell fifthCell = row.getCell(4);
				Cell sixthCell = row.getCell(5);

				customerId = Integer.valueOf(firstCell.getStringCellValue());
				supplierId = Integer.valueOf(secondCell.getStringCellValue());
				productId = Integer.valueOf(thirdCell.getStringCellValue());
				noteTitle = fourthCell.getStringCellValue();
				noteText = fifthCell.getStringCellValue();
				creationDate = getDateFromString(sixthCell.getStringCellValue());

				customer = customerDao.getCustomerById(customerId);
				supplier = supplierDao.getSupplierById(supplierId);
				product = productDao.getProductById(productId);

				note = new NoteVO(customer, supplier, product, noteTitle,
						noteText, creationDate);

				notesList.add(note);
			}
			noteDao.insertList(notesList);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				fis.close();
				workbook.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	private static Date getDateFromString(String stringDate)
			throws ParseException {

		// DateTimeFormatter formatter =
		// DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);
		// LocalDate date = LocalDate.parse(stringDate, formatter);
		// System.out.println(date); // 2010-01-02
		// return date;

		DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
		Date date = format.parse(stringDate);
		System.out.println(date); // Sat Jan 02 00:00:00 GMT 2010
		return date;
	}
}
