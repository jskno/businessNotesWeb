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

import model.BusinessNoteVO;
import model.CompanyRoleVO;
import model.CompanyVO;
import model.CustomerVO;
import model.NoteVO;
import model.ProductVO;
import model.SupplierVO;
import model.UserVO;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import utils.DBUtil;
import dao.BusinessNoteDAO;
import dao.BusinessNoteDAOImpl;
import dao.CompanyDAO;
import dao.CompanyDAOImpl;
import dao.CompanyRoleDao;
import dao.CompanyRoleDaoImpl;
import dao.CustomerDAO;
import dao.CustomerDAOImpl;
import dao.NoteDAO;
import dao.NoteDAOImpl;
import dao.ProductDAO;
import dao.ProductDAOImpl;
import dao.SupplierDAO;
import dao.SupplierDAOImpl;
import dao.UserDAO;
import dao.UserDAOImpl;

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

		String taxID;
		String companyName;
		String companyTelephone;
		String companyEmail;
		CompanyVO company = null;
		List<CompanyVO> companiesList = new ArrayList<CompanyVO>();
		CompanyDAO companyDao = new CompanyDAOImpl(DBUtil.getConnection(), null);

		while (rowIterator.hasNext()) {
			row = (XSSFRow) rowIterator.next();
			Cell firstCell = row.createCell(0);
			Cell secondCell = row.createCell(1);
			Cell thirdCell = row.createCell(2);
			Cell fourthCell = row.createCell(3);

			taxID = firstCell.getStringCellValue();
			companyName = secondCell.getStringCellValue();
			companyTelephone = thirdCell.getStringCellValue();
			companyEmail = fourthCell.getStringCellValue();

			company = new CompanyVO(taxID, companyName, companyTelephone, companyEmail);

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
		Integer stock;
		ProductVO product = null;
		List<ProductVO> productList = new ArrayList<ProductVO>();
		ProductDAO productDao = new ProductDAOImpl(DBUtil.getConnection(), null);

		while (rowIterator.hasNext()) {
			row = (XSSFRow) rowIterator.next();
			Cell firstCell = row.createCell(0);
			Cell secondCell = row.createCell(1);
			Cell thirdCell = row.createCell(2);

			productCode = firstCell.getStringCellValue();
			productDescription = secondCell.getStringCellValue();
			stock = (int) thirdCell.getNumericCellValue();

			product = new ProductVO(productCode, productDescription, stock);

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

		Integer companyId;
		String roleName;
		String contactName;
		String contactTelephone;
		Integer creditRating;
		Double customerDiscount;
		CustomerVO customer = null;
		CompanyVO company = null;
		List<CustomerVO> customersList = new ArrayList<CustomerVO>();
		CustomerDAO customerDao = new CustomerDAOImpl(DBUtil.getConnection(), null);
		CompanyDAO companyDao = new CompanyDAOImpl(DBUtil.getConnection(), null);

		while (rowIterator.hasNext()) {
			row = (XSSFRow) rowIterator.next();
			Cell firstCell = row.createCell(0);
			Cell secondCell = row.createCell(1);
			Cell thirdCell = row.createCell(2);
			Cell fourthCell = row.createCell(3);
			Cell fifthCell = row.createCell(4);
			Cell sixthCell = row.createCell(5);
			
			companyId = (int) firstCell.getNumericCellValue();
			roleName = secondCell.getStringCellValue();
			contactName = thirdCell.getStringCellValue();
			contactTelephone = fourthCell.getStringCellValue();
			creditRating = (int) fifthCell.getNumericCellValue();
			customerDiscount = sixthCell.getNumericCellValue();

			company = companyDao.getCompanyById(companyId);
			customer = new CustomerVO(company, roleName, contactName, contactTelephone,
					creditRating, customerDiscount);

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
			
			Integer companyId;
			String roleName;
			String contactName;
			String contactTelephone;
			Integer deliveryDays;
			SupplierVO supplier = null;
			CompanyVO company = null;
			List<SupplierVO> suppliersList = new ArrayList<SupplierVO>();
			SupplierDAO supplierDao = new SupplierDAOImpl(DBUtil.getConnection(), null);
			CompanyDAO companyDao = new CompanyDAOImpl(DBUtil.getConnection(), null);

			while (rowIterator.hasNext()) {
				row = (XSSFRow) rowIterator.next();
				Cell firstCell = row.createCell(0);
				Cell secondCell = row.createCell(1);
				Cell thirdCell = row.createCell(2);
				Cell fourthCell = row.createCell(3);
				Cell fifthCell = row.createCell(4);

				companyId = (int) firstCell.getNumericCellValue();
				roleName = secondCell.getStringCellValue();
				contactName = thirdCell.getStringCellValue();
				contactTelephone = fourthCell.getStringCellValue();
				deliveryDays = (int) fifthCell.getNumericCellValue();

				company = companyDao.getCompanyById(companyId);
				supplier = new SupplierVO(company, roleName,contactName, 
						contactTelephone, deliveryDays);

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

			Integer customerId;
			Integer supplierId;
			Integer productId;
			String noteTitle;
			String noteText;
			Date creationDate;
			Integer userId;

			BusinessNoteVO note = null;
			CustomerVO customer = null;
			SupplierVO supplier = null;
			ProductVO product = null;
			UserVO user = null;
			List<BusinessNoteVO> notesList = new ArrayList<BusinessNoteVO>();
			BusinessNoteDAO noteDao = new BusinessNoteDAOImpl(DBUtil.getConnection(), null);
			CustomerDAO customerDao = new CustomerDAOImpl(DBUtil.getConnection(), null);
			SupplierDAO supplierDao = new SupplierDAOImpl(DBUtil.getConnection(), null);
			ProductDAO productDao = new ProductDAOImpl(DBUtil.getConnection(), null);
			UserDAO userDao = new UserDAOImpl(DBUtil.getConnection(), null);

			while (rowIterator.hasNext()) {
				row = (XSSFRow) rowIterator.next();
				Cell firstCell = row.getCell(0);
				Cell secondCell = row.getCell(1);
				Cell thirdCell = row.getCell(2);
				Cell fourthCell = row.getCell(3);
				Cell fifthCell = row.getCell(4);
				Cell sixthCell = row.getCell(5);
				Cell seventhCell = row.getCell(6);

				customerId = Integer.valueOf(firstCell.getStringCellValue());
				supplierId = Integer.valueOf(secondCell.getStringCellValue());
				productId = Integer.valueOf(thirdCell.getStringCellValue());
				noteTitle = fourthCell.getStringCellValue();
				noteText = fifthCell.getStringCellValue();
				creationDate = getDateFromString(sixthCell.getStringCellValue());
				userId = Integer.valueOf(seventhCell.getStringCellValue());

				customer = customerDao.getCustomerById(customerId);
				supplier = supplierDao.getSupplierById(supplierId);
				product = productDao.getProductById(productId);
				user = userDao.getUserById(userId);

				note = new BusinessNoteVO(customer, supplier, product, noteTitle,
						noteText, creationDate, user);

				notesList.add(note);
			}
			noteDao.insertList(notesList);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
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
