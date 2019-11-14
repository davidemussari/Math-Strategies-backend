package tesi.variabiliGlobali;

public class VariabiliGlobali {
	
	public static String tipologiaAddizione = "somma";
	public static String tipologiasottrazione = "sottrazione";
	public static String tipologiamoltiplicazione = "moltiplicazione";
	public static String tipologiadivisione = "divisione";
	public static String sceltaTipologia(String tipologia){
		switch (tipologia) {
		case "addizione":
			return VariabiliGlobali.tipologiaAddizione;
		case "sottrazione":
			return VariabiliGlobali.tipologiasottrazione;
		case "moltiplicazione":
			return VariabiliGlobali.tipologiamoltiplicazione;
		case "divisione":
			return VariabiliGlobali.tipologiadivisione;
		default:
			return null;
		}
	}
	

}
