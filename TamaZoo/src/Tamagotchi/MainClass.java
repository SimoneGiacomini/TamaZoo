package Tamagotchi;


import tamaZoo.TamaZoo;
import util.mylib.*;

/**
 * classe Main
 * 
 * @author Simone Giacomini s.giacomini008@studenti.unibs.it
 */

public class MainClass {

	
	private static final String PRESENTAZIONI_ZOO = "vuoi conoscere la tua squadra?";
	private static final String POPOLAZIONE_ZOO = "Inserisci il numero di componenti della popolazione del tuo zoo: ";
	public final static String ARRIVEDERCI = "ARRIVEDERCI, TORNA A GIOCARE ";
	public static final String CREAZIONE_ZOO_RECOMMENDED = String.format(
			"Vuoi comporre la tua squadra %s con valori consigliati (%c) oppure a mano (%c) \u003f ",
			TamaZoo.class.getSimpleName(), InputDati.RISPOSTA_SI, InputDati.RISPOSTA_NO);
	
	public final static String SALUTO = "Ciao, questo programma ti permette di avere un  "
			+ TamaZoo.class.getSimpleName() + " tutto tuo ;-)";
	
	public static void main(String[] args) {
        TamaZoo myZoo = new Tamagotchi();
		System.out.println(SALUTO);
		System.out.println(TamaTitolo.BIG_TAMAGOTCHI + System.lineSeparator());
		if (InputDati.yesOrNo(CREAZIONE_ZOO_RECOMMENDED)) 
		UtilTamagotchi.creaZoo(InputDati.leggiInteroPositivo(POPOLAZIONE_ZOO));
		else
		UtilTamagotchi.popolaLoZoo(InputDati.leggiInteroPositivo(POPOLAZIONE_ZOO));
		System.out.println(TamaZoo.toStringa());
		if (InputDati.yesOrNo(PRESENTAZIONI_ZOO)) 
	    System.out.println(TamaZoo.visualizzaMyZoo());
	    else
	    System.out.println("gioca casualemente");
	    GiocaTamagotchi.usaTamagotchi();
		System.out.println(ARRIVEDERCI);
		
		System.exit(0);
	}

	

}


