package userInformation;

import java.io.Serializable;

public class UserBean implements Serializable{
	private String _usrName;
	private String _password;

	public String getName () {
		return _usrName;
	}

	public void setName(String userName) {
		_usrName = userName;
	}

	public String getPassword() {
		return _password;
	}

	public void setPassword(String password) {
		_password = password;
	}
}
