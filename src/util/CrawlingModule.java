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
	
	/*
	 * 
	 * 	크롤링 타켓 사이트 요소판별기
	 *  규칙
	 *  1. tr 까지만 뽑기
	 */
	
	public static List<TotalSearchData> doCrawling(String url, String keyword, String site){

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
						// 요소 탐색  
						eles = doc.select("tbody tr:not(.notice) .title");
			            for(Element el : eles){
			            		if(el.text().contains(keyword)){
			            			TotalSearchData tsd = new TotalSearchData();
				    				tsd.setTitle(new SimpleStringProperty(el.text()));
				    				tsd.setLink(new SimpleStringProperty("https://www.fmkorea.com"+el.select("a").attr("href")));
				    				tsd.setSiteName(new SimpleStringProperty("에펨코리아"));
				    				totalDataList.add(tsd);
			            		}
			            }//for
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
				eles = doc.select(".bg_list tbody tr .li_sbj:has(span)");

	    			for(Element el : eles){
	            		if(el.text().contains(keyword)){
	            			TotalSearchData tsd = new TotalSearchData();
		    				tsd.setTitle(new SimpleStringProperty(el.text()));
		    				tsd.setLink(new SimpleStringProperty("http://web.humoruniv.com/board/humor/"+el.select("span>a").attr("href")));
		    				tsd.setSiteName(new SimpleStringProperty("웃긴대학"));
		    				totalDataList.add(tsd);
	            		}
	    		}//for
				
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
					eles = doc.select(".table_list tbody .list_tr_movie .subject");
			  		for(Element el : eles){
			  			if(el.text().contains(keyword)){
			  			    TotalSearchData tsd = new TotalSearchData();
		    				tsd.setTitle(new SimpleStringProperty(el.text()));
		    				tsd.setLink(new SimpleStringProperty("http://www.todayhumor.co.kr"+el.select("a").attr("href")));
		    				tsd.setSiteName(new SimpleStringProperty("오늘의유머"));
		    				totalDataList.add(tsd);
			  			}
			  		}
				break;
			case "ygosu":
				eles = doc.select(".bd_list tbody tr:not(.notice)"); 
				for(Element el : eles){
		  			if(el.text().contains(keyword)){
		  			    TotalSearchData tsd = new TotalSearchData();
	    				tsd.setTitle(new SimpleStringProperty(el.select(".tit").text()));
	    				tsd.setLink(new SimpleStringProperty("https://www.ygosu.com"+el.select(".tit a").attr("href")));
	    				tsd.setSiteName(new SimpleStringProperty("와이고수"));
	    				totalDataList.add(tsd);
		  			}
		  		}
				break;
			case "etorrent":
				eles = doc.select(".bd_list tbody tr:not(.notice)"); 
				for(Element el : eles){
		  			if(el.text().contains(keyword)){
		  			    TotalSearchData tsd = new TotalSearchData();
	    				tsd.setTitle(new SimpleStringProperty(el.select(".tit").text()));
	    				tsd.setLink(new SimpleStringProperty("https://www.ygosu.com"+el.select(".tit a").attr("href")));
	    				tsd.setSiteName(new SimpleStringProperty("와이고수"));
	    				totalDataList.add(tsd);
		  			}
		  		}
				break;
		}
		}catch(Exception e){e.printStackTrace();}        
    	
    	return totalDataList;

//    }
	}//doCrawlig
	
	
	
	public static void dateUtil(){
		
	}
}
