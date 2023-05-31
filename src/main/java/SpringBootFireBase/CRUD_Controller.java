package SpringBootFireBase;

import java.util.ArrayList;
//import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CRUD_Controller {

	
	public CRUDService crudService;
	
	public CRUD_Controller(CRUDService crudService) {
		this.crudService = crudService;
	}
	 @GetMapping("/")
	 public String home() {
		 return" its home ";
	 }
	@PostMapping("/create")
	public String create(@RequestBody CRUD crud)throws InterruptedException,ExecutionException {
		return crudService.create(crud);
	}
	@GetMapping("/getAll")
	public ArrayList<CRUD> getALL() throws InterruptedException, ExecutionException{
		return crudService.getALL();
	}
	@GetMapping("/get/{documentId}")
	public CRUD get(@PathVariable String documentId)throws InterruptedException,ExecutionException  {
		return crudService.get(documentId);
	}
	@PutMapping("/put/{documentId}")
	public String update(@RequestBody CRUD crud,@PathVariable String documentId)throws InterruptedException,ExecutionException  {
		return crudService.update(crud,documentId);
	}
	@DeleteMapping("/delete/{documentId}")
	public String delete(@PathVariable String documentId)throws InterruptedException,ExecutionException  {
		return crudService.delete(documentId);
	}
	@GetMapping("/test")
	public ResponseEntity<String> toGetEndPoint(){return ResponseEntity.ok("controller workin all good ");}
}
