package SpringBootFireBase;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.google.auth.oauth2.GoogleCredentials;
//import com.google.cloud.firestore.Firestore;
//import com.google.cloud.firestore.v1.FirestoreClient;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
//import com.google.firebase.cloud.FirestoreClient;

import java.io.File;
import java.io.FileInputStream;
import java.util.Objects;
@SpringBootApplication
public class SprinBootDataFireBaseApplication {

	public static void main(String[] args) {
		ClassLoader classLoader=  SprinBootDataFireBaseApplication.class.getClassLoader();
		  File file = new File(Objects.requireNonNull(classLoader.getResource("serviceAccountKey.json")).getFile());
	
		  try {
			  
		  
		
		FileInputStream serviceAccount = new FileInputStream(file.getAbsolutePath());
        FirebaseOptions options = FirebaseOptions.builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();
        FirebaseApp.initializeApp(options);
        //Firestore db = FirestoreClient.getFirestore();
				
		  }
		  catch( Exception err) {
			  System.out.println("got an error");
			  System.out.println(err.getMessage());
			  
		  }
		SpringApplication.run(SprinBootDataFireBaseApplication.class, args);
	}

}
