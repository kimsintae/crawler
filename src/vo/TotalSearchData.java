package vo;

import javafx.beans.property.StringProperty;

public class TotalSearchData {
	private StringProperty title;
	private StringProperty link;
	private StringProperty regdate;
	private StringProperty siteName;
	
	public StringProperty  getTitle() {
		return title;
	}
	public void setTitle(StringProperty title) {
		this.title = title;
	}
	public StringProperty  getLink() {
		return link;
	}
	public void setLink(StringProperty link) {
		this.link = link;
	}
	public StringProperty getRegdate() {
		return regdate;
	}
	public void setRegdate(StringProperty regdate) {
		this.regdate = regdate;
	}
	public StringProperty getSiteName() {
		return siteName;
	}
	public void setSiteName(StringProperty siteName) {
		this.siteName = siteName;
	}
	
}
