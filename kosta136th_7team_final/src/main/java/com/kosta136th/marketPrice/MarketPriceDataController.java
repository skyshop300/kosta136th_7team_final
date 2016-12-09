package com.kosta136th.marketPrice;

import java.math.BigDecimal;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.json.simple.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


//View를 처리하는 Controller
//성용 작업중!!
@Controller
<<<<<<< HEAD:kosta136th_7team_final/src/main/java/com/kosta136th/marketPrice/MarketPriceController.java
public class MarketPriceController {

	
	private MarketPriceController() {}
	
	@Inject
	private SqlSession session;
	
	private static String namespace = "com.kosta136th.mapper.marketPriceMapper";
	
	//db에서 받아온 데이터 중 원하는 속성만 추려서 JSON 객체화 한다.
	/*	@RequestMapping(value = "/chartData")
		public List<MarketPriceChart> home() {
=======
@RequestMapping("/rate/*")
public class MarketPriceDataController {
	
	/*@Inject
	MarketPriceService marketPriceservice;
	@Scheduled(fixedDelay = 12000000)
	@RequestMapping(value = "/rateSave", method = RequestMethod.GET)
	public void rateSave() {
		
		System.out.println("저장하러왔습니다.");
		
		try {
>>>>>>> 5fc54fba803b0c1828c8f46d83a83814a222384c:kosta136th_7team_final/src/main/java/com/kosta136th/marketPrice/MarketPriceDataController.java
			
			System.out.println("chartData파트입니다.");
			//mapper에서 바로 받아서 뿌려준다.
			//콘솔로 찍어보자.
			
			//객체 타입으로 데이터를 날리면 안된다. 배열을 보내야한다.
			//ArrayList<MarketPrice> marketPriceList = new ArrayList<MarketPrice>();
			//MarketPrice marketPrice= new MarketPrice();
			
<<<<<<< HEAD:kosta136th_7team_final/src/main/java/com/kosta136th/marketPrice/MarketPriceController.java
			//mapper.xml로 부터  데이터를 뽑아 온다.
			List<MarketPrice> marketPriceList = sqlSession.selectList(namespace + ".list");	//<select id="list"
=======
			apiURL = "https://www.worldcoinindex.com/apiservice/json?key=TSd9QUg1uE9PRE3JSFP88IWvJ";

			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			con.setRequestMethod("GET");
			int responseCode = con.getResponseCode();
			BufferedReader br;

			if(responseCode==200) { 
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else {
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			String inputLine;
			StringBuffer res = new StringBuffer();
			while ((inputLine = br.readLine()) != null) {
				res.append(inputLine);
			}
			br.close();
			if(responseCode==200) {
				command = res.toString();
			}
>>>>>>> 5fc54fba803b0c1828c8f46d83a83814a222384c:kosta136th_7team_final/src/main/java/com/kosta136th/marketPrice/MarketPriceDataController.java
			
			//JsonArray 객체 생성
			JSONArray jsonArray = new JSONArray();
			
			String timestamp;
			double perPrice;
			
			//System.out.println("marketPriceList.size()" + (marketPriceList.size() - 20));
			
			//for(int i = 0 ; i < marketPriceList.size(); i++){
			for(int i = 0 ; i < (sqlSession.selectList(namespace + ".list").size()) ; i++){
				
//				MarketPriceJson marketPrice = new MarketPriceJson();	
//				marketPrice.setTimestamp(marketPriceList.get(i).getTimestamp());
//				marketPriceList.get(i).getTime().getTime() / 1000
				
				
				
				timestamp = marketPriceList.get(i).getTimestamp();
				perPrice = marketPriceList.get(i).getPrice_usd();
				
				
				
				BigDecimal bigTimestamp = new BigDecimal(timestamp);		//timestamp는 원래 String 타입이므로 바로 BigDecimal을 먹여준다.
				BigDecimal bigPerPrice = new BigDecimal(String.valueOf(perPrice)); 
				
				System.out.println("bigTimestamp [" + i + "] :" +  bigTimestamp);
				
				BigDecimal[] bigDecimalArray = {bigTimestamp, bigPerPrice};
				
				//Array 타입을 jsonArray에 추가한다.
				jsonArray.add(bigDecimalArray);
				//jsonArray.add(perPrice);
				
				
				//MarketPrice marketPriceUSD = new MarketPrice();
				
				//marketPriceUSD.setUnixTimestamp(unixTimestamp);
				//marketPriceUSD.setPrice_usd(marketPriceList.get(i).getPrice_usd());
				//marketPrice.setPerPrice(marketPriceList.get(i).getPrice_usd());
				
				//marketPriceListResult.add(marketPrice);
				
			}
			
			return jsonArray;	//home.jsp
			
		}
		
<<<<<<< HEAD:kosta136th_7team_final/src/main/java/com/kosta136th/marketPrice/MarketPriceController.java
	}
	
	*/
	
=======
	}*/	
	
//	@RequestMapping(value = "/bitrate", method = RequestMethod.GET)
//	public String callWorldCoinIndexDotCom(Model model) {
//
//		try {
//			
//			String jsonInfo = command;
//			try {
//
//				JSONParser jsonParser = new JSONParser();
//
//				//JSON�����͸� �־� JSON Object �� ����� �ش�.
//				JSONObject jsonObject = (JSONObject) jsonParser.parse(jsonInfo);
//
//				//books�� �迭�� ����
//				JSONArray marketsInfoArray = (JSONArray) jsonObject.get("Markets");
//
//
//				ArrayList<MarketPrice> marketPriceList = new ArrayList<MarketPrice>();
//
//				for(int i=0; i<marketsInfoArray.size(); i++){
//
//					//�迭 �ȿ� �ִ°͵� JSON���� �̱� ������ JSON Object �� ����
//					JSONObject marketsObject = (JSONObject) marketsInfoArray.get(i);
//
//					//������ ���ֱ����� ������ ������ ���� ����
//					BigDecimal price_btc = new BigDecimal((Double) marketsObject.get("Price_btc"));
//					BigDecimal price_usd = new BigDecimal((Double) marketsObject.get("Price_usd"));
//					BigDecimal price_cny = new BigDecimal((Double) marketsObject.get("Price_cny"));
//					BigDecimal price_eur = new BigDecimal((Double) marketsObject.get("Price_eur"));
//					BigDecimal price_gbp = new BigDecimal((Double) marketsObject.get("Price_gbp"));
//					BigDecimal price_rur = new BigDecimal((Double) marketsObject.get("Price_rur"));
//					BigDecimal volume_24h = new BigDecimal((Double) marketsObject.get("Volume_24h"));
//
//					//�������Ҷ���  �и��̴�.
//					BigDecimal ex = new BigDecimal(1);
//
//					//ex)price_rur/ex = ex�� 1�̱⶧���� price_rur �����ǰ��� ���´�. �׸��� 7�ڸ����� �Ҽ����� �����ϰ� �������� �Ҽ���ó���Ѵ�.
//					BigDecimal price_btc_out = price_btc.divide(ex, 6, BigDecimal.ROUND_DOWN);
//					BigDecimal price_usd_out = price_usd.divide(ex, 7, BigDecimal.ROUND_DOWN);
//					BigDecimal price_cny_out = price_cny.divide(ex, 7, BigDecimal.ROUND_DOWN);
//					BigDecimal price_eur_out = price_eur.divide(ex, 7, BigDecimal.ROUND_DOWN);
//					BigDecimal price_gbp_out = price_gbp.divide(ex, 7, BigDecimal.ROUND_DOWN);
//					BigDecimal price_rur_out = price_rur.divide(ex, 7, BigDecimal.ROUND_DOWN);
//					BigDecimal volume_24h_out = volume_24h.divide(ex, 6, BigDecimal.ROUND_DOWN);
//					MarketPrice marketPrice = new MarketPrice();
//
//					marketPrice.setLabel((String) marketsObject.get("Label"));
//					marketPrice.setName((String) marketsObject.get("Name"));;
//					marketPrice.setPrice_btc_result(price_btc_out);
//					marketPrice.setPrice_usd_result(price_usd_out);
//					marketPrice.setPrice_cny_result(price_cny_out);
//					marketPrice.setPrice_eur_result(price_eur_out);
//					marketPrice.setPrice_gbp_result(price_gbp_out);
//					marketPrice.setPrice_rur_result(price_rur_out);
//					marketPrice.setVolume_24h_result(volume_24h_out);
//					marketPrice.setTimestamp((Long) marketsObject.get("Timestamp"));;
//
//					marketPriceList.add(marketPrice);
//
//
//				}
//
//				model.addAttribute("marketPriceList", marketPriceList);
//				System.out.println(marketPriceList.size());
//
//
//			} catch (ParseException e) {
//
//				e.printStackTrace();
//			}
//			
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//		
//		
//	    	ArrayList<Rate> rateList = new ArrayList<Rate>();
//	        try {
//	            String apiURL;	
//	            /*USDKRW - �̱�
//	            JPYKRW - �Ϻ�
//	            EURKRW - ����
//	            CNYKRW - �߱� ��
//	            RURKRW - ���þ�
//	            GBPKRW - ����
//	            BTCKRW - �ٸ� api 
//	            */
//
//	            String command = "";
//	            String[] names = {"USDKRW", "JPYKRW", "EURKRW", "CNYKRW", "RUBKRW", "GBPKRW", "BTCKRW"};
//	            for(int i = 0; i<names.length; i++){
//	            apiURL = "http://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20yahoo.finance.xchange%20where%20pair%3D%22"+ names[i] +"%22&format=json&diagnostics=true&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys";
//	            
//	            URL url = new URL(apiURL);
//	            HttpURLConnection con = (HttpURLConnection)url.openConnection();
//	            con.setRequestMethod("GET");
//	            int responseCode = con.getResponseCode();
//	            BufferedReader br;
//	           
//	            if(responseCode==200) { // ���� ȣ��
//	                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
//	            } else {  // ���� �߻�
//	                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
//	            }
//	            String inputLine;
//	            StringBuffer res = new StringBuffer();
//	            while ((inputLine = br.readLine()) != null) {
//	                res.append(inputLine);
//	            }
//	            br.close();
//	            if(responseCode==200) {
//	                command = res.toString();
//	            }
//
//	            			String jsonInfo = command;
//
//	                    	JSONObject object = (JSONObject)JSONValue.parse(jsonInfo);
//	                    	JSONObject test = (JSONObject) object.get("query");
//
//
//	                    	String jsonInfo2 = test.get("results").toString();
//	                    	JSONObject object2 = (JSONObject) JSONValue.parse(jsonInfo2);
//
//	                    	String jsonInfo3 = object2.get("rate").toString();
//	                    	JSONObject object3 = (JSONObject) JSONValue.parse(jsonInfo3);
//	                    	
//	                        Rate rate = new Rate();
//	                        rate.setId(object3.get("id").toString());
//	                        rate.setName(object3.get("Name").toString());
//	                        rate.setRate(object3.get("Rate").toString());
//	                        rate.setAsk(object3.get("Ask").toString());
//	                        rate.setBid(object3.get("Bid").toString());
//	                        
//	                        System.out.println(rate.getId());
//	                        System.out.println(rate.getName());
//	                        System.out.println(rate.getRate());
//	                        System.out.println(rate.getAsk());
//	                        System.out.println(rate.getBid());
//	                        
//	                        rateList.add(rate);
//	            }      
//	                        model.addAttribute("rateList", rateList);
//	            
//
//	        } catch (Exception e) {
//	            System.out.println(e);
//	        }
//		return "sub/graph";
//	}

>>>>>>> 5fc54fba803b0c1828c8f46d83a83814a222384c:kosta136th_7team_final/src/main/java/com/kosta136th/marketPrice/MarketPriceDataController.java
}
