package controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import util.CrawlingModule;
import vo.TotalSearchData;

public class CrawlingController implements Initializable{

	@FXML private TextField keyword;
	@FXML private Button searchBtn;
	@FXML private CheckBox gaedrip;
	@FXML private Pane checkBox_wrap;
	@FXML private DatePicker endDate; // 크롤링 종료 시점
	@FXML private TableView<TotalSearchData> resultTable;
	@FXML private TableColumn<TotalSearchData, String> titleCol;
	@FXML private TableColumn<TotalSearchData, String> siteCol;
	@FXML private ChoiceBox<String> type;
	@FXML private ChoiceBox<String> colType;
	
	ObservableList<String> choiceList = FXCollections.observableArrayList();
	ObservableList<CheckBox> chkList = FXCollections.observableArrayList();
	ObservableList<TotalSearchData> resultList = FXCollections.observableArrayList();
	
	Properties pros = new Properties();
	
	// 값 초기 설정
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		//선택 박스 값  설정
		choiceList.removeAll(choiceList);
		choiceList.add("MOVIE");
		choiceList.add("TRAVEL");
		choiceList.add("GAME");
		choiceList.add("CAR");
		choiceList.add("SOCCER");
		type.getItems().addAll(choiceList);
		type.getSelectionModel().select(0); // 처음 선택 되어 있을 값
		
		choiceList.removeAll(choiceList);
		choiceList.add("키워드 수집");
		choiceList.add("게시글 수집");
		colType.getItems().addAll(choiceList);
		colType.getSelectionModel().select(0); // 처음 선택 되어 있을 값
		
		// 현재 날짜로 값 설정
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
		endDate.setPromptText(sdf.format(d));
		
		
		// https 연결 설정	
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
		 
		 type.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
			 @Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
//				 System.out.println(type.getSelectionModel().getSelectedItem());
				 
				 
				 
				 
			}
		});

		 colType.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
			 @Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				 System.out.println();
				 
				 if(newValue.intValue()==0){
					 //키워드 수집
					 endDate.setDisable(false);
				 }else{
					 //게시글 수집
					 endDate.setDisable(true);
					 
				 }
			 }
		});

		 
	}//init

	// 검색버튼
	public void search(ActionEvent event){
		resultList.clear();
		chkList.clear();
		
		// 검색 타입
		String colType_str = colType.getValue();
		switch (colType_str) {
		case "게시글  수집":
			colType_str = "search_board";
			break;
		case "키워드  수집":
			colType_str = "search_keyword";
			break;
		}
		
		System.out.println(colType_str);
		//전체 체크박스 가져옴
		for(Node node : checkBox_wrap.getChildren()){
			chkList.add((CheckBox)node);
		}
		
		// 체크박스 중 체크 된거만 표시
		for(CheckBox chk : chkList){
			String typeName = type.getValue();
			//크롤링시작
			if(chk.isSelected()){
				// 선택된 사이트들만
				if(!keyword.getText().trim().equals("") || colType_str.equals("search_keyword")){
					// 키워드 모듈
					resultList.addAll(CrawlingModule.doCrawling(pros.getProperty(chk.getId()+"_"+type.getValue().toLowerCase()),keyword.getText().trim(),chk.getId()));
				}else{
					// 게시글 모듈
					System.out.println("게시글 모듈");
					
				}
				
			}//selected
		}
		
		// 테이블에 데이터 뿌리기
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
