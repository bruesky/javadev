/**
 * 
 */
package business;

import java.io.Serializable;

/**
 * @author 610122
 *
 */
public class Staff implements Serializable {
	
	private static final long serialVersionUID = 1L; 
	private String userId;
	private String password;
	private Auth auth;
	
	public Staff (String userId, String password, Auth auth) {
		this.userId = userId;
		this.password = password;
		this.auth = auth;
	}
	
	public String getUserId() {
		return userId;
	}
	
	public String getPassword() {
		return password;
	}
	
	public Auth getAuth() {
		return auth;
	}
	
//	public void checkoutBooks() {}
//	
//	public void addMember() {}
//	
//	public void editMember() {}
//	
//	public void addBooks() {}
//	
	@Override
	public String toString(){
		return userId+" "+password+" "+ auth;
	}
	
}
