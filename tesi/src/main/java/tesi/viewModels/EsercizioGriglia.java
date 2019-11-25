package tesi.viewModels;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Optional;

import lombok.AllArgsConstructor;
import lombok.Data;
import tesi.dataModel.StoricoEserciziSvoltiStudenti;
import tesi.dataModel.SvolgimentiDaApprovare;
import tesi.dataModel.Utenti;

@Data
@AllArgsConstructor
public class EsercizioGriglia {
	
	private Integer punteggio;
	private Timestamp data;
	private String passaggi;
	private String tipologia;
	private String nomeAlunno;
	private String cognomeAlunno;
	private String commenti;
	private Integer idStudente;
	private Integer idEsercizio;
    private String[] testoEsercizio;
    
	
	public EsercizioGriglia(SvolgimentiDaApprovare svolgimento, String tip, Optional<Utenti> utente ) {
		this.punteggio = null;
		this.data = svolgimento.getPrimary().getData();
		this.passaggi = svolgimento.getPassaggi();
		this.tipologia = tip;
		this.nomeAlunno = utente.get().getNome();
		this.cognomeAlunno = utente.get().getCognome();
		this.commenti = null;
		this.idStudente = svolgimento.getPrimary().getIdStudente();
		this.idEsercizio = svolgimento.getIdEsercizio();
		this.testoEsercizio = null;
	}

	public EsercizioGriglia(StoricoEserciziSvoltiStudenti esSvolto, String tip, Optional<Utenti> utente) {
		this.punteggio = esSvolto.getPunteggio();
		this.data = esSvolto.getPrimary().getData();
		this.passaggi = esSvolto.getPassaggi();
		this.tipologia = tip;
		this.nomeAlunno = utente.get().getNome();
		this.cognomeAlunno = utente.get().getCognome();
		this.commenti = esSvolto.getCommenti();
		this.idStudente = esSvolto.getPrimary().getIdStudente();
		this.idEsercizio = esSvolto.getidEsercizio();
		this.testoEsercizio = null;
	}

	public EsercizioGriglia() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
