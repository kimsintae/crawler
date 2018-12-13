package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.TextInputDialog;
import vo.ResultVO;
import vo.TotalSearchData;

public class CrawlingModule {
	
	
	
	
	/*
	 * 
	 * 	�겕濡ㅻ쭅 ��耳� �궗�씠�듃 �슂�냼�뙋蹂꾧린
	 *  洹쒖튃
	 *  1. tr 源뚯�留� 戮묎린
	 */
	
	public static ResultVO doCrawling(String url, String keyword, String site, LocalDate endDateParam, int PageCnt){
		ResultVO resultVO = new ResultVO(); 
		LocalDate endDate = endDateParam;// 종료날짜
		
		boolean flag = false;
		
		
		List<TotalSearchData> totalDataList = new ArrayList<TotalSearchData>();
		
		try{
			  // �궗�씠�듃 �뿰寃�
			  Document doc = Jsoup.connect(url+PageCnt).get();
	    	  Elements eles = null;
			switch (site) {
			case "bobaedream":
	
				break;
			case "dcinside":
						// �슂�냼 �깘�깋  
			            eles = doc.select("tbody .gall_num");
			            for(Element el : eles){
			            	
			            	// 우선적으로 크롤링 종료 날짜와 비교한다.
			            	// 비교후 크롤링종료날짜 보다 이전이면 반복을 중단.
			            	
			            	// 날짜 형태 변환
//			                compareDate(endDateParam, ChangeDateForm(el.parent().select(".gall_date").attr("title"))); 
			            	
			            	if(!el.text().equals("怨듭�") && !el.text().equals("�꽕臾�") && el.parent().select("a").text().contains(keyword)){
			            		// 크롤링 종료 시점 판단 
			            		flag = compareDate(endDate, changeDateForm(el.parent().select(".gall_date").attr("title"))) > 0 ? true:false;
			            		
			            		if(flag){
			            			resultVO.setMatchedDate(flag);
			            			//true 검색 중지
			            			break;
			            		}else{
			            			//false면 계쏙검색
			            			TotalSearchData tsd = new TotalSearchData();
				    				tsd.setTitle(new SimpleStringProperty(el.parent().select("a").text()));
				    				tsd.setLink(new SimpleStringProperty("http://gall.dcinside.com"+el.parent().select("a").attr("href")));
				    				tsd.setSiteName(new SimpleStringProperty("�뵒�떆�씤�궗�씠�뱶"));
				    				tsd.setRegdate(new SimpleStringProperty(el.parent().select(".gall_date").attr("title")));
				    				totalDataList.add(tsd);
				    				resultVO.setList(totalDataList);
			            		}
			            	}
			            }//for
				break;
			case "fmkorea":
						// �슂�냼 �깘�깋  
						eles = doc.select("tbody tr:not(.notice) .title");
			            for(Element el : eles){
			            		if(el.text().contains(keyword)){

			            			String date = el.parent().select(".time").text();
				            		
			            			// 크롤링 종료 시점 판단 
				            		flag = compareDate(endDate, changeDateForm(date)) > 0 ? true:false;
				            		
				            		if(flag){
				            			resultVO.setMatchedDate(flag);
				            			//true 검색 중지
				            			break;
				            		}else{
				            			TotalSearchData tsd = new TotalSearchData();
				            			tsd.setTitle(new SimpleStringProperty(el.text()));
				            			tsd.setLink(new SimpleStringProperty("https://www.fmkorea.com"+el.select("a").attr("href")));
				            			tsd.setSiteName(new SimpleStringProperty("�뿉�렓肄붾━�븘"));
				            			tsd.setRegdate(new SimpleStringProperty(date));
				            			totalDataList.add(tsd);
				            			resultVO.setList(totalDataList);
			            			
				            		}
			            			
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
			    				resultVO.setList(totalDataList);
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
		    				resultVO.setList(totalDataList);
	            		}
	    		}//for
				
				break;
			case "ppomppu":
						// �슂�냼 �깘�깋  
			    		eles = doc.select("tbody tr:not(.list_notice) .list_title");
				  		for(Element el : eles){
				  			if(el.text().contains(keyword)){
				  				
				  				String date = el.parent().parent().nextSibling().attr("title");
				  				
			            		// 크롤링 종료 시점 판단 
			            		flag = compareDate(endDate, changeDateForm(date)) > 0 ? true:false;
			            		
			            		if(flag){
			            			resultVO.setMatchedDate(flag);
			            			//true 검색 중지
			            			break;
			            		}else{
			            			TotalSearchData tsd = new TotalSearchData();
			            			tsd.setTitle(new SimpleStringProperty(el.text()));
			            			tsd.setLink(new SimpleStringProperty("https://www.ppomppu.co.kr/zboard/"+el.parent().select("a").attr("href")));
			            			tsd.setSiteName(new SimpleStringProperty("戮먮퓣"));
			            			tsd.setRegdate(new SimpleStringProperty(date));
			            			totalDataList.add(tsd);
			            			resultVO.setList(totalDataList);
			            		}
				  			}
				  		}
				break;
			case "todayhumor":
					eles = doc.select(".table_list tbody .list_tr_movie");
			  		for(Element el : eles){
			  			if(el.text().contains(keyword)){
			  				String date = el.select(".date").text();
			  				
			  			// 크롤링 종료 시점 판단 
		            		flag = compareDate(endDate, changeDateForm(date)) > 0 ? true:false;
		            		
		            		if(flag){
		            			resultVO.setMatchedDate(flag);
		            			//true 검색 중지
		            			break;
		            		}else{
		            			
		            			TotalSearchData tsd = new TotalSearchData();
		            			tsd.setTitle(new SimpleStringProperty(el.select(".subject").select("a").text()));
		            			tsd.setLink(new SimpleStringProperty("http://www.todayhumor.co.kr"+el.select(".subject").select("a").attr("href")));
		            			tsd.setSiteName(new SimpleStringProperty("�삤�뒛�쓽�쑀癒�"));
		            			tsd.setRegdate(new SimpleStringProperty(date));
		            			totalDataList.add(tsd);
		            			resultVO.setList(totalDataList);
		            			
		            		}
			  				
			  				
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
	    				resultVO.setList(totalDataList);
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
	    				resultVO.setList(totalDataList);
		  			}
		  		}
				break;
		}
		}catch(Exception e){e.printStackTrace();}        
    	
    	return resultVO;

//    }
	}//doCrawlig
	
	
	
	public static LocalDate changeDateForm(String regdate){
		
		
		System.out.println("게시글 날짜  : "+regdate);
		
		
		LocalDate ld = null;
		StringBuilder sb = new StringBuilder();
		String pattern = "^[0-9]{0,4}(\\-|\\/|\\.){0,1}[0-9]{1,2}(\\-|\\/|\\.)[0-9]{1,2}";
		Pattern dp = Pattern.compile(pattern);
		Matcher dm = dp.matcher(regdate.toString());
		if(regdate.length() < 10 && regdate.matches(".*[��-����-�Ӱ�-�R]+.*")){
			System.out.println("type = 1일전 ");
			
		}else if(regdate.length() < 10 && regdate.matches(".*:.*")){
			System.out.println("type = 00:00:00");
			sb.append(LocalDate.now().format(DateTimeFormatter.ofPattern("yyy-MM-dd"))); 
			ld = LocalDate.parse(sb.toString());
		}else{
			// ��¥�� �Լ� ����
		
			while(dm.find()){sb.append(dm.group(0).replaceAll("(\\.|\\/|\\-)", "-"));}
				if(sb.toString().indexOf('-')+1 == 3 && sb.length() >= 8){
					sb.insert(0, "20");
				}else if(sb.length() < 6){
					// mm-dd Ÿ�� 
					sb.insert(0, "2018-");
				}
				ld = LocalDate.parse(sb.toString());
//				System.out.println(ld);
		}
		sb.setLength(0);
		
		return ld;
	}
	
	// 날짜 비교
	public static int compareDate(LocalDate endDate, LocalDate regdate){
		
		
		
		
		//0 보다 크면 크롤링 종료일보다 이전 날짜가 됨.
		return endDate.compareTo(regdate);
		
	}
}
