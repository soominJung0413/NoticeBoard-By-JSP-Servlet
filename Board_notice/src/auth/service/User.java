package auth.service;

//Command Object
public class User {
	private String id;
	private String password;

	public User(String id, String password) {
		super();
		this.id = id;
		this.password = password;
	}

	public String getId() {
		return id;
	}
	
	public String getPassword() {
		return password;
	}
	
}
