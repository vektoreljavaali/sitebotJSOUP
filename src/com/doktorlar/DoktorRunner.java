package com.doktorlar;

import java.awt.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import MultiProcessor.MultiRunner;



public class DoktorRunner {

	public static void main(String[] args) throws Exception {
		
		Thread T1 = new Thread(new MultiRunner("", 1, 250));
		T1.start();
		Thread T2 = new Thread(new MultiRunner("1", 251, 500));
		T2.start();
		Thread T3 = new Thread(new MultiRunner("2", 501, 750));
		T3.start();
		Thread T4 = new Thread(new MultiRunner("3", 751, 1000));
		T4.start();
		Thread T5 = new Thread(new MultiRunner("4", 1001, 1250));
		T5.start();
		Thread T6 = new Thread(new MultiRunner("5", 1251, 1500));
		T6.start();
		Thread T7 = new Thread(new MultiRunner("6", 1501, 1750));
		T7.start();
		Thread T8 = new Thread(new MultiRunner("7", 1751, 2000));
		T8.start();
		Thread T9 = new Thread(new MultiRunner("8", 2001, 2250));
		T9.start();
		Thread T10 = new Thread(new MultiRunner("9", 2251, 2500));
		T10.start();
		Thread T11 = new Thread(new MultiRunner("10", 2501, 2750));
		T11.start();
		Thread T12= new Thread(new MultiRunner("11", 2751, 3000));
		T12.start();
		Thread T13 = new Thread(new MultiRunner("12", 3001, 3250));
		T13.start();
		Thread T14 = new Thread(new MultiRunner("13", 3251, 3500));
		T14.start();
		Thread T15 = new Thread(new MultiRunner("14", 3501, 3750));
		T15.start();
		Thread T16 = new Thread(new MultiRunner("15", 3751, 4000));
		T16.start();
		Thread T17 = new Thread(new MultiRunner("16", 4001, 4250));
		T17.start();
		Thread T18 = new Thread(new MultiRunner("17", 4251, 4500));
		T18.start();
		Thread T19 = new Thread(new MultiRunner("18", 4501, 4750));
		T19.start();
		Thread T20 = new Thread(new MultiRunner("19", 4751, 4865));
		T20.start();
		
		
		
				
				
				
	}

}
