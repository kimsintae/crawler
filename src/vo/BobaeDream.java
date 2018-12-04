package vo;

import java.util.Date;

public class BobaeDream extends Object {
	
	private String title;
	private String link;
	private Date regdate;
	
	public BobaeDream() {
		super();
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getlink() {
		return link;
	}
	public void setlink(String link) {
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
		case "car":
			url = "http://www.bobaedream.co.kr/list?code=freeb&s_cate=&maker_no=&model_no=&or_gu=30&or_se=desc&s_selday=&pagescale=10&info3=&noticeShow=&s_select=&s_key=&level_no=&vdate=&type=list&page=1";
			break;
		}
		return url;
	}
	
	

}
