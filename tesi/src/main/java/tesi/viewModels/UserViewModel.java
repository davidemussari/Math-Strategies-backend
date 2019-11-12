package tesi.viewModels;

import lombok.AllArgsConstructor;
import lombok.Data;
import tesi.dataModel.Utenti;

@Data
@AllArgsConstructor
public class UserViewModel {
	
	private String nome;
	private String cognome; 
	private String username;
	private int id;
	private String tipoUtente;
	
	public UserViewModel(Utenti ut) {
		this.nome = ut.getNome();
		this.cognome = ut.getCognome();
		this.username = ut.getUsername();
		this.id = ut.getId();
		this.tipoUtente = tipoUtente(ut);
	}

	private String tipoUtente(Utenti ut) {
		if(ut.getDocenteAssegnato() != 0)
			return "studente";
		else
			return "docente";
	}
	
	
}
