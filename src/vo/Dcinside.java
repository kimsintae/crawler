package vo;

import java.util.Date;

public class Dcinside extends Object{
	
	private String title;
	private String href;
	private Date regdate;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	
	public String getUrl(String type){
		String url = "";
		switch (type) {
		case "movie":
			url = "http://gall.dcinside.com/board/lists/?id=movie2&page=1";
			break;
		}
		return url;
	}
	

}
