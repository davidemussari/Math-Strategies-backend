package tesi.repository;

import java.sql.Timestamp;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import tesi.dataModel.PrimarySvolgimentiDaApprovare;
import tesi.dataModel.StoricoEserciziSvoltiStudenti;

public interface StoricoEserciziSvoltiStudentiRepository extends
	CrudRepository<StoricoEserciziSvoltiStudenti, PrimarySvolgimentiDaApprovare>{

	@Query(value = "SELECT * FROM storico_esercizi_svolti_studenti WHERE id_studente = ?1", nativeQuery = true)
	StoricoEserciziSvoltiStudenti[] findByIdStudente(int idStudente);

	@Query(value = "SELECT * FROM storico_esercizi_svolti_studenti WHERE id_studente = ?1 AND data = ?2", nativeQuery = true)
	Optional<StoricoEserciziSvoltiStudenti> findByIdStudenteData(int idStudente, Timestamp data);
}
