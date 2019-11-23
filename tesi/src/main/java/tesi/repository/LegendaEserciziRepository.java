package tesi.repository;

import org.springframework.data.repository.CrudRepository;

import tesi.dataModel.LegendaEsercizi;

public interface LegendaEserciziRepository extends CrudRepository<LegendaEsercizi, Integer>{

	LegendaEsercizi findLegendaEserciziByDescrizione(String descrizione);

	LegendaEsercizi findById(int tipologia);
}
