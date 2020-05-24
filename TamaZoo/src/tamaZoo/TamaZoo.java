package tamaZoo;

import java.util.ArrayList;
import java.util.Collection;

import Tamagotchi.Tamagotchi;

public abstract class TamaZoo {

	public static final String SEPARATORE = "\n***********************\n";

	public static final byte QUANTITA_SPECIE = 3;

	private static ArrayList<Tamagotchi> zoo=new ArrayList<Tamagotchi>();

	public static void initZoo(Collection<Tamagotchi> zoo) {
		TamaZoo.zoo = new ArrayList<Tamagotchi>();
		TamaZoo.zoo.addAll(zoo);
	}

	public static String daiBiscotti(int biscotti) {
		StringBuilder fine = new StringBuilder();
		for (int i=0;i<zoo.size();i++) {
			fine.append(SEPARATORE);
			fine.append(zoo.get(i).riceviBiscotti(biscotti));
			fine.append(SEPARATORE);
			if (zoo.get(i).sonoMorto()) {
				zoo.remove(zoo.get(i));
				i--;}
		}
		return fine.toString();
	}

	public static String daiCarezze(int carezze) {
		StringBuilder fine = new StringBuilder();
		for (int i=0;i<zoo.size();i++) {
			fine.append(SEPARATORE);
			fine.append(zoo.get(i).riceviCarezze(carezze));
			fine.append(SEPARATORE);
			if (zoo.get(i).sonoMorto()) {
				zoo.remove(zoo.get(i));
				i--;}
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
	 * metodo elenca componenti dello zoo  senza svelare direttamente i parametri tamamgotchi
	 * @return
	 */
	public static String visualizzaMyZoo() {
		StringBuilder eccoLoZoo = new StringBuilder();
		int posZoo=0;
		eccoLoZoo.append("eccola: \n");
		for  (int i = 0; i < zoo.size(); i++) {
			
			 posZoo= zoo.indexOf(zoo.get(i))+1;
			 eccoLoZoo.append(String.format(" il tamagotchi n : %d",posZoo));
			 eccoLoZoo.append(String.format(" lo hai chiamato: %s",zoo.get(i).getNome()));
			 eccoLoZoo.append(String.format(" appartiene alla Specie %s",zoo.get(i).getClass().getSimpleName()));
			 eccoLoZoo.append(String.format(" il suo stato attuale : %s\n",zoo.get(i).umore()));
            }
		
	
		 return eccoLoZoo.toString();
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

	public static String toStringMyZoo() {
		StringBuilder fine = new StringBuilder(toStringa());
		String[] collection = visualizzaZoo();
		fine.append("\nContiene:\n");
		if (collection != null && collection.length > 0) {
			for (int i = 0; i < collection.length; i++) {
				fine.append(String.format("%d Tamagotchi", zoo.size()));
				fine.append(collection[i].toString());
			
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
	
	public static boolean tamaNameIsUsed(String nomeTam) {
		for (Tamagotchi tamagotchi : zoo) {
			if(tamagotchi.getNome().equalsIgnoreCase(nomeTam))
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
