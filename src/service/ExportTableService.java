package service;

import excelUtils.ExportTable;

public class ExportTableService extends ServiceImpl implements Service {

	@Override
	protected void execute() {

		exportTable();
		request.setAttribute("url", "exportSuccessModal.jsp?");
	}
	
	private void exportTable() {
		
		String table = request.getParameter("tableName");
		String fileName = request.getParameter("fileName");
		
		try {
			
			switch (table) {
			case "company":
				ExportTable.exportCompanyTable(fileName);
				break;
			case "customer":
				ExportTable.exportCustomerTable(fileName);
				break;
			case "supplier":
				ExportTable.exportSupplierTable(fileName);		
				break;
			case "product":
				ExportTable.exportProductTable(fileName);
				break;
			case "note":
				ExportTable.exportNoteTable(fileName);
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
