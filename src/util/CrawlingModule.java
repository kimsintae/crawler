package util;

import java.util.ArrayList;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javafx.beans.property.SimpleStringProperty;
import vo.TotalSearchData;

public class CrawlingModule {

	
	public static List<TotalSearchData> doCrawling(String url, String keyword, String type, String site){

		List<TotalSearchData> totalDataList = new ArrayList<TotalSearchData>();
		try{
			  // 사이트 연결
			  Document doc = Jsoup.connect(url).get();
	    	  Elements eles = null;
			switch (site) {
			case "bobaedream":
	
				break;
			case "dcinside":
							// 요소 탐색  
				            eles = doc.select("tbody .gall_num");
				            for(Element el : eles){
				            	if(!el.text().equals("공지") && !el.text().equals("설문")){
				            		if(el.parent().select("a").text().contains(keyword)){
				            			TotalSearchData tsd = new TotalSearchData();
					    				tsd.setTitle(new SimpleStringProperty(el.parent().select("a").text()));
					    				tsd.setLink(new SimpleStringProperty("http://gall.dcinside.com"+el.parent().select("a").attr("href")));
					    				tsd.setSiteName(new SimpleStringProperty("디시인사이드"));
					    				totalDataList.add(tsd);
				            		}
				            	}
				            }//for
				break;
			case "fmkorea":

				break;
			case "gaedrip":
			    		// 요소 탐색  
			    		eles = doc.select("tbody tr:not(.notice) .title");
			    		for (int i = 0; i < eles.size(); i++) {
			    			if(eles.get(i).select(".title-link").text().contains(keyword)){
			    				TotalSearchData tsd = new TotalSearchData();
			    				tsd.setTitle(new SimpleStringProperty(eles.get(i).select(".title-link").text()));
			    				tsd.setLink(new SimpleStringProperty(eles.get(i).select(".link-reset").attr("href")));
			    				tsd.setSiteName(new SimpleStringProperty("개드립"));
			    				totalDataList.add(tsd);
			    				// 결과
//			    				System.out.println(eles.get(i).select(".title-link").text() + " \n URL = "+eles.get(i).select(".link-reset").attr("href")) ;
			    			};
			    		}//for
				break;
			case "humoruniv":
				
				
				break;
			case "ppomppu":
						// 요소 탐색  
			    		eles = doc.select("tbody tr:not(.list_notice) .list_title");
				  		for(Element el : eles){
				  			if(el.text().contains(keyword)){
				  			    TotalSearchData tsd = new TotalSearchData();
			    				tsd.setTitle(new SimpleStringProperty(el.text()));
			    				tsd.setLink(new SimpleStringProperty("https://www.ppomppu.co.kr/zboard/"+el.parent().select("a").attr("href")));
			    				tsd.setSiteName(new SimpleStringProperty("뽐뿌"));
			    				totalDataList.add(tsd);
				  			}
				  		}

				break;
			case "todayhumor":

				break;
			case "ygosu":

				break;
			}
		}catch(Exception e){e.printStackTrace();}        
    	
    	return totalDataList;

//    }
	}//doCrawlig
}
