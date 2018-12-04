package controller;

import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import util.CrawlingModule;
import vo.BobaeDream;
import vo.Dcinside;
import vo.Fmkorea;
import vo.GaeDrip;
import vo.HumorUniv;
import vo.Ppomppu;
import vo.TodayHumor;
import vo.Ygosu;

public class CrawlingController implements Initializable{

	@FXML private TextField keyword;
	@FXML private Button searchBtn;
	@FXML private CheckBox gaedrip;
	@FXML private Pane checkBox_wrap;
	Map<String, Object> sites = new HashMap<String, Object>();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		sites.put("bobaedream", new BobaeDream());
		sites.put("dcinside", new Dcinside());
		sites.put("Fmkorea", new Fmkorea());
		sites.put("gaedrip", new GaeDrip());
		sites.put("humoruniv", new HumorUniv());
		sites.put("ppomppu", new Ppomppu());
		sites.put("todayhumor", new TodayHumor());
		sites.put("ygosu", new Ygosu());
		
		
		
	 TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager() {
			
			@Override
			public X509Certificate[] getAcceptedIssuers() {
				return new X509Certificate[0];
			}
			
			@Override
			public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
			}
			
			@Override
			public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
			}
		 }
		};
	 try {
	 
	    SSLContext sc = SSLContext.getInstance("TLS");
			sc.init(null, trustAllCerts, new SecureRandom());
			HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
		} catch (KeyManagementException | NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	public void search(){
		ObservableList<CheckBox> chkList = FXCollections.observableArrayList();
		
		// 모든 체크박스를 담음
		for(Node node : checkBox_wrap.getChildren()){
			chkList.add((CheckBox)node);
		}

		
		// 선택된 체크박스에서 vo 객체를 가져옴
		for(CheckBox chk : chkList){
			
			if(chk.isSelected()){
				    Object value = sites.get(chk.getId());
				    if (value instanceof GaeDrip) {
				    	System.out.println("개드립");
				        CrawlingModule.doCrawling((GaeDrip) value,keyword.getText(),((GaeDrip) value).getUrl("movie"));
				    }else if (value instanceof BobaeDream) {
				    	System.out.println("보배드림");
				    	CrawlingModule.doCrawling((BobaeDream) value,keyword.getText(),((BobaeDream) value).getUrl("car"));
				    }else if (value instanceof Dcinside) {
				    	System.out.println("디시인사이드");
				        CrawlingModule.doCrawling((Dcinside) value,keyword.getText(),((Dcinside) value).getUrl("movie"));
				    }else if (value instanceof Fmkorea) {
				        ((Fmkorea) value).getUrl("movie");
				    }else if (value instanceof HumorUniv) {
				        ((HumorUniv) value).getUrl("movie");
				    }else if (value instanceof Ppomppu) {
				        ((Ppomppu) value).getUrl("movie");
				    }else if (value instanceof TodayHumor) {
				        ((TodayHumor) value).getUrl("movie");
				    }else if (value instanceof Ygosu) {
				        ((Ygosu) value).getUrl("movie");
				    }
			}
			
		}

		
		
	}
}
