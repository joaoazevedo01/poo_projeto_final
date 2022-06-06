package MoedaCRUD;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/moeda")
public class MoedaController {

	@Autowired
	MoedaDAO dao;
	
	@PostMapping
	public ResponseEntity<Moeda> criar(@RequestBody Moeda moeda) {
		
		Moeda moedaCriada = dao.save(moeda);
		return new ResponseEntity<Moeda>(moedaCriada, HttpStatus.OK);
		
	}
	
	@GetMapping
	public ResponseEntity<Iterable<Moeda>> todos() {
		
		return new ResponseEntity<Iterable<Moeda>>(dao.findAll(), HttpStatus.OK);
		
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Moeda> find(@PathVariable Integer id) {
		
		try {
			Moeda aux = dao.findById(id).get();
			return new ResponseEntity<Moeda>(aux, HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<Moeda>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Moeda> remover(@PathVariable Integer id) {
		
		try {
			Moeda aux = dao.findById(id).get();
			dao.delete(aux);
			return new ResponseEntity<Moeda>(aux, HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<Moeda>(HttpStatus.NOT_FOUND);
		}
	}
}
