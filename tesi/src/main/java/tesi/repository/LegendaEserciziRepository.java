package tesi.repository;

import org.springframework.data.repository.CrudRepository;

import tesi.dataModel.LegendaEsercizi;

public interface LegendaEserciziRepository extends CrudRepository<LegendaEsercizi, String>{

	LegendaEsercizi findLegendaEserciziByDescrizione(String descrizione);
}
