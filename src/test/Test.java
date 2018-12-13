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
			doc = Jsoup.connect("http://www.todayhumor.co.kr/board/list.php?table=movie&page=1").get();
			eles = doc.select(".table_list tbody .list_tr_movie");// tr 까지만 뽑기
	  		
	  		for(Element el : eles){
	  			System.out.println(el.select(".subject").select("a").text());
	  			System.out.println(el.select(".date").text());
	  		}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  		
  		
	}
	
}
