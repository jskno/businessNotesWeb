package controller;

import service.AddCustomerService;
import service.AddCompanyService;
import service.AddBusinessNoteService;
import service.AddPersonalNoteService;
import service.AddProductService;
import service.AddSupplierService;
import service.ExportTableService;
import service.GetBusinessNotesListService;
import service.GetCompaniesListService;
import service.GetCustomerListService;
import service.GetNotesListService;
import service.GetPersonalNotesListService;
import service.GetProductsListService;
import service.GetSuppliersListService;
import service.ImportTableService;
import service.NewCompanyFormService;
import service.NewCustomerFormService;
import service.NewBusinessNoteFormService;
import service.NewPersonalNoteFormService;
import service.NewProductFormService;
import service.NewSupplierFormService;
import service.Service;

public class BusinessLookUp {
	
	private final String HOME_PAGE = "homePage";
	
	//BusinessNotesController
	private final String NEW_BUSINESS_NOTE_FORM = "newBusinessNoteForm";
	private final String NEW_PERSONAL_NOTE_FORM = "newPersonalNoteForm";
	private final String NEW_CUSTOMER_FORM = "newCustomerForm";
	private final String NEW_SUPPLIER_FORM = "newSupplierForm";
	private final String NEW_COMPANY_FORM = "newCompanyForm";
	private final String NEW_PRODUCT_FORM = "newProductForm";
	
	private final String NOTES_LIST = "notesList";
	private final String BUSINESS_NOTES_LIST = "businessNotesList";
	private final String PERSONAL_NOTES_LIST = "personalNotesList";
	
	private final String CUSTOMERS_LIST = "customersList";
	private final String SUPPLIERS_LIST = "suppliersList";
	private final String COMPANIES_LIST = "companyList";
	private final String PRODUCTS_LIST = "productsList";
	
	//BusinessNotesControllerRedirect
	private final String ADD_CUSTOMER = "addCustomer";
	private final String ADD_SUPPLIER = "addSupplier";
	private final String ADD_PRODUCT = "addProduct";
	private final String ADD_COMPANY = "addCompany";
	private final String ADD_BUSINESS_NOTE = "addBusinessNote";
	private final String ADD_PERSONAL_NOTE = "addPersonalNote";
	
	private final String EXPORT_TABLE = "exportTable";
	private final String IMPORT_TABLE = "importTable";

	private Service serviceClass;
	
	
	public Service getBusinessService(String serviceType) {
		
		switch (serviceType) {
		case HOME_PAGE:
		case NEW_BUSINESS_NOTE_FORM:
			serviceClass = new NewBusinessNoteFormService();
			break;
		case NEW_PERSONAL_NOTE_FORM:
			serviceClass = new NewPersonalNoteFormService();
			break;
		case NEW_CUSTOMER_FORM:
			serviceClass = new NewCustomerFormService();
			break;
		case NEW_SUPPLIER_FORM:
			serviceClass = new NewSupplierFormService();
			break;
		case NEW_COMPANY_FORM:
			serviceClass = new NewCompanyFormService();
			break;
		case NEW_PRODUCT_FORM:
			serviceClass = new NewProductFormService();
			break;
			
		case NOTES_LIST:
			serviceClass = new GetNotesListService();
			break;
		case BUSINESS_NOTES_LIST:
			serviceClass = new GetBusinessNotesListService();
			break;
		case PERSONAL_NOTES_LIST:
			serviceClass = new GetPersonalNotesListService();
			break;
		case CUSTOMERS_LIST:
			serviceClass = new GetCustomerListService();
			break;
		case SUPPLIERS_LIST:
			serviceClass = new GetSuppliersListService();
			break;
		case COMPANIES_LIST:
			serviceClass = new GetCompaniesListService();
			break;
		case PRODUCTS_LIST:
			serviceClass = new GetProductsListService();
			break;
		case ADD_CUSTOMER:
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
		case ADD_BUSINESS_NOTE:
			serviceClass = new AddBusinessNoteService();
			break;
		case ADD_PERSONAL_NOTE:
			serviceClass = new AddPersonalNoteService();
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
