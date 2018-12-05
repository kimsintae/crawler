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
			  Document doc = Jsoup.connect(url).get();;
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
		    				System.out.println(eles.get(i).select(".title-link").text() + " \n URL = "+eles.get(i).select(".link-reset").attr("href")) ;
		    			};
		    		}//for
		    	
	
				break;
			case "dcinside":
//		    	List<BobaeDream> bobaeDreamList = new ArrayList<BobaeDream>();
			    		
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
				            		System.out.println();
				            	}
				            }
				break;
			case "fmkorea":
//		    	List<BobaeDream> bobaeDreamList = new ArrayList<BobaeDream>();
			    		
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
			    				System.out.println(eles.get(i).select(".title-link").text() + " \n URL = "+eles.get(i).select(".link-reset").attr("href")) ;
			    			};
			    		}//for
				break;
			case "gaedrip":
//		    	List<BobaeDream> bobaeDreamList = new ArrayList<BobaeDream>();
			    		
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
			    				System.out.println(eles.get(i).select(".title-link").text() + " \n URL = "+eles.get(i).select(".link-reset").attr("href")) ;
			    			};
			    		}//for
				break;
			case "humoruniv":
//		    	List<BobaeDream> bobaeDreamList = new ArrayList<BobaeDream>();
			    		// 사이트 연결
			    		doc = Jsoup.connect(url).get();
			    		
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
			    				System.out.println(eles.get(i).select(".title-link").text() + " \n URL = "+eles.get(i).select(".link-reset").attr("href")) ;
			    			};
			    		}//for
				break;
			case "ppomppu":
//		    	List<BobaeDream> bobaeDreamList = new ArrayList<BobaeDream>();
			    		
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
			    				System.out.println(eles.get(i).select(".title-link").text() + " \n URL = "+eles.get(i).select(".link-reset").attr("href")) ;
			    			};
			    		}//for
				break;
			case "todayhumor":
//		    	List<BobaeDream> bobaeDreamList = new ArrayList<BobaeDream>();
			    		
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
			    				System.out.println(eles.get(i).select(".title-link").text() + " \n URL = "+eles.get(i).select(".link-reset").attr("href")) ;
			    			};
			    		}//for
				break;
			case "ygosu":
//		    	List<BobaeDream> bobaeDreamList = new ArrayList<BobaeDream>();
			    		
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
	}
	
    
    public static List<TotalSearchData> getDcinside( String keyword,String url){
//		List<Dcinside> dcList = new ArrayList<Dcinside>();
		List<TotalSearchData> totalDataList = new ArrayList<TotalSearchData>();
        try{
            Document doc = null;
            Elements eles = null;
            doc = Jsoup.connect(url).get();
            eles = doc.select("tbody tr:not(.notice) .title");
            for (int i = 0; i < eles.size(); i++) {
            	if(eles.get(i).select(".title-link").text().contains(keyword)){
//            		Dcinside dcinside = new Dcinside();
//            		dcinside.setTitle(eles.get(i).select(".title-link").text());
//            		dcinside.setLink(eles.get(i).select(".link-reset").attr("Link"));
            		TotalSearchData tsd = new TotalSearchData();
            		totalDataList.add(tsd);
            		System.out.println(eles.get(i).select(".title-link").text() + " \n URL = "+eles.get(i).select(".link-reset").attr("Link")) ;
            	};
            }//for
        }catch(Exception e){
            e.printStackTrace();
        }        
        
        return totalDataList;
	}
    
    public static List<TotalSearchData> getFmkorea(String keyword,String url){
//		List<Fmkorea> fmKoreaList = new ArrayList<Fmkorea>();
		List<TotalSearchData> totalDataList = new ArrayList<TotalSearchData>();
        try{
            Document doc = null;
            Elements eles = null;
            doc = Jsoup.connect(url).get();
            eles = doc.select("tbody tr:not(.notice) .title");
            for (int i = 0; i < eles.size(); i++) {
            	if(eles.get(i).select(".title-link").text().contains(keyword)){
//            		Fmkorea fmkorea = new Fmkorea();
//            		fmkorea.setTitle(eles.get(i).select(".title-link").text());
//            		fmkorea.setLink(eles.get(i).select(".link-reset").attr("Link"));
            		TotalSearchData tsd = new TotalSearchData();
            		totalDataList.add(tsd);
            		System.out.println(eles.get(i).select(".title-link").text() + " \n URL = "+eles.get(i).select(".link-reset").attr("Link")) ;
            	};
            }//for
        }catch(Exception e){
            e.printStackTrace();
        }        
        return totalDataList;
    }
    
	public static List<TotalSearchData> getGaeDrip(String keyword,String url){
		List<GaeDrip> gaeDripList = new ArrayList<GaeDrip>();
		List<TotalSearchData> totalDataList = new ArrayList<TotalSearchData>();
	        try{
	            Document doc = null;
	            Elements eles = null;
	            doc = Jsoup.connect(url).get();
	            eles = doc.select("tbody tr:not(.notice) .title");
	       
	            	for (int i = 0; i < eles.size(); i++) {
	            		if(eles.get(i).select(".title-link").text().contains(keyword)){
	            			
	            			 if(keyword.trim().equals("")){
	         	            	System.out.println("개드립 글 목록");
	         	            	
	         	            }else{	
//	         	            	GaeDrip gaeDrip = new GaeDrip();
//		            			gaeDrip.setTitle(eles.get(i).select(".title-link").text());
//		            			gaeDrip.setLink(eles.get(i).select(".link-reset").attr("href"));
//		            			System.out.println(eles.get(i).select(".title-link").text() + " \n URL = "+eles.get(i).select(".link-reset").attr("href")) ;
//	         	            	gaeDripList.add(gaeDrip);
//	         	            	
	         	            	TotalSearchData tsd = new TotalSearchData();
	         	            	tsd.setTitle(eles.get(i).select(".title-link").text());
	         	            	tsd.setLink(eles.get(i).select(".link-reset").attr("href"));
		            			System.out.println(eles.get(i).select(".title-link").text() + " \n URL = "+eles.get(i).select(".link-reset").attr("href")) ;
	                    		totalDataList.add(tsd);
	         	            }//if
	            		};
	            	}//for
               
	            
	        }catch(Exception e){
	            e.printStackTrace();
	        }        
	        return totalDataList;
	}
	
	public static List<TotalSearchData> getHumorUniv(String keyword,String url){
//		List<HumorUniv> huList = new ArrayList<HumorUniv>();
		List<TotalSearchData> totalDataList = new ArrayList<TotalSearchData>();
        try{
            Document doc = null;
            Elements eles = null;
            doc = Jsoup.connect(url).get();
            eles = doc.select("tbody tr:not(.notice) .title");
            for (int i = 0; i < eles.size(); i++) {
            	if(eles.get(i).select(".title-link").text().contains(keyword)){
//            		HumorUniv hu = new HumorUniv();
//            		hu.setTitle(eles.get(i).select(".title-link").text());
//            		hu.setLink(eles.get(i).select(".link-reset").attr("href"));
//            		huList.add(hu);
            		
            		TotalSearchData tsd = new TotalSearchData();
            		tsd.setTitle(eles.get(i).select(".title-link").text());
            		tsd.setLink(eles.get(i).select(".link-reset").attr("href"));
            		totalDataList.add(tsd);
            		
            		
            		System.out.println(eles.get(i).select(".title-link").text() + " \n URL = "+eles.get(i).select(".link-reset").attr("href")) ;
            	};
            }//for
        }catch(Exception e){
            e.printStackTrace();
        }        
        
        return totalDataList;
	}
	
	public static List<TotalSearchData> getPpomppu(String keyword,String url){
//		List<Ppomppu> ppList = new ArrayList<Ppomppu>();
		List<TotalSearchData> totalDataList = new ArrayList<TotalSearchData>();

        try{
            Document doc = null;
            Elements eles = null;
            doc = Jsoup.connect(url).get();
            eles = doc.select("tbody tr:not(.notice) .title");
            for (int i = 0; i < eles.size(); i++) {
            	if(eles.get(i).select(".title-link").text().contains(keyword)){
//            		Ppomppu pp = new Ppomppu();
//            		pp.setTitle(eles.get(i).select(".title-link").text());
//            		pp.setLink(eles.get(i).select(".link-reset").attr("Link"));
//            		ppList.add(pp);
            		
            		TotalSearchData tsd = new TotalSearchData();
            		tsd.setTitle(eles.get(i).select(".title-link").text());
            		tsd.setLink(eles.get(i).select(".link-reset").attr("href"));
            		totalDataList.add(tsd);
            		System.out.println(eles.get(i).select(".title-link").text() + " \n URL = "+eles.get(i).select(".link-reset").attr("Link")) ;
            	};
            }//for
        }catch(Exception e){
            e.printStackTrace();
        }        
        
        return totalDataList;
	}
	
	public static List<TotalSearchData> getTodayHumor(String keyword,String url){
//		List<TodayHumor> thList = new ArrayList<TodayHumor>();
		List<TotalSearchData> totalDataList = new ArrayList<TotalSearchData>();
        try{
            Document doc = null;
            Elements eles = null;
            doc = Jsoup.connect(url).get();
            eles = doc.select("tbody tr:not(.notice) .title");
            for (int i = 0; i < eles.size(); i++) {
            	if(eles.get(i).select(".title-link").text().contains(keyword)){
//            		TodayHumor th = new TodayHumor();
//            		th.setTitle(eles.get(i).select(".title-link").text());
//            		th.setLink(eles.get(i).select(".link-reset").attr("Link"));
//            		thList.add(th);
            		
            		TotalSearchData tsd = new TotalSearchData();
            		tsd.setTitle(eles.get(i).select(".title-link").text());
            		tsd.setLink(eles.get(i).select(".link-reset").attr("href"));
            		totalDataList.add(tsd);
            		System.out.println(eles.get(i).select(".title-link").text() + " \n URL = "+eles.get(i).select(".link-reset").attr("Link")) ;
            	};
            }//for
        }catch(Exception e){
            e.printStackTrace();
        }        
        return totalDataList;
	}
	
	public static List<TotalSearchData> getYgosu(String keyword,String url){
//		List<Ygosu> ygList = new ArrayList<Ygosu>();
		List<TotalSearchData> totalDataList = new ArrayList<TotalSearchData>();
        try{
            Document doc = null;
            Elements eles = null;
            doc = Jsoup.connect(url).get();
            eles = doc.select("tbody tr:not(.notice) .title");
            for (int i = 0; i < eles.size(); i++) {
            	if(eles.get(i).select(".title-link").text().contains(keyword)){
//            		Ygosu yg = new Ygosu();
//            		yg.setTitle(eles.get(i).select(".title-link").text());
//            		yg.setLink(eles.get(i).select(".link-reset").attr("Link"));
//            		ygList.add(yg);
            		
            		TotalSearchData tsd = new TotalSearchData();
            		tsd.setTitle(eles.get(i).select(".title-link").text());
            		tsd.setLink(eles.get(i).select(".link-reset").attr("href"));
            		totalDataList.add(tsd);
            		System.out.println(eles.get(i).select(".title-link").text() + " \n URL = "+eles.get(i).select(".link-reset").attr("Link")) ;
            	};
            }//for
        }catch(Exception e){
            e.printStackTrace();
        }        
        
        return totalDataList;
	}
	
}
