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
			// ��� Ž��  
	  		eles = doc.select(".bd_list tbody tr:not(.notice)"); // tr 까지만 뽑기
	  		
//	  		System.out.println(eles);
	  		
	  		for(Element el : eles){
	  			System.out.println("https://www.ygosu.com"+el.select(".tit a").attr("href"));
	  			System.out.println(el.select(".tit").text());
//	  			if(el.text().contains(keyword)){
//	  				System.out.println(el.text());
//	  			}
	  		}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  		
  		
	}
	
}
