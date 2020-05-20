package tamaZoo;

import java.util.ArrayList;
import java.util.Collection;

import Tamagotchi.Tamagotchi;

public abstract class TamaZoo {

	public static final String SEPARATORE = "\n***********************\n";

	public static final byte QUANTITA_SPECIE = 2;

	private static ArrayList<Tamagotchi> zoo=new ArrayList<Tamagotchi>();

	public static void initZoo(Collection<Tamagotchi> zoo) {
		TamaZoo.zoo = new ArrayList<Tamagotchi>();
		TamaZoo.zoo.addAll(zoo);
	}

	public static String daiBiscotti(int biscotti) {
		StringBuilder fine = new StringBuilder();
		for (Tamagotchi tamagotchi : zoo) {
			fine.append(SEPARATORE);
			fine.append(tamagotchi.daiBiscotti(biscotti));
			fine.append(SEPARATORE);
			if (tamagotchi.isMorto())
				zoo.remove(tamagotchi);
		}
		return fine.toString();
	}

	public static String daiCarezze(int carezze) {
		StringBuilder fine = new StringBuilder();
		for (Tamagotchi tamagotchi : zoo) {
			fine.append(SEPARATORE);
			fine.append(tamagotchi.daiCarezze(carezze));
			fine.append(SEPARATORE);
			if (tamagotchi.isMorto())
				zoo.remove(tamagotchi);
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

	public static String toStringa() {
		return String.format("Nello zoo ci sono %d Tamagotchi", zoo.size());
	}

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

	public static boolean tuttiMorti() {
		return zoo.isEmpty();
	}
	public static boolean tamaNameIsUsed(Tamagotchi tam) {
		for (Tamagotchi tamagotchi : zoo) {
			if(tamagotchi.equals(tam))
				return true;
		}
		return false;
	}
	
	public static boolean aggiungiTamagotchi(Tamagotchi tam) {
		if(tamaNameIsUsed(tam))
			throw new IllegalArgumentException("Esiste gia' un Tamagotchi con lo stesso nome");
		return zoo.add(tam);
	}
}
