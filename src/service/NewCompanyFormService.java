package service;

public class NewCompanyFormService extends ServiceImpl {

	@Override
	protected void execute() {

		request.setAttribute("url", "newCompany.jsp?");
	}

}
