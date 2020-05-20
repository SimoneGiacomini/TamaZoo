package tamaZoo;

import Tamagotchi.Tamagotchi;
import Tamagotchi.UtilTamagotchi;

public class TamaGordo extends Tamagotchi {

	/**
	 * <h1>Costruttore vuoto</h1> viene istanziato un oggetto di tipo
	 * {@linkplain TamaGordo}, con rispettivi valori:
	 * <p>
	 * {@linkplain Tamagotchi#nome}=<code>null</code>
	 * </p>
	 * <p>
	 * {@linkplain Tamagotchi#affetto}={@linkplain Tamagotchi#MAX_VALORI_INTERNI}
	 * </p>
	 * <p>
	 * {@linkplain Tamagotchi#sazieta}={@linkplain Tamagotchi#VAL_INIZ_RECOMMEND}
	 * </p>
	 */
	public TamaGordo() {
		super();
		setAffetto(MAX_VALORI_INTERNI);
	}
	/**
	 * <b>Costruttore con attributi</b>
	 */
	public TamaGordo(String nome, float sazieta) {
		super(nome, MAX_VALORI_INTERNI, sazieta);
	}
	/**
	 * <h1>Costruttore con solo il nome</h1>: viene istanziato un oggetto di tipo
	 * {@linkplain TamaGordo}, con rispettivi valori:
	 * <p>
	 * {@linkplain Tamagotchi#nome}=<code>nome</code>
	 * </p>
	 * <p>
	 * {@linkplain Tamagotchi#affetto}={@linkplain Tamagotchi#MAX_VALORI_INTERNI}
	 * </p>
	 * <p>
	 * {@linkplain Tamagotchi#sazieta}={@linkplain Tamagotchi#VAL_INIZ_RECOMMEND}
	 * </p>
	 * @param nome ,il nome da associare al {@linkplain TamaGordo}
	 */
	public TamaGordo(String nome) {
		this(nome,VAL_INIZ_RECOMMEND);
	}
	
	/**
	 * dando in input X biscotti essi<b> aumenteranno del
	 * {@linkplain Tamagotchi#PERCENTUALE_AUMENTA_BISCOTTI} l'attributo {@linkplain Tamagotchi#sazieta}
	 * per OGNI BISCOTTO DATO</b>. In piu' questo metodo <b>controlla tutte le
	 * possibili combinazioni</b> per non settare a un valore, stabilito
	 * da noi, troppo alto ({@linkplain Tamagotchi#MAX_VALORI_INTERNI}) o basso
	 * ({@linkplain Tamagotchi#MIN_VALORI_INTERNI}) gli attributi
	 * 
	 * @param numeroBiscotti
	 * @return {@linkplain String} con i parametri aggiornati e tutti i messaggi
	 *         d'errore del caso
	 * @see {@linkplain UtilTamagotchi#checkErrInBuild},
	 *      {@linkplain Tamagotchi#toString()}
	 */
	@Override
	public String daiBiscotti(int numeroBiscotti) {
		numVolteDaiBiscotti++;
		numVolteDaiCarezze = 0;// numVolteDaiCarezze--;
		StringBuffer error = new StringBuffer();
		/*
		 * in caso non si usasse una libreria di input tipo quella InputDati che fa
		 * controlli a principio, questo switch gestisce gli errori
		 */
		switch (UtilTamagotchi.inRange(numeroBiscotti, MAX_INPUT_STIMOLI, MIN_VALORI_INTERNI)) {
		case UtilTamagotchi.ERR_TOO_HIGH:
			return UtilTamagotchi.ERR_NUM_INSERT_TOO_HIGHT + MAX_INPUT_STIMOLI;
		case UtilTamagotchi.ERR_TOO_LOW:
			return UtilTamagotchi.ERR_NUM_INSERT_TOO_LOW + MIN_VALORI_INTERNI;
		default:
			break;
		}
		/* fine controlli dell'input */
		/*
		 *Questa parte diminuisce l'efficacia dell'aumento della sazieta'(e' una
		 * parte di upgrade del programma, richiesta in Tamagotchi)
		 */
		if (numVolteDaiBiscotti > TOO_MUCH_BISCOTTI) {
			numeroBiscotti = (int) Math.round((double) numeroBiscotti / RIDUZ_EFF_STIMULUS);// numeroBiscotti=numeroBiscotti/2;
			error.append(String.format(TOO_MUCH_STIMULUS + System.lineSeparator(), BISCOTTI.toUpperCase()));
		}
		//  check se la sazieta'  e' gia'  al massimo, non si puo' piu' dare
		// biscotti
		if (Math.min(getSazieta(), MAX_VALORI_INTERNI) == MAX_VALORI_INTERNI)
			error.append(ERR_TAMAGOTCHI_SAZIO_AL_MAX);
		try {
			setSazieta((float) UtilTamagotchi.incrementoInPercentuale(getSazieta(), numeroBiscotti,
					PERCENTUALE_AUMENTA_BISCOTTI));

		} catch (IllegalArgumentException e) {
			setSazieta(MAX_VALORI_INTERNI);
		}
		if (getSazieta() == MAX_VALORI_INTERNI) {
			
			error.append(String.format(WARNING_HIGH, SAZIETA));
		}
		return error.toString() + toString();

	}

	/**
	 * dando in input X carezze esse<b> non aumentano l'attributo
	 * {@linkplain Tamagotchi#affetto}</b>, ma <b>diminuiranno SOLO la {@linkplain Tamagotchi#sazieta}
	 * tramite la formula: {@code sazieta=sazieta-(numeroCarezze)}</b>. In piu'
	 * questo metodo <b>controlla tutte le possibili combinazioni</b>, per
	 * non settare a un valore, stabilito da noi, troppo alto
	 * ({@linkplain Tamagotchi#MAX_VALORI_INTERNI}) o basso ({@linkplain Tamagotchi#MIN_VALORI_INTERNI})
	 * gli attributi
	 * 
	 * @param numeroCarezze
	 * @return {@linkplain String} con i parametri aggiornati e tutti i messaggi
	 *         d'errore del caso
	 * @see {@linkplain UtilTamagotchi#checkErrInBuild},
	 *      {@linkplain Tamagotchi#toString()}
	 * 
	 */
	@Override
	public String daiCarezze(int numeroCarezze) {
		numVolteDaiCarezze++;
		numVolteDaiBiscotti = 0;
		/*
		 * In caso non si usasse una libreria di input tipo quella InputDati che fa
		 * controlli a principio, questo switch gestisce gli errori
		 */
		StringBuffer error = new StringBuffer();
		switch (UtilTamagotchi.inRange(numeroCarezze, MAX_INPUT_STIMOLI, MIN_VALORI_INTERNI)) {
		case UtilTamagotchi.ERR_TOO_HIGH:
			return UtilTamagotchi.ERR_NUM_INSERT_TOO_HIGHT + MAX_INPUT_STIMOLI;
		case UtilTamagotchi.ERR_TOO_LOW:
			return UtilTamagotchi.ERR_NUM_INSERT_TOO_LOW + MIN_VALORI_INTERNI;
		default:
			break;
		}
		/* fine controlli dell'input */
		try {
			// lanciata eccezione se si prova ad impostare la sazieta' a meno di
			// MIN_VALORI_INTERNI
			setSazieta((getSazieta() - (float) (numeroCarezze)));
		} catch (IllegalArgumentException e) {
			setSazieta(MIN_VALORI_INTERNI);
		}

		if (getSazieta() == MIN_VALORI_INTERNI)
			error.append(String.format(WARNING_LOW, SAZIETA));

		return error.toString() + toString();
	}

	/**
	 * metodo che dice se il {@linkplain TamaGordo} e' triste
	 * 
	 * @return boolean
	 */
	@Override
	public boolean isTriste() {
		return (getAffetto() < SOGLIA_TRISTEZZA || getSazieta() < SOGLIA_TRISTEZZA);

	}

	/**
	 * metodo che dice se il {@linkplain TamaGordo} e' felice
	 * 
	 * @return boolean
	 * 
	 */
	@Override
	public boolean isFelice() {
		return (getAffetto() > SOGLIA_FELICITA && getSazieta() > SOGLIA_FELICITA);

	}

	/**
	 * metodo che capisce se il {@linkplain TamaGordo} e' morto
	 * 
	 * @return {@linkplain boolean}
	 */
	@Override
	public boolean isMorto() {

		if (getSazieta() == MIN_VALORI_INTERNI || getAffetto() == MIN_VALORI_INTERNI)
			return true;
		return false;
	}

}
