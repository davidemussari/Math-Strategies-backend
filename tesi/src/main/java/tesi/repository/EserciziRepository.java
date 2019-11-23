package tesi.repository;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import tesi.dataModel.Esercizi;

public interface EserciziRepository extends CrudRepository<Esercizi, Integer>{
	
	ArrayList<Esercizi> findEserciziByTipologia(int tipologia);
	
	int countByTipologia(int tipologia);
	
}
