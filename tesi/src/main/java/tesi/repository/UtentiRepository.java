package tesi.repository;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.Nullable;

import tesi.dataModel.Utenti;

public interface UtentiRepository extends CrudRepository<Utenti, Integer> {

	@Nullable
	Utenti findByUsernameAndPasswd(String username, String passwd);

	ArrayList<Optional<Utenti>> findByDocenteAssegnato(int docenteAssegnato);

	Utenti findByUsername(String username);
}