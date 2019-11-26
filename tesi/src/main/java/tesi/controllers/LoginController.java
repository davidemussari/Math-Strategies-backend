package tesi.controllers;

import java.util.Locale;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import tesi.dataModel.CodiciCasualiDocenti;
import tesi.dataModel.Utenti;
import tesi.repository.CodiciCasualiDocentiRepository;
import tesi.repository.UtentiRepository;
import tesi.service.RandomString;
import tesi.viewModels.IscrizioneViewModel;
import tesi.viewModels.UserViewModel;

@Controller
@RequestMapping
@CrossOrigin
public class LoginController {

	@Autowired
	private UtentiRepository utentiRepository;
	
	@Autowired
	private CodiciCasualiDocentiRepository codiciCasualiDocentiRepository;

	@PostMapping(path = "/login")
	public @ResponseBody UserViewModel login(HttpServletRequest request, @RequestBody Utenti utente) {
		Utenti ut = utentiRepository.findByUsernameAndPasswd(utente.getUsername(), utente.getPasswd());
		UserViewModel utView = new UserViewModel(ut);
		return utView;
	}
	
	@PostMapping(path = "/iscrizione")
	public @ResponseBody Boolean iscrizione(HttpServletRequest request, @RequestBody IscrizioneViewModel utente) {
		Utenti ut = utentiRepository.findByUsername(utente.username);
		if (ut != null)
			//esiste gia' username
			return false;
		else {
			if(utente.docenteAssegnato != null) {
				//nuovo studente
				CodiciCasualiDocenti docente = codiciCasualiDocentiRepository.findByCodiceCasuale(utente.docenteAssegnato);
				ut = new Utenti(utente, docente.getIdDocente());
				utentiRepository.save(ut);
				return true;
			}else {
				//nuovo docente
				ut = new Utenti(utente);
				ut = utentiRepository.save(ut);
				RandomString gen = new RandomString(5, ThreadLocalRandom.current());
				String codiceCasuale = gen.nextString();
				CodiciCasualiDocenti codDocente = new CodiciCasualiDocenti();
				codDocente.setCodiceCasuale(codiceCasuale);
				codDocente.setIdDocente(ut.getId());
				codiciCasualiDocentiRepository.save(codDocente);
				return true;
			}
		}
	}
	
    

}
