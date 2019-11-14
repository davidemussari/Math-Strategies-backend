package tesi.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import tesi.dataModel.Utenti;
import tesi.repository.UtentiRepository;

@Controller
@RequestMapping(value = "/utenti", method = { RequestMethod.GET })
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
	
	@Autowired
	private UtentiRepository utentiRepository;
	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<Utenti> getAllUsers() {
		// This returns a JSON or XML with the users
		return utentiRepository.findAll();
	}
}
