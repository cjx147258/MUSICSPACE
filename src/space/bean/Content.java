package space.bean;

public class Content {

	private int user_id;
	private int target_id;
	private int type;
	private String content;
	private String user_name;
	private String user_url;
	
	public Content() {
		super();
	}

	public Content(int user_id, int target_id, int type, String content, String user_name, String user_url) {
		super();
		this.user_id = user_id;
		this.target_id = target_id;
		this.type = type;
		this.content = content;
		this.user_name = user_name;
		this.user_url = user_url;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getTarget_id() {
		return target_id;
	}

	public void setTarget_id(int target_id) {
		this.target_id = target_id;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_url() {
		return user_url;
	}

	public void setUser_url(String user_url) {
		this.user_url = user_url;
	}

	@Override
	public String toString() {
		return "Content [user_id=" + user_id + ", target_id=" + target_id + ", type=" + type + ", content=" + content
				+ ", user_name=" + user_name + ", user_url=" + user_url + "]";
	}
	
	
	
}
