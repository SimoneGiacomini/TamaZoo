package Tamagotchi;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import tamaZoo.TamaGordo;
import tamaZoo.TamaTriste;
import tamaZoo.TamaZoo;
import util.mylib.*;

/**
 * classe utile per interfacciarsi al {@linkplain Tamagotchi}
 * 
 * @author Simone Giacomini s.giacomini008@studenti.unibs.it
 */
public class UtilTamagotchi {
	private static final String RIPROVA = "Riprova";

	public static final byte ERR_TOO_LOW = -1;

	public static final byte ERR_TOO_HIGH = +1;

	public static final byte OK = 0;

	// ERRORI
	public static final String ERR_NUM_INSERT_TOO_HIGHT = "ATTENZIONE, IL NUMERO INSERITO \u00e8 TROPPO ALTO, MASSIMO ";

	public static final String ERR_NUM_INSERT_TOO_LOW = "ATTENZIONE, IL NUMERO INSERITO \u00e8 TROPPO BASSO, MINIMO ";

	/**
	 * Costante {@linkplain String} utilizzata per l'acquisizione/modifica del nome
	 * del {@linkplain Tamagotchi}
	 */
	private static final String NEW_NOME_TAMAGOTCHI = System.lineSeparator() + "Inserisci il nome del tuo "
			+ "Tamagotchi ";

	/**
	 * Costante {@linkplain String} utilizzata per l'acquisizione/modifica della
	 * Sazieta del {@linkplain Tamagotchi}
	 */
	private static final String NEW_SAZIETA_TAMAGOTCHI = System.lineSeparator() + "Inserisci la " + Tamagotchi.SAZIETA
			+ " del tuo Tamagotchi ";
	/**
	 * Costante {@linkplain String} utilizzata per l'acquisizione/modifica della
	 * affetto del {@linkplain Tamagotchi}
	 */
	private static final String NEW_AFFETTO_TAMAGOTCHI = System.lineSeparator() + "Inserisci l'" + Tamagotchi.AFFETTO
			+ " del tuo Tamagotchi ";

	private static Tamagotchi zoo;

	/**
	 * Metodo che permette di creare un {@link TamaTriste}
	 * 
	 * 
	 * @return un oggetto {@linkplain TamaTriste} con valori di <b>affetto</b> e di
	 *         <b>sazieta</b> a {@linkplain Tamagotchi#VAL_INIZ_RECOMMEND}
	 * @since 2020/5/16
	 */
	public static TamaTriste creaTamaTristeReccomed() {
		return new TamaTriste(InputDati.leggiStringaNonVuota(NEW_NOME_TAMAGOTCHI));
	}

	/**
	 * Metodo che permette di creare un {@link TamaGordo}
	 * 
	 * 
	 * @return un oggetto {@linkplain TamaGordo} con il valore di <b>sazieta'</b> a
	 *         {@linkplain Tamagotchi#VAL_INIZ_RECOMMEND}, mentre il valore di
	 *         <b>affetto</b> a {@linkplain Tamagotchi#MAX_VALORI_INTERNI}
	 * @since 2020/5/16
	 */
	public static TamaGordo creaTamaGordoReccomed() {
		return new TamaGordo(InputDati.leggiStringaNonVuota(NEW_NOME_TAMAGOTCHI));
	}

	/**
	 * Metodo che permette di creare un {@link TamaTriste}
	 * 
	 * @param
	 * @return un oggetto {@linkplain TamaTriste} con valori di <b>affetto</b> e di
	 *         <b>sazieta</b> inseriti dall'utente
	 * @since 2020/5/16
	 */
	public static TamaTriste creaTamaTriste() {

		float affetto = InputDati.leggiFloat(NEW_AFFETTO_TAMAGOTCHI, Tamagotchi.MAX_INPUT_STIMOLI,
				Tamagotchi.MAX_VALORI_INTERNI);
		float sazieta = InputDati.leggiFloat(NEW_SAZIETA_TAMAGOTCHI, Tamagotchi.MAX_INPUT_STIMOLI,
				Tamagotchi.MAX_VALORI_INTERNI);
		String nome = InputDati.leggiStringaNonVuota(NEW_NOME_TAMAGOTCHI);

		return new TamaTriste(nome, affetto, sazieta);
	}

	public static Tamagotchi creaTamagotchiReccomed() {
		String nome = InputDati.leggiStringaNonVuota(NEW_NOME_TAMAGOTCHI);
		return new Tamagotchi(nome);
	}

	/**
	 * Metodo che permette di modificare il <b>nome</b> di un {@link Tamagotchi}
	 * 
	 * @param
	 * @since 2020/4/14
	 */
	public static void modificaNome(Tamagotchi tam) {
		tam.setNome(InputDati.leggiStringaNonVuota(NEW_NOME_TAMAGOTCHI));
	}

	/**
	 * Metodo che permette di creare un {@linkplain Set} di {@link Tamagotchi}
	 * 
	 * @param nTamagotchi
	 *            , sono la quantita' di {@linkplain Tamagotchi} da creare
	 * @return un @{@linkplain Set} di {@linkplain TamaTriste} o
	 *         {@linkplain TamaGordo}, con valori di <b>affetto</b> e di
	 *         <b>sazieta</b> predifiniti
	 * @since 2020/5/16
	 */
	
	
		
	
	
	public String visualizzaMyZoo(TamaZoo ilmiozoo) {
		return Tamagotchi.toStringa();
	}
	
	
	
	
	
	public static void creaZoo(int nTamagotchi) {
		for (int i = 0; i < nTamagotchi; i++) {
			String nomeTam = null;
			do {
				nomeTam = InputDati.leggiStringaNonVuota(NEW_NOME_TAMAGOTCHI);
				if (TamaZoo.tamaNameIsUsed(nomeTam))
					System.out.println("Nome gia' in uso");
				else {
					System.out.println("Tamagotchi n " + (i + 1) + " inserito con successo");
					nomeTam=nomeTam.toUpperCase();
					break;
				}
			} while (true);
			switch (EstrazioniCasuali.estraiIntero(1, TamaZoo.QUANTITA_SPECIE)) {

			case 1: {
				TamaZoo.aggiungiTamagotchi(new Tamagotchi(nomeTam));
				break;
			}
			case 2: {
				TamaZoo.aggiungiTamagotchi(new TamaTriste(nomeTam));
				break;

			}
			case 3:
				TamaZoo.aggiungiTamagotchi(new TamaGordo(nomeTam));
				break;
			}
		}

	}

	/**
	 * controlla se <b>valore </b>e' all'interno del range
	 * {@code (numeroInput<massimo && numeroInput>minimo)}
	 * 
	 * @return
	 *         <p>
	 *         <b>{@link #ERR_TOO_HIGH}</b> se il numero passato e' maggiore del
	 *         massimo
	 *         </p>
	 *         <p>
	 *         <b>{@link #ERR_TOO_LOW}</b> se il numero passato e' minore del minimo
	 *         <p>
	 *         <b>{@link #OK}</b> se il numero e' all'interno del range
	 *         </p>
	 */
	public static int inRange(float valore, int massimo, int minimo) {
		// primo check, se il numero passato e' maggiore di massimo, viene ritornato +1
		if (Math.max(valore, (float) massimo) != (float) massimo)// valore > (float) massimo
			return ERR_TOO_HIGH;

		// secondo check se il numero passato e' sotto minimo, viene ritornato -1
		if (Math.min(valore, (float) minimo) != (float) minimo)// valore < (float) minimo
			return ERR_TOO_LOW;

		return OK;
	}

	/**
	 * controlla se <b>valore </b>e' all'interno del range
	 * {@code (numeroInput<massimo && numeroInput>minimo)}
	 * 
	 * @return
	 *         <p>
	 *         <b>{@link #ERR_TOO_HIGH}</b> se il numero passato e' maggiore del
	 *         massimo
	 *         </p>
	 *         <p>
	 *         <b>{@link #ERR_TOO_LOW}</b> se il numero passato e' minore del minimo
	 *         <p>
	 *         <b>{@link #OK}</b> se il numero e' all'interno del range
	 *         </p>
	 */
	public static int inRange(double valore, int massimo, int minimo) {
		// primo check, se il numero passato e' maggiore di massimo, viene ritornato +1
		if (Math.max(valore, (double) massimo) != (double) massimo)// valore > (float) massimo
			return ERR_TOO_HIGH;

		// secondo check se il numero passato e' sotto minimo, viene ritornato -1
		if (Math.min(valore, (double) minimo) != (double) minimo)// valore < (float) minimo
			return ERR_TOO_LOW;

		return OK;
	}

	/**
	 * controlla se il <b>valore </b>e' all'interno di un range
	 * 
	 * @see UtilTamagotchi#inRange
	 * 
	 * @throws IllegalArgumentException
	 *             se il numero passato e' maggiore del massimo
	 * @throws IllegalArgumentException
	 *             se il numero passato e' minore del minimo
	 */
	public static void checkErrInBuild(float valore, int massimo, int minimo) {
		switch (inRange(valore, massimo, minimo)) {
		case ERR_TOO_HIGH:
			throw new IllegalArgumentException(ERR_NUM_INSERT_TOO_HIGHT + massimo);
		case ERR_TOO_LOW:
			throw new IllegalArgumentException(ERR_NUM_INSERT_TOO_LOW + minimo);
		default:
			break;
		}
	}

	/**
	 * Metodo che calcola la percentuale
	 * <p>
	 * <b>PER ESEMPIO</b> se inserisco <b>valorePercentuale</b>=10 e come
	 * <b>massimoValore</b>=33 il valore ritornato e' 3.3
	 * </p>
	 * 
	 * @param
	 * @since 2020/4/14
	 */
	public static float percentuale(float valoreDiPercentuale, float massimoValore) {
		return (float) (massimoValore * valoreDiPercentuale / 100.0);
	}

	/**
	 * incrementa di "numeroVolte" il valore "numeroIniziale" per la percentuale
	 * "percentuale"
	 * 
	 * @param
	 * @since 2020/4/20
	 */

	public static double incrementoInPercentuale(float numeroIniziale, int numeroVolte, float percentuale) {
		for (byte i = 0; i < numeroVolte; i++) {
			numeroIniziale = (numeroIniziale + percentuale(percentuale, numeroIniziale));
		}
		return numeroIniziale;
	}

	public static void popolaLoZoo(int nPopolazione) {
		for (int i = 0; i < nPopolazione; i++) {
			String nomeTam = null;
			do {
				
				popolaZoo();
				
				if (TamaZoo.tamaNameIsUsed(nomeTam))
					System.out.println("Nome gia' in uso");
				else {
					System.out.println("Tamagotchi n " + (i + 1) + " inserito con successo");
					nomeTam=nomeTam.toUpperCase();
					break;
				}
			} while (true);
			
		}
	}
		

	
	public static void popolaZoo() {
    System.out.println("componi la tua squadra come preferisci:");
		  int scelta = 0;
	   //TamaZoo zoo = new Tamagotchi();
		 String messaggio = "1.inserisci tamagotchi\n" + 
							"2.inserisci tama di specie TamaTriste\n" + 
							"3.inserisci tama di specie TamaGordo \n" +
							"0.esci\n";
		do {
			System.out.println();
			scelta = InputDati.leggiInteroNonNegativo(messaggio);
			switch ( scelta ) {
				case 1:
					TamaZoo.aggiungiTamagotchi(creaTamagotchiReccomed());
					
					break;
				case 2:
					TamaZoo.aggiungiTamagotchi(creaTamaTristeReccomed());
					break;
				case 3:
					TamaZoo.aggiungiTamagotchi(creaTamaGordoReccomed());
					break;
			}
		} while ( scelta != 0 );
	 
	 }
	
	
	
	public static Tamagotchi creaTamagotchi() {

		Tamagotchi tam = new Tamagotchi(InputDati.leggiStringaNonVuota(NEW_NOME_TAMAGOTCHI),
				InputDati.leggiFloat(NEW_AFFETTO_TAMAGOTCHI, Tamagotchi.MAX_INPUT_STIMOLI,
						Tamagotchi.MAX_VALORI_INTERNI),
				InputDati.leggiFloat(NEW_SAZIETA_TAMAGOTCHI, Tamagotchi.MAX_INPUT_STIMOLI,
						Tamagotchi.MAX_VALORI_INTERNI));
		return tam;
	}

}
