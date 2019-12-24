 package space.bean;

public class User {
	private int id;							// 用户id
	private String introduction; 			// 个人签名
	private String icon_url; 				// 头像地址
	private String name; 					// 用户名
	private String gender; 					// 性别
	private String password; 				// 密码

	public User() {
		super();
	}

	public User(int id, String introduction, String icon_url, String name, String gender, String password) {
		super();
		this.id = id;
		this.introduction = introduction;
		this.icon_url = icon_url;
		this.name = name;
		this.gender = gender;
		this.password = password;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getIcon_url() {
		return icon_url;
	}

	public void setIcon_url(String iocn_url) {
		this.icon_url = iocn_url;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", introduction=" + introduction + ", icon_url=" + icon_url + ", name=" + name
				+ ", gender=" + gender + ", password=" + password + "]";
	}
}
