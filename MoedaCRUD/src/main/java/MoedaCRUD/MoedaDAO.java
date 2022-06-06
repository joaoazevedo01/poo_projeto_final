package MoedaCRUD;

import org.springframework.data.repository.CrudRepository;

public interface MoedaDAO extends CrudRepository<Moeda, Integer>{
	
	Moeda findBySimbolo(String simbolo);

}