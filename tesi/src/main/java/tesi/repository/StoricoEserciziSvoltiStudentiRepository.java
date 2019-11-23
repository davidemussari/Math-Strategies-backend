package tesi.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import tesi.dataModel.StoricoEserciziSvoltiStudenti;

public interface StoricoEserciziSvoltiStudentiRepository extends
	CrudRepository<StoricoEserciziSvoltiStudenti, Long>{

	@Query(value = "SELECT * FROM storico_esercizi_svolti_studenti WHERE id_studente = ?1", nativeQuery = true)
	StoricoEserciziSvoltiStudenti[] findByIdStudente(int idStudente);
}
