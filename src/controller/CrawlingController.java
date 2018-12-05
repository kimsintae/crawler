package controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
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
import vo.TotalSearchData;
import vo.Ygosu;

public class CrawlingController implements Initializable{

	@FXML private TextField keyword;
	@FXML private Button searchBtn;
	@FXML private CheckBox gaedrip;
	@FXML private Pane checkBox_wrap;
	@FXML private DatePicker endDate; // 크롤링 종료 시점
	@FXML private TableView<TotalSearchData> resultTable;
	@FXML private TableColumn<TotalSearchData, String> titleCol;
	@FXML private TableColumn<TotalSearchData, String> siteCol;
	
	ObservableList<CheckBox> chkList = FXCollections.observableArrayList();
	ObservableList<TotalSearchData> resultList = FXCollections.observableArrayList();

	
	
	
	
	
	Properties pros = new Properties();
	@Override
	public void initialize(URL location, ResourceBundle resources) {
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
		 pros.load(new FileInputStream("site_info.properties"));
	     SSLContext sc = SSLContext.getInstance("TLS");
			sc.init(null, trustAllCerts, new SecureRandom());
			HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
		} catch (KeyManagementException | NoSuchAlgorithmException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}//init
	

	public void search(ActionEvent event){
		String type = "movie";
		resultList.clear();
		chkList.clear();
		//전체 체크박스 가져옴
		for(Node node : checkBox_wrap.getChildren()){
			chkList.add((CheckBox)node);
		}
		
		// 체크박스 중 체크 된거만 표시
		for(CheckBox chk : chkList){
			
			//크롤링시작
			if(chk.isSelected()){
				
				if(!keyword.getText().trim().equals("")){
					resultList.addAll(CrawlingModule.doCrawling(pros.getProperty(chk.getId()+"_"+type),keyword.getText().trim(),type,chk.getId()));
				}else{
					System.out.println("검색어 없음");
				}
				
			}//selected
		}
		for (int i = 0; i <resultList.size(); i++) {
			System.out.println(resultList.get(i).getTitle());
			titleCol.setCellValueFactory(cellData -> cellData.getValue().getTitle());
			siteCol.setCellValueFactory(cellData -> cellData.getValue().getSiteName());
			resultTable.setItems(resultList);
		}
		
	}//search
	
    public void chkAll(ActionEvent event){

    	
    }//chkAll
    
    
    //크롤링 종료시점
    public void getEndDate(ActionEvent event){
 	    System.out.println(endDate.getValue());
    }
}
