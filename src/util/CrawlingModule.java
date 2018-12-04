package util;

import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import vo.BobaeDream;
import vo.Dcinside;
import vo.Fmkorea;
import vo.GaeDrip;

public class CrawlingModule {

	public static List<GaeDrip> doCrawling(GaeDrip gaeObj,String keyword,String url){
		
		List<GaeDrip> gaeDripList = new ArrayList<GaeDrip>();
		
		System.out.println("doCrawling called ! ");

	        Document doc = null;
	        Elements eles = null;
	        try{
		        
		        // 반복 접속이 되어야함.
	            doc = Jsoup.connect(url).get();

	            // 각 사이트에 따른 요소 검색 
	            eles = doc.select("tbody tr:not(.notice) .title");
	        }catch(Exception e){
	            e.printStackTrace();
	        }        
	        boolean matchFlag = false; // 매칭된 게시글이 존재하는지 판단
	        boolean nextSiteFlag = false; // 다음 사이트 조회 판단
	        
	        for (int i = 0; i < eles.size(); i++) {
	        	if(eles.get(i).select(".title-link").text().contains(keyword)){
	        		GaeDrip gaeDrip = new GaeDrip();
	        		gaeDrip.setTitle(eles.get(i).select(".title-link").text());
	        		gaeDrip.setLink(eles.get(i).select(".link-reset").attr("Link"));
	        		
	        		gaeDripList.add(gaeDrip);
	        		// 유사 게시글 
	        		System.out.println(eles.get(i).select(".title-link").text() + " \n URL = "+eles.get(i).select(".link-reset").attr("Link")) ;
	        	};
	        }//for
	        
	        
	        return gaeDripList;
	}
	
	public static List<BobaeDream> doCrawling(BobaeDream bobaeObj, String keyword,String url){
			
			List<BobaeDream> bobaeDreamList = new ArrayList<BobaeDream>();
	
		        Document doc = null;
		        Elements eles = null;
		        try{
			        
			        // 반복 접속이 되어야함.
		            doc = Jsoup.connect(url).get();
	
		            // 각 사이트에 따른 요소 검색 
		            eles = doc.select("tbody tr:not(.notice) .title");
		        }catch(Exception e){
		            e.printStackTrace();
		        }        
		        
		        for (int i = 0; i < eles.size(); i++) {
		        	if(eles.get(i).select(".title-link").text().contains(keyword)){
		        		BobaeDream bobaeDream = new BobaeDream();
		        		bobaeDream.setTitle(eles.get(i).select(".title-link").text());
		        		bobaeDream.setLink(eles.get(i).select(".link-reset").attr("Link"));
		        		
		        		bobaeDreamList.add(bobaeDream);
		        		// 유사 게시글 
		        		System.out.println(eles.get(i).select(".title-link").text() + " \n URL = "+eles.get(i).select(".link-reset").attr("Link")) ;
		        	};
		        }//for
		        return bobaeDreamList;
		}
	
	public static List<Dcinside> doCrawling(Dcinside dcObj, String keyword,String url){
		
		List<Dcinside> dcList = new ArrayList<Dcinside>();

        Document doc = null;
        Elements eles = null;
        try{
	        
	        // 반복 접속이 되어야함.
            doc = Jsoup.connect(url).get();

            // 각 사이트에 따른 요소 검색 
            eles = doc.select("tbody tr:not(.notice) .title");
        }catch(Exception e){
            e.printStackTrace();
        }        
        
        for (int i = 0; i < eles.size(); i++) {
        	if(eles.get(i).select(".title-link").text().contains(keyword)){
        		Dcinside dcinside = new Dcinside();
        		dcinside.setTitle(eles.get(i).select(".title-link").text());
        		dcinside.setLink(eles.get(i).select(".link-reset").attr("Link"));
        		
        		dcList.add(dcinside);
        		// 유사 게시글 
        		System.out.println(eles.get(i).select(".title-link").text() + " \n URL = "+eles.get(i).select(".link-reset").attr("Link")) ;
        	};
        }//for
        
        
        return dcList;
}
	
	public static List<Fmkorea> doCrawling(Fmkorea fmObj, String keyword,String url){
		
			List<Fmkorea> fmKoreaList = new ArrayList<Fmkorea>();
	
	        Document doc = null;
	        Elements eles = null;
	        try{
		        
		        // 반복 접속이 되어야함.
	            doc = Jsoup.connect(url).get();
	
	            // 각 사이트에 따른 요소 검색 
	            eles = doc.select("tbody tr:not(.notice) .title");
	        }catch(Exception e){
	            e.printStackTrace();
	        }        
	        
	        for (int i = 0; i < eles.size(); i++) {
	        	if(eles.get(i).select(".title-link").text().contains(keyword)){
	        		Fmkorea fmkorea = new Fmkorea();
	        		fmkorea.setTitle(eles.get(i).select(".title-link").text());
	        		fmkorea.setLink(eles.get(i).select(".link-reset").attr("Link"));
	        		
	        		fmKoreaList.add(fmkorea);
	        		// 유사 게시글 
	        		System.out.println(eles.get(i).select(".title-link").text() + " \n URL = "+eles.get(i).select(".link-reset").attr("Link")) ;
	        	};
	        }//for
	        
	        
	        return fmKoreaList;
	}
	
}
