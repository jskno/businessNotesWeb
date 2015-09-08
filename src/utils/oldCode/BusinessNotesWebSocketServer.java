package utils.oldCode;

import javax.websocket.OnMessage;
import javax.websocket.server.ServerEndpoint;

import utils.oldCode.serviceWS.ServiceWS;

@ServerEndpoint("/notes/ws")
public class BusinessNotesWebSocketServer {
	
	private ServiceWS serviceWS;
	private BusinessLookUpWS lookupServiceWS = new BusinessLookUpWS();
	
	@OnMessage
	public void onMessage(String taxID) {
		
		String action = "checkTaxID";
//		String action = request.getParameter("action");
//		String keyWord = request.getParameter("keyWord");
//		RequestDispatcher requestDispatcher;
//		if (action == null) {
//			action = "homePage";
//		}
		serviceWS = lookupServiceWS.getBusinessService(action);
//		service.execute(request, response);
		serviceWS.execute(taxID);
		
		
//		url = BASE + request.getAttribute("url");
//		requestDispatcher = getServletContext().
//				getRequestDispatcher(url);
//		requestDispatcher.forward(request, response);
		
	}
	
	

}
