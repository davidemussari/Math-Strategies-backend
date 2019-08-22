package tesi.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import tesi.db.MySQLAccess;

@Controller
public class HomeController {
	MySQLAccess lettura = new MySQLAccess();
	
	@RequestMapping("/")
	public String index(Model model)
	{
		try {
			lettura.readDataBase();
		} catch (Exception e) {
			System.out.println("Non funziona...");
			e.printStackTrace();
		}
		return "index";
	}
}
