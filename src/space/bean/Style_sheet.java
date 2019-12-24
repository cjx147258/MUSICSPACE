package space.bean;

public class Style_sheet {

	int sheet_id;
	int style_id;
	String style;
	
	public Style_sheet() {
		super();
	}

	public Style_sheet(int sheet_id, int style_id, String style) {
		super();
		this.sheet_id = sheet_id;
		this.style_id = style_id;
		this.style = style;
	}

	public int getSheet_id() {
		return sheet_id;
	}

	public void setSheet_id(int sheet_id) {
		this.sheet_id = sheet_id;
	}

	public int getStyle_id() {
		return style_id;
	}

	public void setStyle_id(int style_id) {
		this.style_id = style_id;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	@Override
	public String toString() {
		return "Style_sheet [sheet_id=" + sheet_id + ", style_id=" + style_id + ", style=" + style + "]";
	}
	
	
}
