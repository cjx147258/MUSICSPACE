package space.bean;

public class Singer {
	
	private int id;
	private String name;
	private String img_url;
	private String info;
	
	public Singer(int id, String name, String img_url, String info) {
		super();
		this.id = id;
		this.name = name;
		this.img_url = img_url;
		this.info = info;
	}
	
	

	public Singer() {
		super();
	}



	@Override
	public String toString() {
		return "singer [id=" + id + ", name=" + name + ", img_url=" + img_url + ", info=" + info + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImg_url() {
		return img_url;
	}

	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
	
	
	
	

}
