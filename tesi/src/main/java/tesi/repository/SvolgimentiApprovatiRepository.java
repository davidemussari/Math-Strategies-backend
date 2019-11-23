package tesi.repository;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import tesi.dataModel.SvolgimentiApprovati;

public interface SvolgimentiApprovatiRepository extends CrudRepository<SvolgimentiApprovati, String>{

	ArrayList<SvolgimentiApprovati> findByIdEsercizio(int id);

}
