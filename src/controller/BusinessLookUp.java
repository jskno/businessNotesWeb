package controller;

import service.GetNoteListService;
import service.NewNoteFormService;
import service.Service;

public class BusinessLookUp {
	
	private final String NEW_NOTE = "newNote";
	private final String NOTE_LIST = "notesList";
	private Service serviceClass;
	
	
	public Service getBusinessService(String serviceType) {
		
		switch (serviceType) {
		case NEW_NOTE:
			serviceClass = new NewNoteFormService();
			break;
		case NOTE_LIST:
			serviceClass = new GetNoteListService();
			break;

		default:
			break;
		}
		
		return serviceClass;
		
	}

}
