package com.doktorlar;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class RunnerListSites {

	public static void main(String[] args) throws IOException {
		
		ArrayList<doktors> dlst = new ArrayList<>();
		doktors dokt;
		DAO db =  new DAO();
		String url = "https://www.doktorsitesi.com/uzmanlar?sayfa=";
       
        Document doc,doc1,doc2,doc3,doc4,doc5,doc6,doc7,doc8,doc9;
        
        ArrayList<Document> documentList = new ArrayList<>();
        
        for (int i = 1; i <= 4851; i++) {
        	
        	  doc = Jsoup.connect(url.concat(i+"")).get();
        	
        	  documentList.add(doc);  
               
              System.out.print(i+"-");
       
        } 
	}

	
}
