package controller;

import service.AddCompanyService;
import service.AddCustomerService;
import service.AddNoteService;
import service.AddProductService;
import service.AddSupplierService;
import service.ExportTableService;
import service.GetCompaniesListService;
import service.GetCustomerListService;
import service.GetNotesListService;
import service.GetSuppliersListService;
import service.ImportTableService;
import service.NewCompanyFormService;
import service.GetCompanyByTaxIDService;
import service.NewCustomer2Service;
import service.NewCustomerService;
import service.NewNoteFormService;
import service.GetProductsListService;
import service.NewProductFormService;
import service.NewSupplierFormService;
import service.Service;

public class BusinessLookUp {
	
	private final String HOME_PAGE = "homePage";
	private final String NEW_NOTE = "newNote";
	private final String NOTE_LIST = "notesList";
	private final String NEW_CUSTOMER = "newCustomer";
	private final String NEW_CUSTOMER_2 = "newCustomer2";
	private final String CUSTOMER_LIST = "customersList";
	private final String NEW_SUPPLIER = "newSupplier";
	private final String SUPPLIERS_LIST = "suppliersList";
	private final String NEW_PRODUCT = "newProduct";
	private final String PRODUCTS_LIST = "productsList";
	private final String NEW_COMPANY = "newCompany";
	private final String CREATE_CUSTOMER = "createCustomer";
	private final String ADD_SUPPLIER = "addSupplier";
	private final String ADD_PRODUCT = "addProduct";
	private final String ADD_COMPANY = "addCompany";
	private final String ADD_NOTE = "addNote";
	private final String EXPORT_TABLE = "exportTable";
	private final String IMPORT_TABLE = "importTable";
	
	
	private Service serviceClass;
	
	
	public Service getBusinessService(String serviceType) {
		
		switch (serviceType) {
		case HOME_PAGE:
		case NEW_NOTE:
			serviceClass = new NewNoteFormService();
			break;
		case NOTE_LIST:
			serviceClass = new GetNotesListService();
			break;
		case NEW_CUSTOMER:
			serviceClass = new NewCustomerService();
			break;
		case NEW_CUSTOMER_2:
			serviceClass = new NewCustomer2Service();
			break;
		case CUSTOMER_LIST:
			serviceClass = new GetCustomerListService();
			break;
		case NEW_SUPPLIER:
			serviceClass = new NewSupplierFormService();
			break;
		case SUPPLIERS_LIST:
			serviceClass = new GetSuppliersListService();
			break;
		case NEW_PRODUCT:
			serviceClass = new NewProductFormService();
			break;
		case PRODUCTS_LIST:
			serviceClass = new GetProductsListService();
			break;
		case NEW_COMPANY:
			serviceClass = new NewCompanyFormService();
			break;
		case CREATE_CUSTOMER:
			serviceClass = new AddCustomerService();
			break;
		case ADD_SUPPLIER:
			serviceClass = new AddSupplierService();
			break;
		case ADD_PRODUCT:
			serviceClass = new AddProductService();
			break;
		case ADD_COMPANY:
			serviceClass = new AddCompanyService();
			break;
		case ADD_NOTE:
			serviceClass = new AddNoteService();
			break;
		case EXPORT_TABLE:
			serviceClass = new ExportTableService();
			break;
		case IMPORT_TABLE:
			serviceClass = new ImportTableService();
			break;
		default:
			break;
		}
		
		return serviceClass;
		
	}

}
