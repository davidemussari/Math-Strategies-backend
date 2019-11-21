package tesi.repository;

import org.springframework.data.repository.CrudRepository;

import tesi.dataModel.SvolgimentiDaApprovare;

public interface SvolgimentiDaApprovareRepository
	extends CrudRepository<SvolgimentiDaApprovare, Long> {

	//SvolgimentiDaApprovare saveSvolgimentiDaApprovare(SvolgimentiDaApprovare es);
}
