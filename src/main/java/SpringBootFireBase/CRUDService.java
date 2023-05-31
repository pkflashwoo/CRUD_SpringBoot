package SpringBootFireBase;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;

@Service
public class CRUDService {
	Firestore db = FirestoreClient.getFirestore();
	
	public String create(CRUD crud) throws InterruptedException, ExecutionException {
		// TODO Auto-generated method stub
	//	Firestore db = FirestoreClient.getFirestore();
		DocumentReference docRef = db.collection("user").document(crud.getDocumentId());
		ApiFuture<WriteResult> result = docRef.set(crud);
		return result.get().getUpdateTime().toString();
	}

	public CRUD get(String documentId) throws InterruptedException, ExecutionException {
		// TODO Auto-generated method stub
		
		DocumentReference docRef = db.collection("user").document(documentId);
		ApiFuture<DocumentSnapshot> result = docRef.get();
		DocumentSnapshot doc = result.get();
		CRUD crud;
		if(doc.exists()) {
			crud = doc.toObject(CRUD.class);
			crud.setDocumentId(documentId);
			return crud;
		}
		return null;
		
		
	}

	public String update(CRUD crud,String documentId) throws InterruptedException, ExecutionException {
		// TODO Auto-generated method stub
		DocumentReference docRef = db.collection("user").document(documentId);
		ApiFuture<DocumentSnapshot> result = docRef.get();
		DocumentSnapshot doc = result.get();
		if(doc.exists()) {
			ApiFuture<WriteResult> time = docRef.set(crud);
			return "doc updated " +time.get().getUpdateTime().toString();
		}
		else {
			return "doc does not exist";
		}
		
		
		
	}

	public String delete(String documentId) throws InterruptedException, ExecutionException {
		// TODO Auto-generated method stub
		Firestore db = FirestoreClient.getFirestore();
		DocumentReference docRef = db.collection("user").document(documentId);
		ApiFuture<DocumentSnapshot> result = docRef.get();
		DocumentSnapshot doc = result.get();
		if(doc.exists()) {
			ApiFuture<WriteResult> WriteResult = db.collection("user").document(documentId).delete();
			return "Succesfully deleted "+ documentId;
		}
		else {
			return "DOC DOES NOT EXISTS";
		}
		
	}

	public ArrayList<CRUD> getALL() throws InterruptedException, ExecutionException {
		// asynchronously retrieve all documents
		ApiFuture<QuerySnapshot> future = db.collection("user").get();
		// future.get() blocks on response
		ArrayList<CRUD> allData = new ArrayList<CRUD>();
		List<QueryDocumentSnapshot> documents = future.get().getDocuments();
		for (QueryDocumentSnapshot document : documents) {
			allData.add(document.toObject(CRUD.class));
		 
		}
		return allData;
	}

}
