package space.bean;

import java.util.Date;

public class Album {
	public int id;
	public String name;
	public int singer_id;
	public String singer_name;
	public Date issue_time;
	public String cover_url;
	public String info;
	
	public Album() {
		super();
	}
	public Album(int id, String name, int singer_id, String singer_name, Date issue_time, String cover_url,
			String info) {
		super();
		this.id = id;
		this.name = name;
		this.singer_id = singer_id;
		this.singer_name = singer_name;
		this.issue_time = issue_time;
		this.cover_url = cover_url;
		this.info = info;
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
	public int getSinger_id() {
		return singer_id;
	}
	public void setSinger_id(int singer_id) {
		this.singer_id = singer_id;
	}
	public String getSinger_name() {
		return singer_name;
	}
	public void setSinger_name(String singer_name) {
		this.singer_name = singer_name;
	}
	public Date getIssue_time() {
		return issue_time;
	}
	public void setIssue_time(Date issue_time) {
		this.issue_time = issue_time;
	}
	public String getCover_url() {
		return cover_url;
	}
	public void setCover_url(String cover_url) {
		this.cover_url = cover_url;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	@Override
	public String toString() {
		return "Album [id=" + id + ", name=" + name + ", singer_id=" + singer_id + ", singer_name=" + singer_name
				+ ", issue_time=" + issue_time + ", cover_url=" + cover_url + ", info=" + info + "]";
	}
	
}
