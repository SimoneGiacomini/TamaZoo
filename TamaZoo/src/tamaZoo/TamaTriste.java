package tamaZoo;

import Tamagotchi.Tamagotchi;
import Tamagotchi.UtilTamagotchi;

public class TamaTriste extends Tamagotchi {

	/**
	 * <b>Costruttore con attributi</b>
	 */
	public TamaTriste(String nome, float affetto, float sazieta) {
		super(nome, affetto, sazieta);
	}

	/**
	 * <h1>Costruttore con solo nome</h1>: viene istanziato un oggetto di tipo
	 * {@linkplain TamaTriste}, con rispettivi valori:
	 * <p>
	 * {@linkplain Tamagotchi#nome}=<code>nome</code>
	 * </p>
	 * <p>
	 * {@linkplain Tamagotchi#affetto}={@linkplain Tamagotchi#VAL_INIZ_RECOMMEND}
	 * </p>
	 * <p>
	 * {@linkplain Tamagotchi#sazieta}={@linkplain Tamagotchi#VAL_INIZ_RECOMMEND}
	 * </p>
	 * 
	 * @param nome
	 *            ,il nome da associare al {@linkplain TamaTriste}
	 */
	public TamaTriste(String nome) {
		super(nome);
	}

	/**
	 * Costruttore usato nei test, non capisco perche' lasciare solo come parametro
	 * sazieta' e non anche affetto, in quanto "affetto" non e' descritto nel PDF che deve sempre
	 * essere ad un valore fisso
	 */
	@Deprecated
	public TamaTriste(String nome, int sazieta) {
		this(nome, 0, sazieta);
	}

	/**
	 * metodo che dice se il {@linkplain TamaTriste} e' triste
	 * 
	 * @return return true, in quanto il {@linkplain TamaTriste} e' sempre triste
	 */
	@Override
	public boolean sonoTriste() {
		return true;
	}

	/**
	 * metodo che dice se il {@linkplain TamaTriste} e' felice
	 * 
	 * @return false, in quanto il {@linkplain TamaTriste} e' sempre triste
	 */
	@Override
	public boolean isFelice() {
		return false;
	}

	/**
	 * metodo che capisce se il {@linkplain TamaTriste} e' morto
	 * 
	 * @return {@code true} se il {@linkplain TamaTriste} e' morto, false altrimenti
	 */
	@Override
	public boolean sonoMorto() {
		return (UtilTamagotchi.inRange(getSazieta(), MAX_VALORI_INTERNI - 1, MIN_VALORI_INTERNI + 1) != 0);
	}
	@Override
	public Specie getTipo() {
		return Specie.Triste;
	}

}
