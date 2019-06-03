package project4stu.business;

import java.util.List;

import project4stu.business.Book;
import project4stu.dataaccess.DataAccess;
import project4stu.dataaccess.DataAccessFacade;

public interface ControllerInterface {
	public void login(String id, String password) throws LoginException;
	public List<String> allMemberIds();
	public List<String> allBookIds();
	
}
