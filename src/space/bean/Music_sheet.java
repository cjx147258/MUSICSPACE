package space.bean;

import java.util.Date;

public class Music_sheet {
	
	private int id;
	private int owner_id;
	private String cover_url;
	private String name;
	private String info;
	private Date update_time;
	private int heat;
	public Music_sheet() {
		super();
	}
	public Music_sheet(int id, int owner_id, String cover_url, String name, String info, Date update_time, int heat) {
		super();
		this.id = id;
		this.owner_id = owner_id;
		this.cover_url = cover_url;
		this.name = name;
		this.info = info;
		this.update_time = update_time;
		this.heat = heat;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getOwner_id() {
		return owner_id;
	}
	public void setOwner_id(int owner_id) {
		this.owner_id = owner_id;
	}
	public String getCover_url() {
		return cover_url;
	}
	public void setCover_url(String cover_url) {
		this.cover_url = cover_url;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public Date getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}
	public int getHeat() {
		return heat;
	}
	public void setHeat(int heat) {
		this.heat = heat;
	}
	@Override
	public String toString() {
		return "Music_sheet [id=" + id + ", owner_id=" + owner_id + ", cover_url=" + cover_url + ", name=" + name
				+ ", info=" + info + ", update_time=" + update_time + ", heat=" + heat + "]";
	}
	

}
