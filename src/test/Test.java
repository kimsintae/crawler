package test;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Test {

	
	
	public static void main(String[] args) {
		
		
		Document doc = null;
  	    Elements eles = null;
  		// ����Ʈ ����
  		try {
			doc = Jsoup.connect("https://www.dogdrip.net/index.php?mid=movie&page=1").get();
			eles = doc.select("tbody tr:not(.notice) .title");
			
	  		for(Element el : eles){
	  			System.out.println(el.parent().select(".time").text());
	  		}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  		
  		
	}
	
}
