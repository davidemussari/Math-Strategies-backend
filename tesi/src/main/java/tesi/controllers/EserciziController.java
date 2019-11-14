package tesi.controllers;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import tesi.dataModel.Esercizi;
import tesi.dataModel.LegendaEsercizi;
import tesi.repository.EserciziRepository;
import tesi.repository.LegendaEserciziRepository;
import tesi.variabiliGlobali.VariabiliGlobali;
import tesi.viewModels.EserciziViewModel;

@Controller
@RequestMapping
@CrossOrigin
public class EserciziController {

	@Autowired
	private EserciziRepository eserciziRepository;
	
	@Autowired
	private LegendaEserciziRepository legendaEserciziRepository;
	
	@PostMapping(path="/esercizioCasuale")
	public @ResponseBody EserciziViewModel getCasuale(HttpServletRequest request, @RequestBody String tipologia) {
		String tip = VariabiliGlobali.sceltaTipologia(tipologia);
		LegendaEsercizi legendaEsercizi = legendaEserciziRepository.findLegendaEserciziByDescrizione(tip);
		ArrayList<Esercizi> esTipologia = eserciziRepository.findEserciziByTipologia(legendaEsercizi.getId());
		int nTipologia = esTipologia.size();
		int randomNum = ThreadLocalRandom.current().nextInt(0, nTipologia);
		EserciziViewModel es = new EserciziViewModel(esTipologia.get(randomNum));
		return es;
	}
}
