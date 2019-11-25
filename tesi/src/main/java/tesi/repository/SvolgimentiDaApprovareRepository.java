package tesi.repository;

import java.sql.Timestamp;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import tesi.dataModel.PrimarySvolgimentiDaApprovare;
import tesi.dataModel.SvolgimentiDaApprovare;

public interface SvolgimentiDaApprovareRepository
	extends CrudRepository<SvolgimentiDaApprovare, PrimarySvolgimentiDaApprovare> {

	@Query(value = "SELECT * FROM svolgimenti_da_approvare WHERE id_studente = ?1", nativeQuery = true)
	SvolgimentiDaApprovare[] findByIdStudente(int idStudente);
	
	@Query(value = "SELECT * FROM svolgimenti_da_approvare WHERE id_studente = ?1 AND data = ?2", nativeQuery = true)
	Optional<SvolgimentiDaApprovare> findByIdStudenteData(int idStudente, Timestamp data);
}
