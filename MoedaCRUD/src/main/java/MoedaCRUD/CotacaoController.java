package MoedaCRUD;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/cotacao")
public class CotacaoController {

	@Autowired
	CotacaoDAO dao;
	
	@Autowired
	MoedaDAO moedaDAO;
	
	@PostMapping(value = "/{simbolo}/{ano}/{mes}/{dia}")
	public ResponseEntity<Cotacao> criar(@RequestBody Cotacao valor, @PathVariable("simbolo") String simbolo, @PathVariable("ano") String ano, @PathVariable("mes") String mes, @PathVariable("dia") String dia) {
		
		Moeda moeda = moedaDAO.findBySimbolo(simbolo);
		String date = ano + "." + dia + "." + mes;
		Cotacao aux = new Cotacao(moeda.getId(), date, valor.getValor());
		
		Cotacao cotacaoCriada = dao.save(aux);
		return new ResponseEntity<Cotacao>(cotacaoCriada, HttpStatus.OK);
		
	}
	
	@GetMapping(path = "/{simbolo}")
	public ResponseEntity<Iterable<Cotacao>> find(@PathVariable String simbolo) {
		
		try {
			Moeda aux = moedaDAO.findBySimbolo(simbolo);
			Iterable<Cotacao> cotacoes = dao.findByIdMoeda(aux.getId());
			return new ResponseEntity<Iterable<Cotacao>>(cotacoes, HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<Iterable<Cotacao>>(HttpStatus.NOT_FOUND);
		}
	}
	
}
