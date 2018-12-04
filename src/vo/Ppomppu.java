package vo;

import java.util.Date;

public class Ppomppu extends Object{
	
	private String title;
	private String link;
	private Date regdate;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
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
			url = "https://www.dogdrip.net/index.php?mid=movie&page=1";
			break;
		}
		return url;
	}
	
	

}
