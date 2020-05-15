package Tamagotchi;

import util.mylib.*;

/**
 * classe Main
 * 
 * @author Simone Giacomini s.giacomini008@studenti.unibs.it
 */

public class MainClass {

	public static final String CREAZIONE_TAMA_PERSONALIZ = String.format(
			"Vuoi creare il tuo %s con valori consigliati (%c) oppure a mano (%c) \u003f ",
			Tamagotchi.class.getSimpleName(), InputDati.RISPOSTA_SI, InputDati.RISPOSTA_NO);
	
	public final static String SALUTO = "Ciao, questo programma ti permette di avere un  "
			+ Tamagotchi.class.getSimpleName() + " tutto tuo ;-)";
	public final static String ARRIVEDERCI = "ARRIVEDERCI, TORNA A GIOCARE ";

	public static void main(String[] args) {

		Tamagotchi tam = null;
		System.out.println(Tamagotchi.BIG_TAMAGOTCHI + System.lineSeparator());
		System.out.println(SALUTO);
		if (InputDati.yesOrNo(CREAZIONE_TAMA_PERSONALIZ)) 
			tam = UtilTamagotchi.creaTamagotchiReccomed();
		else 
			tam = UtilTamagotchi.creaTamagotchi();
		GiocaTamagotchi.miPresento(tam);
		GiocaTamagotchi.usaTamagotchi(tam);
		System.out.println(ARRIVEDERCI);
		// questo system.exit e' qui in modo da non far visualizzare piu' volte l'ultima
		// scritta "ARRIVEDERCI"
		System.exit(0);
	}

}
