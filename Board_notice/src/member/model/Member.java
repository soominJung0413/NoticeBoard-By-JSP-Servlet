package member.model;

import java.util.Date;

//Value Object
public class Member {
	private String memberid;
	private String name;
	private String password;
	private Date regdate;
	
	public Member(String memberid, String name, String password, Date regdate) {
		super();
		this.memberid = memberid;
		this.name = name;
		this.password = password;
		this.regdate = regdate;
	}

	public String getMemberid() {
		return memberid;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public Date getRegdate() {
		return regdate;
	}
	
	public boolean matchPassword(String pwd) {
		return password.equals(pwd);
	}

	@Override
	public String toString() {
		return "Member [memberid=" + memberid + ", name=" + name + ", password=" + password + ", regdate=" + regdate
				+ "]";
	}
	
	
}
