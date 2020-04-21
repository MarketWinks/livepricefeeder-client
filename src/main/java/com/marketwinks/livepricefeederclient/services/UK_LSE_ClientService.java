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

					String macdurl = "https://livemacdcalculator.herokuapp.com" + "/uk_lse_5mins_livemarketmacd/" + line.toString() + "/calc";

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
}