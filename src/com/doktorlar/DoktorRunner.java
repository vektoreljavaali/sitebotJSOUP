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



public class DoktorRunner {

	public static void main(String[] args) throws Exception {
		
		ArrayList<doktors> dlst = new ArrayList<>();
		doktors dokt;
		DAO db =  new DAO();
		String url = "https://www.doktorsitesi.com/uzmanlar?sayfa=";
		dosyayakayit ds = new dosyayakayit();
        Document child1 ;
        Document child2 ;
        Document child3 ;
        Document child4 ;
        Document child5 ;
        Document child6 ;
        Document child7 ;
               
        Elements els2;
        Elements els3;
        Elements els4;
        Elements els5;
        Elements els6;
        Elements els7;
        
        Document doc;
        Document childdoc;
        
        
        for (int i = 1; i <= 4851; i++) {
        	
        	  doc = Jsoup.connect(url.concat(i+"")).get();
              
              Elements els = doc.select("section");
		
        
        for (Element element : els) {
        try {
        	dokt = new doktors();
        	//if(element.tagName().equals("section"))
        	child1 = Jsoup.parse(element.toString());
        	
        	// Doktorlarýn url linklerini alýr
        	els2 = child1.select("a");
        	for (Element element1 : els2) {
        		System.out.println(element1.attr("href"));
        		dokt.setUrl(element1.attr("href"));
        		break;
        		
			}
        	
        	//Doktor özel sayfasý
        	  childdoc = Jsoup.connect(dokt.getUrl()).get();
        	  Elements childels = childdoc.select("img");
        	  int don=0;
        	
        	  for (Element element2 : childels) {
        		if(element2.attr("class").equals("img-responsive"))
				if(element2.attr("src").contains("googleapis"))	dokt.setGooglemaps(element2.attr("src"));
				   		
			}
        	
        	 childels = childdoc.select("div");
        	 String ozgecmis="";
        	  for (Element element2 : childels) {
        		  if(element2.attr("style").equals("margin-left:35px;max-height: 220px; overflow-y:auto;"))
        		  ozgecmis+= element2.text();
				   		
			}  
        	
        dokt.setOzgecmis(ozgecmis);
        	 childels = childdoc.select("div");
            	 String deneyim="";
            	  for (Element element2 : childels) {
            		  if(element2.attr("id").equals("treatments"))
            			  deneyim+= (element2.text()+":");
    				   		
    		}  
            	
        
          dokt.setDeneyimler(deneyim);
          
         	 childels = childdoc.select("div");
           	 String uzmanlikalanlari="";
          	  for (Element element2 : childels) {
               		  if(element2.attr("id").equals("relevances"))
               			uzmanlikalanlari+= (element2.text()+":");
         		}  
            dokt.setUzmanlikalanlari(uzmanlikalanlari);    	  
        	  
        	// Doktorlarýn url linklerini alýr
        	els2 = child1.select("img");
        	
        	for (Element element1 : els2) {
        		System.out.println(element1.attr("src"));
        		dokt.setImageurl(element1.attr("src"));
        		
        		break;
        		
			}
        	
        	
        	
        	// Doktorlarýn yýldýzlarý  alýr
        	els2 = child1.select("div");
        	for (Element element1 : els2) {
        		if(element1.attr("class").equals("stars star-xs")) {
        			System.out.println(element1.attr("data-score"));
            		dokt.setYorumsayisi(element1.attr("data-score"));
            		break;
        		}
        		
			}
        	
        	
        	//Doktorlarýn ünvanýný adýný soyadýný alýr. 
        	els3 = child1.select("h2");
        	for (Element element2 : els3) {
				System.out.println(element2.text());
				dokt.setAdsoyad(element2.text());
				break;
			}
        	
        	//Doktorlarýn Branþlarýný alýr.
        	els4 = child1.select("h4");
        	for (Element element3 : els4) {
        		if(els4.attr("class").equals("branch")) {
				System.out.println(element3.text());
				dokt.setBrans(element3.text());
				break;
        		}
			}
        	
        	
        	// Doktorlara ait hizmet alanlarý bilgilerini verir
        	els5 = child1.select("p");
        	for (Element element4 : els5) {
        		if(els5.attr("class").equals("relevances t-margin-5")) {
				System.out.println(element4.text());
				dokt.setRelevances(element4.text());
				break;
        		}
			}
        	
        	//Doktorlara ait full adres bilgilerini verir
        	els6 = child1.select("address");
        	for (Element element5 : els6) {
        		System.out.println(element5.text());
				dokt.setAdresfull(element5.text());
				break;
			}
        	String dosyaadi =  "doktorimages/"+dokt.getAdsoyad()+".jpg";
        	ds.downloadUsingNIO(dokt.getImageurl(),dosyaadi);
        	
       //    dlst.add(dokt);
      	db.Kaydet(dokt);
		} catch (Exception e) {
			// TODO: handle exception
		}	
        	
      
        	      
        	
		}
       
        } 
	}

}
