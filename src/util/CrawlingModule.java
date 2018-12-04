package util;

import java.util.ArrayList;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
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

	static List<TotalSearchData> searchDatas = new ArrayList<TotalSearchData>();
	
	
	
    public static List<BobaeDream> doCrawling(BobaeDream bobaeObj, String keyword,String url){
    	List<BobaeDream> bobaeDreamList = new ArrayList<BobaeDream>();
    	try{
    	    Document doc = null;
    	    Elements eles = null;
    		// 사이트 연결
    		doc = Jsoup.connect(url).get();
    		
    		// 요소 탐색  
    		eles = doc.select("tbody tr:not(.notice) .title");
    		for (int i = 0; i < eles.size(); i++) {
    			if(eles.get(i).select(".title-link").text().contains(keyword)){
    				BobaeDream bobaeDream = new BobaeDream();
    				bobaeDream.setTitle(eles.get(i).select(".title-link").text());
    				bobaeDream.setLink(eles.get(i).select(".link-reset").attr("Link"));
    				
    				bobaeDreamList.add(bobaeDream);
    				// 결과
    				System.out.println(eles.get(i).select(".title-link").text() + " \n URL = "+eles.get(i).select(".link-reset").attr("Link")) ;
    			};
    		}//for
    	}catch(Exception e){
    		e.printStackTrace();
    	}        
    	
    	return bobaeDreamList;
    }
    
    public static List<Dcinside> doCrawling(Dcinside dcObj, String keyword,String url){
		List<Dcinside> dcList = new ArrayList<Dcinside>();
        try{
            Document doc = null;
            Elements eles = null;
            doc = Jsoup.connect(url).get();
            eles = doc.select("tbody tr:not(.notice) .title");
            for (int i = 0; i < eles.size(); i++) {
            	if(eles.get(i).select(".title-link").text().contains(keyword)){
            		Dcinside dcinside = new Dcinside();
            		dcinside.setTitle(eles.get(i).select(".title-link").text());
            		dcinside.setLink(eles.get(i).select(".link-reset").attr("Link"));
            		
            		dcList.add(dcinside);
            		System.out.println(eles.get(i).select(".title-link").text() + " \n URL = "+eles.get(i).select(".link-reset").attr("Link")) ;
            	};
            }//for
        }catch(Exception e){
            e.printStackTrace();
        }        
        
        return dcList;
	}
    
    public static List<Fmkorea> doCrawling(Fmkorea fmObj, String keyword,String url){
		List<Fmkorea> fmKoreaList = new ArrayList<Fmkorea>();
        try{
            Document doc = null;
            Elements eles = null;
            doc = Jsoup.connect(url).get();
            eles = doc.select("tbody tr:not(.notice) .title");
            for (int i = 0; i < eles.size(); i++) {
            	if(eles.get(i).select(".title-link").text().contains(keyword)){
            		Fmkorea fmkorea = new Fmkorea();
            		fmkorea.setTitle(eles.get(i).select(".title-link").text());
            		fmkorea.setLink(eles.get(i).select(".link-reset").attr("Link"));
            		fmKoreaList.add(fmkorea);
            		System.out.println(eles.get(i).select(".title-link").text() + " \n URL = "+eles.get(i).select(".link-reset").attr("Link")) ;
            	};
            }//for
        }catch(Exception e){
            e.printStackTrace();
        }        
        return fmKoreaList;
    }

    
	public static List<GaeDrip> doCrawling(GaeDrip gaeObj,String keyword,String url){
		List<GaeDrip> gaeDripList = new ArrayList<GaeDrip>();
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
	         	            	GaeDrip gaeDrip = new GaeDrip();
		            			gaeDrip.setTitle(eles.get(i).select(".title-link").text());
		            			gaeDrip.setLink(eles.get(i).select(".link-reset").attr("href"));
		            			System.out.println(eles.get(i).select(".title-link").text() + " \n URL = "+eles.get(i).select(".link-reset").attr("href")) ;
	         	            	gaeDripList.add(gaeDrip);
	         	            }//if
	            		};
	            	}//for
               
	            
	        }catch(Exception e){
	            e.printStackTrace();
	        }        
	        return gaeDripList;
	}
	
	public static List<HumorUniv> doCrawling(HumorUniv huObj, String keyword,String url){
		List<HumorUniv> huList = new ArrayList<HumorUniv>();
        try{
            Document doc = null;
            Elements eles = null;
            doc = Jsoup.connect(url).get();
            eles = doc.select("tbody tr:not(.notice) .title");
            for (int i = 0; i < eles.size(); i++) {
            	if(eles.get(i).select(".title-link").text().contains(keyword)){
            		HumorUniv hu = new HumorUniv();
            		hu.setTitle(eles.get(i).select(".title-link").text());
            		hu.setLink(eles.get(i).select(".link-reset").attr("href"));
            		huList.add(hu);
            		
            		System.out.println(eles.get(i).select(".title-link").text() + " \n URL = "+eles.get(i).select(".link-reset").attr("href")) ;
            	};
            }//for
        }catch(Exception e){
            e.printStackTrace();
        }        
        
        return huList;
	}
	
	public static List<Ppomppu> doCrawling(Ppomppu ppObj, String keyword,String url){
		List<Ppomppu> ppList = new ArrayList<Ppomppu>();
        try{
            Document doc = null;
            Elements eles = null;
            doc = Jsoup.connect(url).get();
            eles = doc.select("tbody tr:not(.notice) .title");
            for (int i = 0; i < eles.size(); i++) {
            	if(eles.get(i).select(".title-link").text().contains(keyword)){
            		Ppomppu pp = new Ppomppu();
            		pp.setTitle(eles.get(i).select(".title-link").text());
            		pp.setLink(eles.get(i).select(".link-reset").attr("Link"));
            		ppList.add(pp);
            		System.out.println(eles.get(i).select(".title-link").text() + " \n URL = "+eles.get(i).select(".link-reset").attr("Link")) ;
            	};
            }//for
        }catch(Exception e){
            e.printStackTrace();
        }        
        
        return ppList;
	}
	
	public static List<TodayHumor> doCrawling(TodayHumor thObj, String keyword,String url){
		List<TodayHumor> thList = new ArrayList<TodayHumor>();
        try{
            Document doc = null;
            Elements eles = null;
            doc = Jsoup.connect(url).get();
            eles = doc.select("tbody tr:not(.notice) .title");
            for (int i = 0; i < eles.size(); i++) {
            	if(eles.get(i).select(".title-link").text().contains(keyword)){
            		TodayHumor th = new TodayHumor();
            		th.setTitle(eles.get(i).select(".title-link").text());
            		th.setLink(eles.get(i).select(".link-reset").attr("Link"));
            		thList.add(th);
            		System.out.println(eles.get(i).select(".title-link").text() + " \n URL = "+eles.get(i).select(".link-reset").attr("Link")) ;
            	};
            }//for
        }catch(Exception e){
            e.printStackTrace();
        }        
        return thList;
	}
	
	public static List<Ygosu> doCrawling(Ygosu ygObj, String keyword,String url){
		List<Ygosu> ygList = new ArrayList<Ygosu>();
        try{
            Document doc = null;
            Elements eles = null;
            doc = Jsoup.connect(url).get();
            eles = doc.select("tbody tr:not(.notice) .title");
            for (int i = 0; i < eles.size(); i++) {
            	if(eles.get(i).select(".title-link").text().contains(keyword)){
            		Ygosu yg = new Ygosu();
            		yg.setTitle(eles.get(i).select(".title-link").text());
            		yg.setLink(eles.get(i).select(".link-reset").attr("Link"));
            		ygList.add(yg);
            		System.out.println(eles.get(i).select(".title-link").text() + " \n URL = "+eles.get(i).select(".link-reset").attr("Link")) ;
            	};
            }//for
        }catch(Exception e){
            e.printStackTrace();
        }        
        
        return ygList;
	}
	
}
