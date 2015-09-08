package utils.oldCode;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ServiceImpl;
import model.CompanyVO;
import dao.CompanyDAO;
import dao.CompanyDAOImpl;

public class NewCustomerService extends ServiceImpl{

	@Override
	protected void execute() {		
		getNoCustomerCompanies(request, response);
		request.setAttribute("url", "newCustomer.jsp");
	}
	
	private void getNoCustomerCompanies(HttpServletRequest request,
			HttpServletResponse response) {
		
		try {
			CompanyDAO companyDao = new CompanyDAOImpl(getConnection(), getSession());
			List<CompanyVO> companiesList = companyDao.getNoCustomerCompanies();
			request.setAttribute("companiesList", companiesList);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
