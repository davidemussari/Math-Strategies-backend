package tesi.viewModels;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import tesi.dataModel.Esercizi;

@Data
@AllArgsConstructor
public class EserciziViewModel {
	
	private String testoEsercizio;
	private int tipologia;
	private int id;
	private ArrayList<String> soluzioni;
	
	public EserciziViewModel(Esercizi es, ArrayList<String> sol) {
		this.id = es.getId();
		this.tipologia = es.getTipologia();
		this.testoEsercizio = es.getTestoEsercizio();
		this.soluzioni = sol;
	}

}
