package tesi.controllers;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import tesi.dataModel.Utenti;
import tesi.repository.UtentiRepository;
import tesi.viewModels.UserViewModel;

@Controller
@RequestMapping
@CrossOrigin
public class Login {

	@Autowired
	private UtentiRepository utentiRepository;

	@PostMapping(path = "/login")
	public @ResponseBody UserViewModel login(HttpServletRequest request, @RequestBody Utenti utente) {
		Utenti ut = utentiRepository.findByUsernameAndPasswd(utente.getUsername(), utente.getPasswd());
		UserViewModel utView = new UserViewModel(ut);
		
		return utView;
	}

}
