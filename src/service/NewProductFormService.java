package service;

public class NewProductFormService extends ServiceImpl implements Service {

	@Override
	protected void execute() {

		request.setAttribute("url", "newProductFrom.jsp?");
	}

}
