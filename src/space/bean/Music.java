package space.bean;
import java.util.Date;

public class Music {
	private int heat;
	private int id;
	private String name;
	private String music_url;
	private String cover_url;
	private int singer_id;
	private String singer_name;
	private int album_id;
	private String album_name;
	private String time;
	private Date update_time;
	public Music() {
		super();
	}
	
	public Music(int heat, int id, String name, String music_url, int singer_id, int album_id, String album_name,
			String time, Date update_time, String singer_name, String cover_url) {
		super();
		this.heat = heat;
		this.id = id;
		this.name = name;
		this.music_url = music_url;
		this.cover_url = cover_url;
		this.singer_id = singer_id;
		this.singer_name = singer_name;
		this.album_id = album_id;
		this.album_name = album_name;
		this.time = time;
		this.update_time = update_time;
	}

	public Music(int heat, int id, String name, String music_url, int singer_id, int album_id, String album_name,
			String time, Date update_time, String singer_name) {
		super();
		this.heat = heat;
		this.id = id;
		this.name = name;
		this.music_url = music_url;
		this.singer_id = singer_id;
		this.album_id = album_id;
		this.album_name = album_name;
		this.time = time;
		this.update_time = update_time;
		this.singer_name = singer_name;
	}
	
	public String getCover_url() {
		return cover_url;
	}
	public void setCover_url(String cover_url) {
		this.cover_url = cover_url;
	}
	public int getAlbum_id() {
		return album_id;
	}
	public void setAlbum_id(int album_id) {
		this.album_id = album_id;
	}
	public String getSinger_name() {
		return singer_name;
	}
	public void setSinger_name(String singer_name) {
		this.singer_name = singer_name;
	}
	public int getHeat() {
		return heat;
	}
	public void setHeat(int heat) {
		this.heat = heat;
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
	public String getMusic_url() {
		return music_url;
	}
	public void setMusic_url(String music_url) {
		this.music_url = music_url;
	}
	public int getSinger_id() {
		return singer_id;
	}
	public void setSinger_id(int singer_id) {
		this.singer_id = singer_id;
	}
	public int getalbum_id() {
		return album_id;
	}
	public void setalbum_id(int album_id) {
		this.album_id = album_id;
	}
	public String getAlbum_name() {
		return album_name;
	}
	public void setAlbum_name(String album_name) {
		this.album_name = album_name;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public Date getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}
	@Override
	public String toString() {
		return "Music [heat=" + heat + ", id=" + id + ", name=" + name + ", music_url=" + music_url + ", singer_id="
				+ singer_id + ", album_id=" + album_id + ", album_name=" + album_name + ", time=" + time
				+ ", update_time=" + update_time + "]";
	}
	
	
}
