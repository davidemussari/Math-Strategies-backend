package tesi.controllers;

import java.util.ArrayList;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import tesi.dataModel.Esercizi;
import tesi.dataModel.LegendaEsercizi;
import tesi.dataModel.PrimaryStoricoEserciziSvoltiStudenti;
import tesi.dataModel.PrimarySvolgimentiDaApprovare;
import tesi.dataModel.StoricoEserciziSvoltiStudenti;
import tesi.dataModel.SvolgimentiApprovati;
import tesi.dataModel.SvolgimentiDaApprovare;
import tesi.dataModel.Utenti;
import tesi.repository.EserciziRepository;
import tesi.repository.LegendaEserciziRepository;
import tesi.repository.StoricoEserciziSvoltiStudentiRepository;
import tesi.repository.SvolgimentiApprovatiRepository;
import tesi.repository.SvolgimentiDaApprovareRepository;
import tesi.repository.UtentiRepository;
import tesi.variabiliGlobali.VariabiliGlobali;
import tesi.viewModels.EserciziViewModel;
import tesi.viewModels.EsercizioGriglia;

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
	
	@Autowired
	private SvolgimentiDaApprovareRepository svolgimentiDaApprovareRepository;
	
	@Autowired
	private StoricoEserciziSvoltiStudentiRepository storicoEserciziSvoltiStudentiRepository;
	
	@Autowired
	private UtentiRepository utentiRepository;
	
	
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
	
	@PutMapping(path="/putSvolgimentoDaApprovare", produces = "application/json;charset=UTF-8")
	public @ResponseBody Boolean putEsercizioSconosciuto(HttpServletRequest request, @RequestBody SvolgimentiDaApprovare es) {
		return svolgimentiDaApprovareRepository.save(es) != null;
	}
	
	@PutMapping(path="/putEsercizioSvoltoStudenti", produces = "application/json;charset=UTF-8")
	public @ResponseBody Boolean putEsercizioSvolto(HttpServletRequest request, @RequestBody StoricoEserciziSvoltiStudenti es) {
		return storicoEserciziSvoltiStudentiRepository.save(es) != null;
	}
	
	@PostMapping(path="/eserciziSvolti")
	public @ResponseBody ArrayList<EsercizioGriglia> eserciziSvolti(HttpServletRequest request, @RequestBody Utenti ut) {
		Optional<Utenti> utente = utentiRepository.findById(ut.getId());
		ArrayList<EsercizioGriglia> elencoEsercizi = new ArrayList<>();
		if(utente.get().getDocenteAssegnato() > 0) {
			//caso studente
			elencoEsercizi = generaArrayEserciziGriglia(utente);
		}else {
			ArrayList<Optional<Utenti>> alunni = utentiRepository.findByDocenteAssegnato(utente.get().getId());
			for(Optional<Utenti> alunno: alunni)
				elencoEsercizi = generaArrayEserciziGriglia(alunno);
		}
		return elencoEsercizi;
	}
	
	public ArrayList<EsercizioGriglia> generaArrayEserciziGriglia(Optional<Utenti> utente) {
		SvolgimentiDaApprovare[] esDaApprovare;
		StoricoEserciziSvoltiStudenti[] esDaStorico;
		ArrayList<EsercizioGriglia> elencoEsercizi = new ArrayList<>();
		esDaApprovare = svolgimentiDaApprovareRepository.findByIdStudente(utente.get().getId());
		for (SvolgimentiDaApprovare esSvolto : esDaApprovare) {
			Optional<Esercizi> es = eserciziRepository.findById((Integer) esSvolto.getIdEsercizio());
			String tipologia = legendaEserciziRepository.findById(es.get().getTipologia()).getDescrizione();
			EsercizioGriglia esGriglia = new EsercizioGriglia(esSvolto, tipologia, utente);
			elencoEsercizi.add(esGriglia);
		}
		esDaStorico = storicoEserciziSvoltiStudentiRepository.findByIdStudente(utente.get().getId());
		for (StoricoEserciziSvoltiStudenti esSvolto : esDaStorico) {
			Optional<Esercizi> es = eserciziRepository.findById((Integer) esSvolto.getidEsercizio());
			String tipologia = legendaEserciziRepository.findById(es.get().getTipologia()).getDescrizione();
			EsercizioGriglia esGriglia = new EsercizioGriglia(esSvolto, tipologia, utente);
			elencoEsercizi.add(esGriglia);
		}
		return elencoEsercizi;
	}
}
