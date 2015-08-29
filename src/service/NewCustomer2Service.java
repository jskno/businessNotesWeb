package service;


public class NewCustomer2Service extends ServiceImpl{

	@Override
	protected void execute() {		
		request.setAttribute("url", "newCustomer2.jsp");
	}

}
