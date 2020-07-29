package auth.service;

//Command Object
public class User {
	private String id;
	private String password;
	private String name;

	public User(String id, String password) {
		super();
		this.id = id;
		this.password = password;
	}
	

	public User(String id, String password, String name) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
	}


	public String getId() {
		return id;
	}
	
	public String getPassword() {
		return password;
	}
	public String getName() {
		return name;
	}
	
}
