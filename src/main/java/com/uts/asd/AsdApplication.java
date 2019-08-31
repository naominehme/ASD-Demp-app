package com.uts.asd;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

@SpringBootApplication
@MapperScan(basePackages = "com.uts.asd.mapper")
public class AsdApplication {

	public static void main(String[] args) throws IOException {
		setupFirebase();
		SpringApplication.run(AsdApplication.class, args);
	}

	public static void setupFirebase () throws IOException {
		// Fetch the service account key JSON file contents
        File tmpFile = new File(AsdApplication.class.getClassLoader().getResource("online-auction-system-8c033-firebase-adminsdk-sq85x-3b34b964b3.json").getFile());
		FileInputStream serviceAccount = new FileInputStream(tmpFile);

		// Initialize the app with a service account, granting admin privileges
		FirebaseOptions options = new FirebaseOptions.Builder()
				.setCredentials(GoogleCredentials.fromStream(serviceAccount))
				.setDatabaseUrl("https://online-auction-system-8c033.firebaseio.com")
				.build();
		FirebaseApp.initializeApp(options);
	}

}
