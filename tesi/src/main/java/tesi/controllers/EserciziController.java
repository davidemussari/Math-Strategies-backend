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
import tesi.dataModel.SvolgimentiApprovati;
import tesi.repository.EserciziRepository;
import tesi.repository.LegendaEserciziRepository;
import tesi.repository.SvolgimentiApprovatiRepository;
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
	
	@Autowired
	private SvolgimentiApprovatiRepository svolgimentiApprovatiRepository;
	
	@PostMapping(path="/esercizioCasuale")
	public @ResponseBody EserciziViewModel getCasuale(HttpServletRequest request, @RequestBody String tipologia) {
		String tip = VariabiliGlobali.sceltaTipologia(tipologia);
		LegendaEsercizi legendaEsercizi = legendaEserciziRepository.findLegendaEserciziByDescrizione(tip);
		ArrayList<Esercizi> esTipologia = eserciziRepository.findEserciziByTipologia(legendaEsercizi.getId());
		int nTipologia = esTipologia.size();
		int randomNum = ThreadLocalRandom.current().nextInt(1, nTipologia);
		ArrayList<SvolgimentiApprovati> svolgimenti = svolgimentiApprovatiRepository.findByIdEsercizio(esTipologia.get(randomNum).getId());
		ArrayList<String> soluzioni = new ArrayList<String>();
		for (int i = 0; i < svolgimenti.size(); i++)
			soluzioni.add(svolgimenti.get(i).getPassaggi());
		EserciziViewModel es = new EserciziViewModel(esTipologia.get(randomNum),soluzioni);
		return es;
	}
}
