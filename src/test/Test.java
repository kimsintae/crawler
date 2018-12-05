package test;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Test {

	
	
	public static void main(String[] args) {
		
		String keyword = "����";
		Document doc = null;
  	    Elements eles = null;
  		// ����Ʈ ����
  		try {
			doc = Jsoup.connect("https://www.ppomppu.co.kr/zboard/zboard.php?id=movie&page=1").get();
			// ��� Ž��  
	  		eles = doc.select("tbody tr:not(.list_notice) .list_title");
	  		
	  		
	  		for(Element el : eles){
	  			if(el.text().contains(keyword)){
	  				System.out.println(el.text());
//	  			System.out.println("https://www.ppomppu.co.kr/zboard/"+el.parent().select("a").attr("href"));
	  			}
	  		}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  		
  		
	}
	
}
