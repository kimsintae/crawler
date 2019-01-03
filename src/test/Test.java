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
			doc = Jsoup.connect("https://www.ygosu.com/community/movie/?page=1").get();
			eles = doc.select(".bd_list tbody tr:not(.notice)");
			
	  		for(Element el : eles){
	  			System.out.println(el.select(".date").text());
	  		}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  		
  		
	}
	
}
