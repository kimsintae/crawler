package util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javafx.beans.property.SimpleStringProperty;
import vo.TotalSearchData;

public class CrawlingModule {
	
	/*
	 * 
	 * 	�겕濡ㅻ쭅 ��耳� �궗�씠�듃 �슂�냼�뙋蹂꾧린
	 *  洹쒖튃
	 *  1. tr 源뚯�留� 戮묎린
	 */
	
	public static List<TotalSearchData> doCrawling(String url, String keyword, String site){

		List<TotalSearchData> totalDataList = new ArrayList<TotalSearchData>();
		try{
			  // �궗�씠�듃 �뿰寃�
			  Document doc = Jsoup.connect(url).get();
	    	  Elements eles = null;
			switch (site) {
			case "bobaedream":
	
				break;
			case "dcinside":
						// �슂�냼 �깘�깋  
			            eles = doc.select("tbody .gall_num");
			            for(Element el : eles){
			            	if(!el.text().equals("怨듭�") && !el.text().equals("�꽕臾�")){
			            		if(el.parent().select("a").text().contains(keyword)){
			            			TotalSearchData tsd = new TotalSearchData();
				    				tsd.setTitle(new SimpleStringProperty(el.parent().select("a").text()));
				    				tsd.setLink(new SimpleStringProperty("http://gall.dcinside.com"+el.parent().select("a").attr("href")));
				    				tsd.setSiteName(new SimpleStringProperty("�뵒�떆�씤�궗�씠�뱶"));
				    				totalDataList.add(tsd);
			            		}
			            	}
			            }//for
				break;
			case "fmkorea":
						// �슂�냼 �깘�깋  
						eles = doc.select("tbody tr:not(.notice) .title");
			            for(Element el : eles){
			            		if(el.text().contains(keyword)){
			            			TotalSearchData tsd = new TotalSearchData();
				    				tsd.setTitle(new SimpleStringProperty(el.text()));
				    				tsd.setLink(new SimpleStringProperty("https://www.fmkorea.com"+el.select("a").attr("href")));
				    				tsd.setSiteName(new SimpleStringProperty("�뿉�렓肄붾━�븘"));
				    				totalDataList.add(tsd);
			            		}
			            }//for
				break;
			case "gaedrip":
			    		// �슂�냼 �깘�깋  
			    		eles = doc.select("tbody tr:not(.notice) .title");
			    		for (int i = 0; i < eles.size(); i++) {
			    			if(eles.get(i).select(".title-link").text().contains(keyword)){
			    				TotalSearchData tsd = new TotalSearchData();
			    				tsd.setTitle(new SimpleStringProperty(eles.get(i).select(".title-link").text()));
			    				tsd.setLink(new SimpleStringProperty(eles.get(i).select(".link-reset").attr("href")));
			    				tsd.setSiteName(new SimpleStringProperty("媛쒕뱶由�"));
			    				totalDataList.add(tsd);
			    				// 寃곌낵
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
		    				tsd.setSiteName(new SimpleStringProperty("�썐湲대��븰"));
		    				totalDataList.add(tsd);
	            		}
	    		}//for
				
				break;
			case "ppomppu":
						// �슂�냼 �깘�깋  
			    		eles = doc.select("tbody tr:not(.list_notice) .list_title");
				  		for(Element el : eles){
				  			if(el.text().contains(keyword)){
				  			    TotalSearchData tsd = new TotalSearchData();
			    				tsd.setTitle(new SimpleStringProperty(el.text()));
			    				tsd.setLink(new SimpleStringProperty("https://www.ppomppu.co.kr/zboard/"+el.parent().select("a").attr("href")));
			    				tsd.setSiteName(new SimpleStringProperty("戮먮퓣"));
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
		    				tsd.setSiteName(new SimpleStringProperty("�삤�뒛�쓽�쑀癒�"));
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
	    				tsd.setSiteName(new SimpleStringProperty("���씠怨좎닔"));
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
	    				tsd.setSiteName(new SimpleStringProperty("���씠怨좎닔"));
	    				totalDataList.add(tsd);
		  			}
		  		}
				break;
		}
		}catch(Exception e){e.printStackTrace();}        
    	
    	return totalDataList;

//    }
	}//doCrawlig
	
	
	
	public static void dateUtil(String date){
		
		StringBuilder sb = new StringBuilder();
		String pattern = "^[0-9]{0,4}(\\-|\\/|\\.){0,1}[0-9]{1,2}(\\-|\\/|\\.)[0-9]{1,2}";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		Pattern dp = Pattern.compile(pattern);
		Matcher dm = dp.matcher(date);
			while(dm.find()){
				sb.append(dm.group(0).replaceAll("(\\.|\\/|\\-)", "."));
				if(sb.toString().indexOf('-')+1 == 3 && sb.length() >= 8){
					sb.insert(0, "20");
				}else if(sb.length() < 6){
					// mm-dd 타입 
					sb.insert(0, "2018-");
				}
				
			}
		sb.setLength(0);
	}
}
