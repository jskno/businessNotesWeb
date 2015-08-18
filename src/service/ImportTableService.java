package service;

import excelUtils.ImportTable;

public class ImportTableService extends ServiceImpl implements Service {

	@Override
	protected void execute() {

		importTable();
		request.setAttribute("url", "importSuccessModal.jsp?");
	}
	
	private void importTable() {

		String table = request.getParameter("tableName");
		String file = request.getParameter("myFile");
		try {
			
			switch (table) {
			case "company":
				ImportTable.importCompanyTable(file);
				break;
			case "customer":
				ImportTable.importCustomerTable(file);
				break;
			case "supplier":
				ImportTable.importSupplierTable(file);		
				break;
			case "product":
				ImportTable.importProductTable(file);
				break;
			case "note":
				ImportTable.importNoteTable(file);
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
