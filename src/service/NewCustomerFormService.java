package service;


public class NewCustomerFormService extends ServiceImpl{

	@Override
	protected void execute() {		
		request.setAttribute("url", "newCustomerForm.jsp");
	}

}
