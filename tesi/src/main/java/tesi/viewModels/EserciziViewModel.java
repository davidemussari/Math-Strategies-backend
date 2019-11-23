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
	private int idEsercizio;
	
	public EserciziViewModel(Esercizi es, ArrayList<String> sol) {
		this.tipologia = es.getTipologia();
		this.testoEsercizio = es.getTestoEsercizio();
		this.soluzioni = sol;
		this.idEsercizio = es.getId();
	}

}
