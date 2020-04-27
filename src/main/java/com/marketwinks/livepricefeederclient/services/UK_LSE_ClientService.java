package com.marketwinks.livepricefeederclient.services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")

public class UK_LSE_ClientService {

	String serverURL = "https://livepricefeeder.herokuapp.com";

	@RequestMapping(value = "/UK_LSE/5Mins/PriceFeed/start", method = RequestMethod.GET)
	public boolean findUK_LSE_5Mins_Price() throws InterruptedException, IOException {

		boolean execution_result = false;
		List<String> urlList = new ArrayList<String>();

		try {
			File file = new File("src/main/java/com/marketwinks/livepricefeederclient/services/uk_lse_symbols.txt");

			BufferedReader br = new BufferedReader(new FileReader(file));
			try {
				StringBuilder sb = new StringBuilder();
				String line = br.readLine();

				while (line != null) {

					String priceurl = serverURL + "/uk_lse_5mins_livemarketprice/5Mins/" + line.toString();

					urlList.add(priceurl);

					line = br.readLine();
				}

			} finally {
				br.close();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		for (int i = 0; i < urlList.size(); i++) {
			UK_LSE_5Mins_Price_ProcessorThread.process(urlList.get(i));
		}

		execution_result = true;
		return execution_result;

	}

	@RequestMapping(value = "/UK_LSE/5Mins/MacdCalc/start", method = RequestMethod.GET)
	public boolean calcUK_LSE_5Mins_Macd() throws InterruptedException, IOException {

		boolean execution_result = false;
		List<String> urlList = new ArrayList<String>();

		try {
			File file = new File("src/main/java/com/marketwinks/livepricefeederclient/services/uk_lse_symbols.txt");

			BufferedReader br = new BufferedReader(new FileReader(file));
			try {
				StringBuilder sb = new StringBuilder();
				String line = br.readLine();

				while (line != null) {

					String macdurl = "https://livemacdcalculator.herokuapp.com" + "/uk_lse_5mins_livemarketmacd/"
							+ line.toString() + "/calc";

					urlList.add(macdurl);

					line = br.readLine();
				}

			} finally {
				br.close();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		for (int i = 0; i < urlList.size(); i++) {
			UK_LSE_5Mins_Macd_ProcessorThread.process(urlList.get(i));
		}

		execution_result = true;
		return execution_result;

	}

	@RequestMapping(value = "/UK_LSE/15Mins/PriceFeed/start", method = RequestMethod.GET)
	public boolean findUK_LSE_15Mins_Price() throws InterruptedException, IOException {

		boolean execution_result = false;
		List<String> urlList = new ArrayList<String>();

		try {
			File file = new File("src/main/java/com/marketwinks/livepricefeederclient/services/uk_lse_symbols.txt");

			BufferedReader br = new BufferedReader(new FileReader(file));
			try {
				StringBuilder sb = new StringBuilder();
				String line = br.readLine();

				while (line != null) {

					String priceurl = serverURL + "/uk_lse_15mins_livemarketprice/15Mins/" + line.toString();

					urlList.add(priceurl);

					line = br.readLine();
				}

			} finally {
				br.close();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		for (int i = 0; i < urlList.size(); i++) {
			UK_LSE_15Mins_Price_ProcessorThread.process(urlList.get(i));
		}

		execution_result = true;
		return execution_result;

	}

	@RequestMapping(value = "/UK_LSE/30Mins/PriceFeed/start", method = RequestMethod.GET)
	public boolean findUK_LSE_30Mins_Price() throws InterruptedException, IOException {

		boolean execution_result = false;
		List<String> urlList = new ArrayList<String>();

		try {
			File file = new File("src/main/java/com/marketwinks/livepricefeederclient/services/uk_lse_symbols.txt");

			BufferedReader br = new BufferedReader(new FileReader(file));
			try {
				StringBuilder sb = new StringBuilder();
				String line = br.readLine();

				while (line != null) {

					String priceurl = serverURL + "/uk_lse_30mins_livemarketprice/30Mins/" + line.toString();

					urlList.add(priceurl);

					line = br.readLine();
				}

			} finally {
				br.close();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		for (int i = 0; i < urlList.size(); i++) {
			UK_LSE_30Mins_Price_ProcessorThread.process(urlList.get(i));
		}

		execution_result = true;
		return execution_result;

	}

	@RequestMapping(value = "/UK_LSE/Hourly/PriceFeed/start", method = RequestMethod.GET)
	public boolean findUK_LSE_Hourly_Price() throws InterruptedException, IOException {

		boolean execution_result = false;
		List<String> urlList = new ArrayList<String>();

		try {
			File file = new File("src/main/java/com/marketwinks/livepricefeederclient/services/uk_lse_symbols.txt");

			BufferedReader br = new BufferedReader(new FileReader(file));
			try {
				StringBuilder sb = new StringBuilder();
				String line = br.readLine();

				while (line != null) {

					String priceurl = serverURL + "/uk_lse_hourly_livemarketprice/Hourly/" + line.toString();

					urlList.add(priceurl);

					line = br.readLine();
				}

			} finally {
				br.close();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		for (int i = 0; i < urlList.size(); i++) {
			UK_LSE_Hourly_Price_ProcessorThread.process(urlList.get(i));
		}

		execution_result = true;
		return execution_result;

	}

	@RequestMapping(value = "/UK_LSE/Daily/PriceFeed/start", method = RequestMethod.GET)
	public boolean findUK_LSE_Daily_Price() throws InterruptedException, IOException {

		boolean execution_result = false;
		List<String> urlList = new ArrayList<String>();

		try {
			File file = new File("src/main/java/com/marketwinks/livepricefeederclient/services/uk_lse_symbols.txt");

			BufferedReader br = new BufferedReader(new FileReader(file));
			try {
				StringBuilder sb = new StringBuilder();
				String line = br.readLine();

				while (line != null) {

					String priceurl = serverURL + "/uk_lse_daily_livemarketprice/Daily/" + line.toString();

					urlList.add(priceurl);

					line = br.readLine();
				}

			} finally {
				br.close();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		for (int i = 0; i < urlList.size(); i++) {
			UK_LSE_Daily_Price_ProcessorThread.process(urlList.get(i));
		}

		execution_result = true;
		return execution_result;

	}

	@RequestMapping(value = "/UK_LSE/Weekly/PriceFeed/start", method = RequestMethod.GET)
	public boolean findUK_LSE_Weekly_Price() throws InterruptedException, IOException {

		boolean execution_result = false;
		List<String> urlList = new ArrayList<String>();

		try {
			File file = new File("src/main/java/com/marketwinks/livepricefeederclient/services/uk_lse_symbols.txt");

			BufferedReader br = new BufferedReader(new FileReader(file));
			try {
				StringBuilder sb = new StringBuilder();
				String line = br.readLine();

				while (line != null) {

					String priceurl = serverURL + "/uk_lse_weekly_livemarketprice/Weekly/" + line.toString();

					urlList.add(priceurl);

					line = br.readLine();
				}

			} finally {
				br.close();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		for (int i = 0; i < urlList.size(); i++) {
			UK_LSE_Weekly_Price_ProcessorThread.process(urlList.get(i));
		}

		execution_result = true;
		return execution_result;

	}

	@RequestMapping(value = "/UK_LSE/Monthly/PriceFeed/start", method = RequestMethod.GET)
	public boolean findUK_LSE_Monthly_Price() throws InterruptedException, IOException {

		boolean execution_result = false;
		List<String> urlList = new ArrayList<String>();

		try {
			File file = new File("src/main/java/com/marketwinks/livepricefeederclient/services/uk_lse_symbols.txt");

			BufferedReader br = new BufferedReader(new FileReader(file));
			try {
				StringBuilder sb = new StringBuilder();
				String line = br.readLine();

				while (line != null) {

					String priceurl = serverURL + "/uk_lse_monthly_livemarketprice/Monthly/" + line.toString();

					urlList.add(priceurl);

					line = br.readLine();
				}

			} finally {
				br.close();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		for (int i = 0; i < urlList.size(); i++) {
			UK_LSE_Monthly_Price_ProcessorThread.process(urlList.get(i));
		}

		execution_result = true;
		return execution_result;

	}

	@RequestMapping(value = "/UK_LSE/15Mins/MacdCalc/start", method = RequestMethod.GET)
	public boolean calcUK_LSE_15Mins_Macd() throws InterruptedException, IOException {

		boolean execution_result = false;
		List<String> urlList = new ArrayList<String>();

		try {
			File file = new File("src/main/java/com/marketwinks/livepricefeederclient/services/uk_lse_symbols.txt");

			BufferedReader br = new BufferedReader(new FileReader(file));
			try {
				StringBuilder sb = new StringBuilder();
				String line = br.readLine();

				while (line != null) {

					String macdurl = "https://livemacdcalculator.herokuapp.com" + "/uk_lse_15mins_livemarketmacd/"
							+ line.toString() + "/calc";

					urlList.add(macdurl);

					line = br.readLine();
				}

			} finally {
				br.close();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		for (int i = 0; i < urlList.size(); i++) {
			UK_LSE_15Mins_Macd_ProcessorThread.process(urlList.get(i));
		}

		execution_result = true;
		return execution_result;

	}

	@RequestMapping(value = "/UK_LSE/30Mins/MacdCalc/start", method = RequestMethod.GET)
	public boolean calcUK_LSE_30Mins_Macd() throws InterruptedException, IOException {

		boolean execution_result = false;
		List<String> urlList = new ArrayList<String>();

		try {
			File file = new File("src/main/java/com/marketwinks/livepricefeederclient/services/uk_lse_symbols.txt");

			BufferedReader br = new BufferedReader(new FileReader(file));
			try {
				StringBuilder sb = new StringBuilder();
				String line = br.readLine();

				while (line != null) {

					String macdurl = "https://livemacdcalculator.herokuapp.com" + "/uk_lse_30mins_livemarketmacd/"
							+ line.toString() + "/calc";

					urlList.add(macdurl);

					line = br.readLine();
				}

			} finally {
				br.close();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		for (int i = 0; i < urlList.size(); i++) {
			UK_LSE_30Mins_Macd_ProcessorThread.process(urlList.get(i));
		}

		execution_result = true;
		return execution_result;

	}

	@RequestMapping(value = "/UK_LSE/Hourly/MacdCalc/start", method = RequestMethod.GET)
	public boolean calcUK_LSE_Hourly_Macd() throws InterruptedException, IOException {

		boolean execution_result = false;
		List<String> urlList = new ArrayList<String>();

		try {
			File file = new File("src/main/java/com/marketwinks/livepricefeederclient/services/uk_lse_symbols.txt");

			BufferedReader br = new BufferedReader(new FileReader(file));
			try {
				StringBuilder sb = new StringBuilder();
				String line = br.readLine();

				while (line != null) {

					String macdurl = "https://livemacdcalculator.herokuapp.com" + "/uk_lse_hourly_livemarketmacd/"
							+ line.toString() + "/calc";

					urlList.add(macdurl);

					line = br.readLine();
				}

			} finally {
				br.close();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		for (int i = 0; i < urlList.size(); i++) {
			UK_LSE_Hourly_Macd_ProcessorThread.process(urlList.get(i));
		}

		execution_result = true;
		return execution_result;

	}

	@RequestMapping(value = "/UK_LSE/Daily/MacdCalc/start", method = RequestMethod.GET)
	public boolean calcUK_LSE_Daily_Macd() throws InterruptedException, IOException {

		boolean execution_result = false;
		List<String> urlList = new ArrayList<String>();

		try {
			File file = new File("src/main/java/com/marketwinks/livepricefeederclient/services/uk_lse_symbols.txt");

			BufferedReader br = new BufferedReader(new FileReader(file));
			try {
				StringBuilder sb = new StringBuilder();
				String line = br.readLine();

				while (line != null) {

					String macdurl = "https://livemacdcalculator.herokuapp.com" + "/uk_lse_daily_livemarketmacd/"
							+ line.toString() + "/calc";

					urlList.add(macdurl);

					line = br.readLine();
				}

			} finally {
				br.close();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		for (int i = 0; i < urlList.size(); i++) {
			UK_LSE_Daily_Macd_ProcessorThread.process(urlList.get(i));
		}

		execution_result = true;
		return execution_result;

	}

	@RequestMapping(value = "/UK_LSE/Weekly/MacdCalc/start", method = RequestMethod.GET)
	public boolean calcUK_LSE_Weekly_Macd() throws InterruptedException, IOException {

		boolean execution_result = false;
		List<String> urlList = new ArrayList<String>();

		try {
			File file = new File("src/main/java/com/marketwinks/livepricefeederclient/services/uk_lse_symbols.txt");

			BufferedReader br = new BufferedReader(new FileReader(file));
			try {
				StringBuilder sb = new StringBuilder();
				String line = br.readLine();

				while (line != null) {

					String macdurl = "https://livemacdcalculator.herokuapp.com" + "/uk_lse_weekly_livemarketmacd/"
							+ line.toString() + "/calc";

					urlList.add(macdurl);

					line = br.readLine();
				}

			} finally {
				br.close();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		for (int i = 0; i < urlList.size(); i++) {
			UK_LSE_Weekly_Macd_ProcessorThread.process(urlList.get(i));
		}

		execution_result = true;
		return execution_result;

	}

	@RequestMapping(value = "/UK_LSE/Monthly/MacdCalc/start", method = RequestMethod.GET)
	public boolean calcUK_LSE_Monthly_Macd() throws InterruptedException, IOException {

		boolean execution_result = false;
		List<String> urlList = new ArrayList<String>();

		try {
			File file = new File("src/main/java/com/marketwinks/livepricefeederclient/services/uk_lse_symbols.txt");

			BufferedReader br = new BufferedReader(new FileReader(file));
			try {
				StringBuilder sb = new StringBuilder();
				String line = br.readLine();

				while (line != null) {

					String macdurl = "https://livemacdcalculator.herokuapp.com" + "/uk_lse_monthly_livemarketmacd/"
							+ line.toString() + "/calc";

					urlList.add(macdurl);

					line = br.readLine();
				}

			} finally {
				br.close();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		for (int i = 0; i < urlList.size(); i++) {
			UK_LSE_Monthly_Macd_ProcessorThread.process(urlList.get(i));
		}

		execution_result = true;
		return execution_result;

	}

}