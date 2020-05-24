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

	public static final String SEPARATORE = "\n***********************\n";

	public static final String BIG_TAMAZOO = 
			  "######                          #######   ###     ###\n"
			+ "# ## #                          ##   ##  ## ##   ## ##\n"
			+ "  ##     ####   ##  ##   ####   #   ##  ##   ## ##   ##\n"
			+ "  ##        ##  #######     ##     ##   ##   ## ##   ##\n"
			+ "  ##     #####  #######  #####    ##  # ##   ## ##   ##\n"
			+ "  ##    ##  ##  ## # ## ##  ##   ##  ##  ## ##   ## ## \n"
			+ " ####    ### ## ##   ##  ### ## #######   ###     ###   by Simone Giacomini & Francesca Gambi";

	public static final byte QUANTITA_SPECIE = 3;

	private static ArrayList<Tamagotchi> zoo = new ArrayList<Tamagotchi>();

	public static void initZoo(Collection<Tamagotchi> zoo) {
		TamaZoo.zoo = new ArrayList<Tamagotchi>();
		TamaZoo.zoo.addAll(zoo);
	}

	public static String daiBiscotti(int biscotti) {
		StringBuilder fine = new StringBuilder();
		for (int i = 0; i < zoo.size(); i++) {
			fine.append(SEPARATORE);
			fine.append(zoo.get(i).riceviBiscotti(biscotti));
			fine.append(SEPARATORE);
			if (zoo.get(i).sonoMorto()) {
				zoo.remove(zoo.get(i));
				i--;
			}
		}
		return fine.toString();
	}

	public static String daiCarezze(int carezze) {
		StringBuilder fine = new StringBuilder();
		for (int i = 0; i < zoo.size(); i++) {
			fine.append(SEPARATORE);
			fine.append(zoo.get(i).riceviCarezze(carezze));
			fine.append(SEPARATORE);
			if (zoo.get(i).sonoMorto()) {
				zoo.remove(zoo.get(i));
				i--;
			}
		}
		return fine.toString();
	}

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
	 * metodo elenca componenti dello zoo senza svelare direttamente i parametri
	 * tamamgotchi
	 * 
	 * @return {@linkplain String}
	 * @author Frncesca, edited by Simone
	 */
	public static String visualizzaMyZoo() {
		StringBuilder eccoLoZoo = new StringBuilder();

		eccoLoZoo.append("Lo Zoo e' composto da: \n");
		for (int i = 0; i < zoo.size(); i++) {
			Tamagotchi daVisu = zoo.get(i);
			eccoLoZoo.append(String.format(" Il tamagotchi n%c %d", BelleStringhe.GRADO, i + 1));
			eccoLoZoo.append(String.format(", che appartiene alla Specie %s", daVisu.getTipo()));
			eccoLoZoo.append(String.format(", lo hai chiamato %s e%s", daVisu.getNome(), daVisu.umore()));

		}
		return eccoLoZoo.toString();
	}

	/**
	 * <b>Metodo</b> che descrive lo {@link #zoo} e la quantita' di
	 * {@linkplain Tamagotchi} presenti
	 * @author Simone
	 */
	public static String toStringa() {
		return String.format("Nello zoo ci sono %d Tamagotchi", zoo.size());
	}

	/**
	 * <b>Metodo</b> che descrive lo {@link #zoo} e tutti i suoi abitanti
	 * 
	 * @return una {@linkplain String} che descrive l'intero zoo, con dei separatori
	 *         da tra di loro({@link #SEPARATORE})
	 * @author Simone
	 */
	public static String toStringCollections() {
		StringBuilder fine = new StringBuilder(toStringa());
		String[] collection = visualizzaZoo();
		fine.append("\nContiene:\n");
		if (collection != null && collection.length > 0) {
			for (int i = 0; i < collection.length; i++) {
				fine.append(SEPARATORE);
				fine.append(collection[i]);
				fine.append(SEPARATORE);
			}
		} else
			fine.append("-->vuoto");

		return fine.toString();
	}

	/**
	 * <b>Metodo</b> che descrive lo {@link #zoo} e tutti i suoi abitanti
	 * 
	 * @return una {@linkplain String} che descrive l'intero zoo
	 * @author Francesca
	 */
	public static String toStringMyZoo() {
		StringBuilder fine = new StringBuilder(toStringa());
		String[] collection = visualizzaZoo();
		if (collection != null && collection.length > 0) {
			fine.append("\nContiene:\n");
			for (int i = 0; i < collection.length; i++) {
				fine.append(String.format("%d%c Tamagotchi", i + 1, BelleStringhe.GRADO));
				fine.append(SEPARATORE);
				fine.append(collection[i]);
				fine.append(SEPARATORE);
			}
		} else
			fine.append("Lo zoo e' vuoto");

		return fine.toString();
	}

	/**
	 * @return {@code true}, se lo {@link #zoo} e' vuoto, {@code false} altrimenti
	 @author Simone
	 */
	public static boolean tuttiMorti() {
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
