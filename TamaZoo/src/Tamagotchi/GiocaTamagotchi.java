package Tamagotchi;

import tamaZoo.TamaZoo;
import util.mylib.*;
/**
 * Classe per far giocare un {@linkplain Tamagotchi}
 * 
 * @author Simone s.giacomini008@studenti.unibs.it
 */
public class GiocaTamagotchi {
	public static final byte MIN_STIMOLI = Tamagotchi.MIN_VALORI_INTERNI + 1;
	/** Voci del menu' */
	private static final String[] voci = { "Dai biscotti", "Dai carezze", "Statistiche",};
	/** <b>Menu'</b> */
	private final static MyMenu m = new MyMenu("Cosa Vuoi fare ?", voci);

	/** è un saluto stile Machintosh 1984 @author francesca */
	public final static String PRESENTAZIONE = "Ciao, io sono ";

	/**
	 * metodo che permette di usare i tamagotchi
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public static void usaTamagotchi() {
		byte valoreIn;
		byte scelta;
		do {
			if (GiocaTamagotchi.endGame())
			{System.out.println(String.format("%s %s", ("Addio, siamo tutti morti, lo zoo e' stato chiuso"),Tamagotchi.DIE));
			if (!GiocaTamagotchi.rePlay())
				break;}

			scelta = (byte) m.scegli();
			switch (scelta) {
			case 1:
				// prima si ottiene il numero e poi viene estratto
				valoreIn = (byte) EstrazioniCasuali.estraiIntero(MIN_STIMOLI, InputDati.leggiIntero(
						"Inserisci la quantita' di biscotti da dare ", MIN_STIMOLI, Tamagotchi.MAX_INPUT_STIMOLI));
				System.out.println("Biscotti estratti: " + valoreIn);
				System.out.println(TamaZoo.daiBiscotti(valoreIn));
				break;

			case 2:
				// prima si ottiene il numero e poi viene estratto
				valoreIn = (byte) EstrazioniCasuali.estraiIntero(MIN_STIMOLI, InputDati.leggiIntero(
						"Inserisci la quantita' di carezze da dare ", MIN_STIMOLI, Tamagotchi.MAX_INPUT_STIMOLI));
				System.out.println("Carezze estratte: " + valoreIn);
				System.out.println(TamaZoo.daiCarezze(valoreIn));

				break;

			case 3:
				System.out.println(TamaZoo.toStringCollections());
				break;

			default:
				break;
			}

		} while (scelta != 0);
	}

	/** Scopre se il gioco attuale del tamagotchi e' finito */

	public static boolean endGame() {
		if (TamaZoo.tuttiMorti())
			return true;
		return false;

	}

	/** Chiede se si vuole giocare una nuova partita */
	public static boolean rePlay() {
		if (InputDati.yesOrNo("Vuoi giocare ancora \u003f ")) {
			MainClass.main(null);
		}
		return false;
	}

	/**
	 * presentazione del Tamagotchi
	 *  @author francesca
	 */

	public static void  miPresento(Tamagotchi tam) {
		System.out.println(GiocaTamagotchi.PRESENTAZIONE + tam.getNome());
	}

}
