package util;

import java.util.ArrayList;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import vo.BobaeDream;
import vo.Dcinside;
import vo.Fmkorea;
import vo.GaeDrip;
import vo.HumorUniv;
import vo.Ppomppu;
import vo.TodayHumor;
import vo.TotalSearchData;
import vo.Ygosu;

public class CrawlingModule {

	
	public static List<TotalSearchData> doCrawling(String url, String keyword, String type, String site){

		List<TotalSearchData> totalDataList = new ArrayList<TotalSearchData>();
		try{
			  // 사이트 연결
			  Document doc = Jsoup.connect(url).get();
	    	  Elements eles = null;
			switch (site) {
			case "bobaedream":
	//	    	List<BobaeDream> bobaeDreamList = new ArrayList<BobaeDream>();
		    		
		    		// 요소 탐색  
		    		eles = doc.select("tbody tr:not(.notice) .title");
		    		for (int i = 0; i < eles.size(); i++) {
		    			if(eles.get(i).select(".title-link").text().contains(keyword)){
	//	    				BobaeDream bobaeDream = new BobaeDream();
	//	    				bobaeDream.setTitle(eles.get(i).select(".title-link").text());
	//	    				bobaeDream.setLink(eles.get(i).select(".link-reset").attr("Link"));
	//	    				
	//	    				bobaeDreamList.add(bobaeDream);
		    				
		    				TotalSearchData tsd = new TotalSearchData();
		    				tsd.setTitle(eles.get(i).select(".title-link").text());
		    				tsd.setLink(eles.get(i).select(".link-reset").attr("href"));
		    				
		    				totalDataList.add(tsd);
		    				// 결과
//		    				System.out.println(eles.get(i).select(".title-link").text() + " \n URL = "+eles.get(i).select(".link-reset").attr("href")) ;
		    			};
		    		}//for
		    	
	
				break;
			case "dcinside":
							// 요소 탐색  
				            eles = doc.select("tbody .gall_num");
				            for(Element el : eles){
				            	if(!el.text().equals("공지")&&!el.text().equals("설문")){
				    				TotalSearchData tsd = new TotalSearchData();
				    				tsd.setTitle(el.parent().select("a").text());
				    				tsd.setLink("http://gall.dcinside.com"+el.parent().select("a").attr("href"));
				    				totalDataList.add(tsd);
				            		// el.parent().select("a") 게시글 제목
				            		// el.parent().select("a").attr("href") 링크
//				    				System.out.println(el.parent().select("a"));
				            	}
				            }
				break;
			case "fmkorea":
			    		// 요소 탐색  
			    		eles = doc.select("tbody tr:not(.notice) .title");
			    		for (int i = 0; i < eles.size(); i++) {
			    			if(eles.get(i).select(".title-link").text().contains(keyword)){
			    				TotalSearchData tsd = new TotalSearchData();
			    				tsd.setTitle(eles.get(i).select(".title-link").text());
			    				tsd.setLink(eles.get(i).select(".link-reset").attr("href"));
			    				
			    				totalDataList.add(tsd);
			    				// 결과
			    				System.out.println(eles.get(i).select(".title-link").text() + " \n URL = "+eles.get(i).select(".link-reset").attr("href")) ;
			    			};
			    		}//for
				break;
			case "gaedrip":
			    		// 요소 탐색  
			    		eles = doc.select("tbody tr:not(.notice) .title");
			    		for (int i = 0; i < eles.size(); i++) {
			    			if(eles.get(i).select(".title-link").text().contains(keyword)){
			    				TotalSearchData tsd = new TotalSearchData();
			    				tsd.setTitle(eles.get(i).select(".title-link").text());
			    				tsd.setLink(eles.get(i).select(".link-reset").attr("href"));
			    				
			    				totalDataList.add(tsd);
			    				// 결과
			    				System.out.println(eles.get(i).select(".title-link").text() + " \n URL = "+eles.get(i).select(".link-reset").attr("href")) ;
			    			};
			    		}//for
				break;
			case "humoruniv":
			    		// 사이트 연결
			    		doc = Jsoup.connect(url).get();
			    		
			    		// 요소 탐색  
			    		eles = doc.select("tbody tr:not(.notice) .title");
			    		for (int i = 0; i < eles.size(); i++) {
			    			if(eles.get(i).select(".title-link").text().contains(keyword)){
			    				TotalSearchData tsd = new TotalSearchData();
			    				tsd.setTitle(eles.get(i).select(".title-link").text());
			    				tsd.setLink(eles.get(i).select(".link-reset").attr("href"));
			    				
			    				totalDataList.add(tsd);
			    				// 결과
			    				System.out.println(eles.get(i).select(".title-link").text() + " \n URL = "+eles.get(i).select(".link-reset").attr("href")) ;
			    			};
			    		}//for
				break;
			case "ppomppu":
			    		
			    		// 요소 탐색  
			    		eles = doc.select("tbody tr:not(.notice) .title");
			    		for (int i = 0; i < eles.size(); i++) {
			    			if(eles.get(i).select(".title-link").text().contains(keyword)){
			    				
			    				TotalSearchData tsd = new TotalSearchData();
			    				tsd.setTitle(eles.get(i).select(".title-link").text());
			    				tsd.setLink(eles.get(i).select(".link-reset").attr("href"));
			    				
			    				totalDataList.add(tsd);
			    				// 결과
			    				System.out.println(eles.get(i).select(".title-link").text() + " \n URL = "+eles.get(i).select(".link-reset").attr("href")) ;
			    			};
			    		}//for
				break;
			case "todayhumor":
			    		
			    		// 요소 탐색  
			    		eles = doc.select("tbody tr:not(.notice) .title");
			    		for (int i = 0; i < eles.size(); i++) {
			    			if(eles.get(i).select(".title-link").text().contains(keyword)){
			    				
			    				TotalSearchData tsd = new TotalSearchData();
			    				tsd.setTitle(eles.get(i).select(".title-link").text());
			    				tsd.setLink(eles.get(i).select(".link-reset").attr("href"));
			    				
			    				totalDataList.add(tsd);
			    				// 결과
			    				System.out.println(eles.get(i).select(".title-link").text() + " \n URL = "+eles.get(i).select(".link-reset").attr("href")) ;
			    			};
			    		}//for
				break;
			case "ygosu":
			    		// 요소 탐색  
			    		eles = doc.select("tbody tr:not(.notice) .title");
			    		for (int i = 0; i < eles.size(); i++) {
			    			if(eles.get(i).select(".title-link").text().contains(keyword)){
			    				
			    				TotalSearchData tsd = new TotalSearchData();
			    				tsd.setTitle(eles.get(i).select(".title-link").text());
			    				tsd.setLink(eles.get(i).select(".link-reset").attr("href"));
			    				
			    				totalDataList.add(tsd);
			    				// 결과
			    				System.out.println(eles.get(i).select(".title-link").text() + " \n URL = "+eles.get(i).select(".link-reset").attr("href")) ;
			    			};
			    		}//for
				break;
			}
		}catch(Exception e){
    		e.printStackTrace();
    	}        
    	
    	return totalDataList;

//    }
	}//doCrawlig
}
