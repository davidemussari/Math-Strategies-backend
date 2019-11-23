package tesi.viewModels;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

import lombok.AllArgsConstructor;
import lombok.Data;
import tesi.dataModel.Esercizi;
import tesi.dataModel.StoricoEserciziSvoltiStudenti;
import tesi.dataModel.SvolgimentiDaApprovare;

@Data
@AllArgsConstructor
public class EsercizioGrigliaStudente {
	
	private Integer punteggio;
	private Date data;
	private String passaggi;
	private String tipologia;
	
	public EsercizioGrigliaStudente(SvolgimentiDaApprovare svolgimento, String tip ) {
		this.punteggio = null;
		this.data = svolgimento.getPrimary().getData();
		this.passaggi = svolgimento.getPassaggi();
		this.tipologia = tip;
	}

	public EsercizioGrigliaStudente(StoricoEserciziSvoltiStudenti esSvolto, String tip) {
		this.punteggio = esSvolto.getPunteggio();
		this.data = esSvolto.getPrimary().getData();
		this.passaggi = esSvolto.getPassaggi();
		this.tipologia = tip;
	}
	

}
