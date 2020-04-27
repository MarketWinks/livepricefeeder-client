package com.marketwinks.livepricefeederclient.services;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class UK_LSE_30Mins_Macd_ProcessorThread {

	public static void process(String url) throws IOException, InterruptedException {

		Thread.sleep(500);
		System.out.println("Executing:" + url.substring(52));
		HttpClient client = new DefaultHttpClient();
		HttpGet request = new HttpGet(url);
		HttpResponse response = client.execute(request);
		// BufferedReader rd = new BufferedReader(new
		// InputStreamReader(response.getEntity().getContent()));
		// String line = "";
		// while ((line = rd.readLine()) != null) {
		// System.out.println(line);
		// }

	}
}
