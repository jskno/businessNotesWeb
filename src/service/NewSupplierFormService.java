package service;


public class NewSupplierFormService extends ServiceImpl {

	@Override
	protected void execute() {
		request.setAttribute("url", "newSupplierForm.jsp");
	}
}
