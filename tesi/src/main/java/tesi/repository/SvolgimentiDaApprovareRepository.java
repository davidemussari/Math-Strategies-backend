package tesi.repository;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import tesi.dataModel.PrimarySvolgimentiDaApprovare;
import tesi.dataModel.SvolgimentiDaApprovare;

public interface SvolgimentiDaApprovareRepository
	extends CrudRepository<SvolgimentiDaApprovare, PrimarySvolgimentiDaApprovare> {

	@Query(value = "SELECT * FROM svolgimenti_da_approvare WHERE id_studente = ?1", nativeQuery = true)
	SvolgimentiDaApprovare[] findByIdStudente(int idStudente);
}
