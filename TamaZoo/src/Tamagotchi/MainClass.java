package Tamagotchi;


import util.mylib.*;

/**
 * classe Main
 * 
 * @author Simone Giacomini s.giacomini008@studenti.unibs.it
 */

public class MainClass {

	public final static String SALUTO = "Ciao, questo programma ti permette di avere un Tamagotchi tutto tuo ;-)";
	public final static String ARRIVEDERCI = "ARRIVEDERCI, TORNA A GIOCARE ";

	public static void main(String[] args) {

		System.out.println(SALUTO);
		UtilTamagotchi.creaZoo(InputDati.leggiInteroPositivo("Inserisci il numero di Tamagotchi da creare "));
		GiocaTamagotchi.usaTamagotchi();
		System.out.println(ARRIVEDERCI);
		// questo system.exit e' qui in modo da non far visualizzare piu' volte l'ultima
		// scritta "ARRIVEDERCI"
		System.exit(0);
	}

}
