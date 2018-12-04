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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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
	@FXML private DatePicker endDate; // 크롤링 종료 시점
	
	@FXML private TableView<String> resultTable;
	@FXML private TableColumn<String, String> titleCol;
	@FXML private TableColumn<String, String> regdateCol;
	
	ObservableList<CheckBox> chkList = FXCollections.observableArrayList();
	Map<String, Object> sites = new HashMap<String, Object>();
	ObservableList<Object> result = FXCollections.observableArrayList();

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

	public void search(ActionEvent event){
		result.clear();
		//전체 체크박스 가져옴
		for(Node node : checkBox_wrap.getChildren()){
			chkList.add((CheckBox)node);
		}

		
		// 체크박스 중 체크 된거만 표시
		for(CheckBox chk : chkList){
			
			if(chk.isSelected()){
				    Object value = sites.get(chk.getId());
				    if (value instanceof GaeDrip) {
				    	result.addAll(CrawlingModule.doCrawling((GaeDrip) value,keyword.getText(),((GaeDrip) value).getUrl("movie"))); // 개드립
				    }else if (value instanceof BobaeDream) {
				    	result.addAll(CrawlingModule.doCrawling((BobaeDream) value,keyword.getText(),((BobaeDream) value).getUrl("car"))); // 보배드림
				    }else if (value instanceof Dcinside) {
				    	result.addAll(CrawlingModule.doCrawling((Dcinside) value,keyword.getText(),((Dcinside) value).getUrl("movie"))); // 디시인사이드
				    }else if (value instanceof Fmkorea) {
				    	result.addAll(CrawlingModule.doCrawling((Fmkorea) value,keyword.getText(),((Fmkorea) value).getUrl("movie"))); // 펨코
				    }else if (value instanceof HumorUniv) {
				    	result.addAll(CrawlingModule.doCrawling((HumorUniv) value,keyword.getText(),((HumorUniv) value).getUrl("movie"))); // 웃대
				    }else if (value instanceof Ppomppu) {
				    	result.addAll(CrawlingModule.doCrawling((Ppomppu) value,keyword.getText(),((Ppomppu) value).getUrl("movie"))); // 뽐뿌
				    }else if (value instanceof TodayHumor) {
				    	result.addAll(CrawlingModule.doCrawling((TodayHumor) value,keyword.getText(),((TodayHumor) value).getUrl("movie"))); // 오유 
				    }else if (value instanceof Ygosu) {
				    	result.addAll(CrawlingModule.doCrawling((Ygosu) value,keyword.getText(),((Ygosu) value).getUrl("movie"))); // 와이고수    
				    }
			}
			
		}
		
		
//		System.out.println(result.toString());
		for (int i = 0; i <result.size(); i++) {
			System.out.println(result.get(i));
		}
	}//search
	
    public void chkAll(ActionEvent event){

    	
    }//chkAll
    
    
    //크롤링 종료시점
    public void getEndDate(ActionEvent event){
 	    System.out.println(endDate.getValue());
    }
}
