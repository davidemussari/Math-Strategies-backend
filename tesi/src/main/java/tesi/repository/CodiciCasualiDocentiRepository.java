package tesi.repository;

import org.springframework.data.repository.CrudRepository;

import tesi.dataModel.CodiciCasualiDocenti;

public interface CodiciCasualiDocentiRepository extends CrudRepository<CodiciCasualiDocenti, Integer>{

	CodiciCasualiDocenti findByCodiceCasuale(String docenteAssegnato);

}
