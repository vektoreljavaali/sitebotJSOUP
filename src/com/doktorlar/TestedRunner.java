package com.doktorlar;

import java.io.IOException;

public class TestedRunner {

	public static void main(String[] args) throws IOException {
		dosyayakayit ds = new dosyayakayit();
		
		ds.downloadUsingNIO("https://asset.doktorsitesi.com/media/cache/profilemedium/uploads/profil/2634167.jpg", "doktorimages/doktor.jpg");
	}
	
}
