package tesi.viewModels;

import lombok.AllArgsConstructor;
import lombok.Data;
import tesi.dataModel.Esercizi;

@Data
@AllArgsConstructor
public class EserciziViewModel {
	
	private String testoEsercizio;
	private int tipologia;
	private int id;
	
	public EserciziViewModel(Esercizi es) {
		this.id = es.getId();
		this.tipologia = es.getTipologia();
		this.testoEsercizio = es.getTestoEsercizio();
	}

}
