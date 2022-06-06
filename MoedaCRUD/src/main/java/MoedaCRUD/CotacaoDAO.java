package MoedaCRUD;

import org.springframework.data.repository.CrudRepository;

public interface CotacaoDAO extends CrudRepository<Cotacao, Integer>{

	Iterable<Cotacao> findByIdMoeda(int idMoeda);
	
}
