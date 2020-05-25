package tamaZoo;

import java.util.ArrayList;
import java.util.Collection;

import Tamagotchi.Tamagotchi;
import util.mylib.BelleStringhe;

/**
 * Classe astratta che, non instanziabile che identifica una collezione di
 * {@linkplain Tamagotchi}
 * 
 * @author Simone Giacomini & Francesca Gambi
 */
public abstract class TamaZoo {
/**{@linkplain String} che riporta il nome del titolo del progetto
 * @author Simone*/
	public static final String BIG_TAMAZOO = ""
			+ "######                          #######   ###     ###\n"
			+ "# ## #                          ##   ##  ## ##   ## ##\n"
			+ "  ##     ####   ##  ##   ####   #   ##  ##   ## ##   ##\n"
			+ "  ##        ##  #######     ##     ##   ##   ## ##   ##\n"
			+ "  ##     #####  #######  #####    ##  # ##   ## ##   ##\n"
			+ "  ##    ##  ##  ## # ## ##  ##   ##  ##  ## ##   ## ## \n"
			+ " ####    ### ## ##   ##  ### ## #######   ###     ###   by Simone Giacomini & Francesca Gambi";

	/**
	 * Indica la quantita' di <tt>SPECIE</Tt> diverse di {@linkplain Tamagotchi} ci
	 * sono
	 */
	public static final byte QUANTITA_SPECIE = 3;

	private static ArrayList<Tamagotchi> zoo = new ArrayList<Tamagotchi>();

	/**
	 * <b>Metodo</B> che permette di dare dei {@code biscotti} ad ogni
	 * {@linkplain Tamagotchi} presente nello {@link #zoo}. <br>
	 * Esso ritorna un array di {@linkplain String} dove ogni elemento corrisponde
	 * ad un {@linkplain Tamagotchi}, con tutti gli errori che possono essersi
	 * verificati e le statistiche del <tt>Tamagotchi</Tt> aggiornate.<br>
	 * In piu' se un {@linkplain Tamagotchi} e' morto, viene automaticamente tolto
	 * dallo {@link #zoo}
	 * 
	 * @return {@linkplain String} []
	 * @see Tamagotchi#riceviBiscotti
	 * @param biscotti,
	 *            il numero di biscotti da dare a tutti i {@code tamagotchi}
	 * @author Simone
	 */
	public static String[] daiBiscotti(int biscotti) {
		String[] fine = new String[zoo.size()];
		for (int i = 0, j = 0; i < zoo.size(); j++, i++) {
			String daVisu = zoo.get(i).riceviBiscotti(biscotti) + zoo.get(i).toString();

			fine[j] = BelleStringhe.stampaStringaCorniceCentrato(daVisu, BelleStringhe.GRADO);
			if (zoo.get(i).sonoMorto()) {
				zoo.remove(zoo.get(i));
				i--;
			}
		}
		return fine;
	}

	/**
	 * <b>Metodo</B> che permette di dare delle {@code carezze} ad ogni
	 * {@linkplain Tamagotchi} presente nello {@link #zoo}. <br>
	 * Esso ritorna un array di {@linkplain String} dove ogni elemento corrisponde
	 * ad un {@linkplain Tamagotchi}, con tutti gli errori che possono essersi
	 * verificati e le statistiche del <tt>Tamagotchi</Tt> aggiornate.<br>
	 * In piu' se un {@linkplain Tamagotchi} e' morto, viene automaticamente tolto
	 * dallo {@link #zoo}
	 * 
	 * @return {@linkplain String} []
	 * @see Tamagotchi#riceviCarezze
	 * @param carezze,
	 *            il numero di carezze da dare a tutti i {@code tamagotchi}
	 * @author Simone
	 */
	public static String[] daiCarezze(int carezze) {
		String[] fine = new String[zoo.size()];
		for (int i = 0, j = 0; i < zoo.size(); i++, j++) {
			String daVisu = zoo.get(i).riceviCarezze(carezze) + zoo.get(i).toString();
			fine[j] = (BelleStringhe.stampaStringaCorniceCentrato(daVisu, BelleStringhe.GRADO));
			if (zoo.get(i).sonoMorto()) {
				zoo.remove(zoo.get(i));
				i--;
			}
		}
		return fine;
	}

	/**
	 * <b>Metodo</B> che costruisce un array di {@linkplain String} dove ogni
	 * elemento ha le <tt>informazioni</tt> su ogni {@linkplain Tamagotchi} presente
	 * nello {@link #zoo}
	 * 
	 * @return {@linkplain String}[]
	 * @see Tamagotchi#toString()
	 * @author Simone
	 */
	public static String[] visualizzaZoo() {
		String[] fine = new String[zoo.size()];
		int i = 0;
		for (Tamagotchi t : zoo) {
			fine[i] = t.toString();
			i++;
		}
		return fine;
	}

	/**
	 * <b>Metodo</B> che elenca componenti dello {@linkplain #zoo} senza svelare
	 * direttamente i parametri tamamgotchi
	 * 
	 * @return {@linkplain String[]}
	 * @author Frncesca, edited by Simone
	 */
	public static String[] visualizzaMyZooNoParam() {
		String[] eccoLoZoo = new String[zoo.size()];

		for (int i = 0; i < zoo.size(); i++) {
			Tamagotchi daVisu = zoo.get(i);
			eccoLoZoo[i] = String.format(
					"Il tamagotchi n%c %d, %nche appartiene alla Specie %s, %nlo hai chiamato %s, il quale%s%n",
					BelleStringhe.GRADO, i + 1, daVisu.getTipo(), daVisu.getNome(), daVisu.umore());
		}
		return eccoLoZoo;
	}

	/**
	 * <b>Metodo</b> che descrive lo {@link #zoo} e la quantita' di
	 * {@linkplain Tamagotchi} presenti
	 * 
	 * @return un {@linkplain String}
	 * @author Simone
	 */
	public static String toStringa() {
		return String.format("Nello zoo ci sono %d Tamagotchi", zoo.size());
	}

	/**
	 * <b>Metodo</b> che descrive lo {@link #zoo} e tutti i suoi abitanti, <b>ma
	 * senza specificarne la specie o le loro statistiche</b>
	 * 
	 * @return una {@linkplain String} che descrive l'intero zoo, con dei separatori
	 *         da tra di loro ({@link #SEPARATORE})
	 * @author Francesca, edited by Simone
	 */
	public static String toStringMyZooNoParam() {
		StringBuilder fine = new StringBuilder(toStringa());
		String[] collection = visualizzaMyZooNoParam();
		if (collection != null && collection.length > 0) {
			fine.append("\nContiene:\n");
			for (int i = 0; i < collection.length; i++) {
				String daVisu = collection[i];
				fine.append(BelleStringhe.stampaStringaCorniceCentrato(daVisu, BelleStringhe.GRADO));
			}
		} else
			fine.append("Lo zoo e' vuoto");

		return fine.toString();
	}

	/**
	 * <b>Metodo</b> che descrive lo {@link #zoo} e tutti i suoi abitanti
	 * 
	 * @return una {@linkplain String} che descrive l'intero zoo, con dei separatori
	 *         da tra di loro ({@link #SEPARATORE})
	 * @author Francesca, edited by Simone
	 */
	public static String toStringMyZoo() {
		StringBuilder fine = new StringBuilder(toStringa());
		String[] collection = visualizzaZoo();
		if (collection != null && collection.length > 0) {
			fine.append("\nContiene:\n");
			for (int i = 0; i < collection.length; i++) {
				String daVisu = (String.format("%d%c Tamagotchi%n", i + 1, BelleStringhe.GRADO)) + collection[i];
				fine.append(BelleStringhe.stampaStringaCorniceCentrato(daVisu, BelleStringhe.GRADO));

			}
		} else
			fine.append("Lo zoo e' vuoto");

		return fine.toString();
	}

	/**
	 * @return {@code true}, se lo {@link #zoo} e' vuoto, {@code false} altrimenti
	 * @author Simone
	 */
	public static boolean zooVuoto() {
		return zoo.isEmpty();
	}

	/**
	 * @return <tt>true </tt>se il nome del {@linkplain Tamagotchi} passato e' gia'
	 *         utilizzato in {@link #zoo} da altri {@linkplain Tamagotchi},
	 *         <tt>false</tt> altrimenti
	 * @param tam,
	 *            il {@linkplain Tamagotchi} da confrontare
	 * @author Simone
	 */
	public static boolean tamaNameIsUsed(Tamagotchi tam) {
		for (Tamagotchi tamagotchi : zoo) {
			if (tamagotchi.equals(tam))
				return true;
		}
		return false;
	}

	/**
	 * @return <tt>true </tt>se la {@linkplain String} passata, e' uguale (ignorando
	 *         le maiuscole {@linkplain String#equalsIgnoreCase}) a un nome di un
	 *         {@linkplain Tamagotchi} presente in {@link #zoo}, <tt>false</tt>
	 *         altrimenti
	 * @param nomeTam,
	 *            il nome del {@linkplain Tamagotchi} da confrontare
	 * @author Simone
	 */
	public static boolean tamaNameIsUsed(String nomeTam) {
		for (Tamagotchi tamagotchi : zoo) {
			if (tamagotchi.getNome().equalsIgnoreCase(nomeTam))
				return true;
		}
		return false;
	}

	/**
	 * <b>Metodo</b> che aggiunge un qualsiasi {@linkplain Tamagotchi} di qualsiasi
	 * <tt>specie</tt> all {@link #zoo}
	 * 
	 * @param tam,
	 *            e' il {@linkplain Tamagotchi} da aggiungere alla collezione
	 * @author Simone
	 */
	public static boolean aggiungiTamagotchi(Tamagotchi tam) {
		if (tamaNameIsUsed(tam))
			throw new IllegalArgumentException("Esiste gia' un Tamagotchi con lo stesso nome");
		return zoo.add(tam);
	}

}
