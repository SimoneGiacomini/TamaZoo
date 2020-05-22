package Tamagotchi;

import tamaZoo.Specie;

/**
 * Classe che rappresenta un <a href="https://it.wikipedia.org/wiki/Tamagotchi">
 * Tamagotchi </a>
 * 
 * @author Simone Giacomini s.giacomini008@studenti.unibs.it
 */
public class Tamagotchi {
	
	Specie tipo = null ;

	/**
	 * attributo {@linkplain String} che rappresenta il {@linkplain #nome} del
	 * {@linkplain Tamagotchi}
	 */
	private String nome;
	/**
	 * attributo float che rappresenta l'{@linkplain #affetto} del
	 * {@linkplain Tamagotchi}
	 */
	private float affetto;
	/**
	 * attributo float che rappresenta la {@linkplain #sazieta} del
	 * {@linkplain Tamagotchi}
	 */
	private float sazieta;

	protected byte numVolteDaiCarezze = 0;
	protected byte numVolteDaiBiscotti = 0;

	/** Massimo numero di biscotti e di carezze */
	public static final byte MAX_INPUT_STIMOLI = 20;

	/** Massimo numero possibile di {@linkplain #affetto} o {@linkplain #sazieta} */
	public static final byte MAX_VALORI_INTERNI = 100;

	/** Minor numero possibile di {@linkplain #affetto} o {@linkplain #sazieta}  */
	public static final byte MIN_VALORI_INTERNI = 0;

	/**
	 * E' un valore <b>consigliato </b>per quando si istanzia un
	 * {@linkplain Tamagotchi}.
	 */
	public static final byte VAL_INIZ_RECOMMEND = 20;

	/** faccina felice {@value} */
	public static final String HAPPY = "(^w^)";

	/** faccina triste {@value} */
	public static final String SAD = "(T^T)";

	/** faccina normale {@value} */
	public static final String NORMAL = "(^_^)";

	/** faccina morta {@value} */
	public static final String DIE = "(X_X)";
	/** faccina arrabbiata {@value} */
	public static final String ANGRY = ">=(";
	/** Soglia della TRISTEZZA */
	protected static final byte SOGLIA_TRISTEZZA = 30;

	/** Soglia della Felicita' */
	protected static final byte SOGLIA_FELICITA = 80;

	/**
	 * Soglia della {@linkplain #sazieta}, oltre alla quale, il
	 * {@linkplain Tamagotchi} muore perche' troppo sazio
	 */
	protected static final byte SOGLIA_SAZIETA = 90;

	/**
	 * fattore utilizzato per <b>DIVIDERE</b> le <b>carezze </b> ricevute nel metodo
	 * {@linkplain #daiCarezze}
	 * 
	 * @see #daiCarezze
	 */
	protected static final byte FATTORE_CAREZZE = 2;
	/**
	 * percentuale che aumenta la {@linkplain #sazieta} quando si danno
	 * <b>biscotti</b>
	 * 
	 * @see #daiBiscotti
	 */
	protected static final float PERCENTUALE_AUMENTA_BISCOTTI = 10;

	/**
	 * fattore utilizzato per <b>DIVIDERE</b> i <b>biscotti</b> ricevuti nel metodo
	 * {@linkplain #daiBiscotti}
	 * 
	 * @see #daiBiscotti
	 */
	protected static final byte FATTORE_BISCOTTI = 4;

	/** {@linkplain String} di <b>biscotti</b> */
	protected static final String BISCOTTI = "biscotti";
	/** {@linkplain String} di <b>carezze</b> */
	protected static final String CAREZZE = "carezze";
	/**
	 * Sono il numero di volte che al {@linkplain Tamagotchi} va bene ricevere
	 * {@linkplain #CAREZZE}
	 */
	protected static final int TOO_MUCH_CAREZZE = 5;
	/**
	 * Quando si danno per troppe volte {@linkplain #CAREZZE} o
	 * {@linkplain #BISCOTTI} il {@linkplain Tamagotchi} si stanca e non ha piu'
	 * voglia
	 */
	protected static final String TOO_MUCH_STIMULUS = "HAI DATO TROPPE VOLTE %s, ORA NON NE HA PIU'TANTA VOGLIA ";
	/**
	 * quanto gli stimoli vengono ridotti, dopo che ne ha ricevuti troppi di seguito
	 */
	protected static final double RIDUZ_EFF_STIMULUS = 2.00;
	/**
	 * Sono il numero di volte che al {@linkplain Tamagotchi} va bene ricevere
	 * {@linkplain #BISCOTTI}
	 */
	protected static final int TOO_MUCH_BISCOTTI = 2;

	/** {@linkplain String} di {@linkplain #affetto} */
	public static final String AFFETTO = "affetto";
	/** {@linkplain String} di {@linkplain #sazieta} */
	public static final String SAZIETA = "saziet\u00e0";

	private static final String ERR_STRINGA_VUOTA = "ATTENZIONE IL PARAMETRO NON PU\u00d2 ESSERE UNA STRINGA VUOTA";
	protected static final String ERR_TAMAGOTCHI_AFFETTO_MAX = "ATTENZIONE, IL TAMAGOTCHI ti adora al massimo <3. NON Puoi dare pi\u00f9 CAREZZE\n";
	protected static final String ERR_TAMAGOTCHI_SAZIO_AL_MAX = "ATTENZIONE, IL TAMAGOTCHI \u00e8 Sazio al massimo! NON Puoi dare pi\u00f9 BISCOTTI\n";

	// tutti gli AVVERTIMENTI che si possono avere
	protected static final String WARNING_LOW = "ATTENZIONE!! Il valore %s \u00e8 al minimo!!";
	protected static final String WARNING_HIGH = "ATTENZIONE!! Il valore %s \u00e8 al massimo!!";

	/**
	 * <b>Costruttore con attributi</b>
	 */
	public Tamagotchi(String nome, float affetto, float sazieta) {

		setNome(nome);
		setAffetto(affetto);
		setSazieta(sazieta);
		this.tipo = getTipo();
	}

	/**
	 * <h1>Costruttore vuoto</h1> viene istanziato un oggetto di tipo
	 * {@linkplain Tamagotchi}, con rispettivi valori:
	 * <p>
	 * {@linkplain #nome}=<code>nome</code>
	 * </p>
	 * <p>
	 * {@linkplain #affetto}={@linkplain #VAL_INIZ_RECOMMEND}
	 * </p>
	 * <p>
	 * {@linkplain #sazieta}={@linkplain #VAL_INIZ_RECOMMEND}
	 * </p>
	 */
	public Tamagotchi(String nome) {
		this(nome, VAL_INIZ_RECOMMEND, VAL_INIZ_RECOMMEND);
	}

	/** Ritorna il valore di {@linkplain #nome} */
	public String getNome() {
		return nome;
	}

	/**
	 * viene assegnato all'attributo {@linkplain #nome} la {@linkplain String}
	 * passata in ingresso
	 * 
	 * @throws IllegalArgumentException
	 *             se la stringa passata e' vuota o nulla
	 * @param nome
	 */
	public void setNome(String nome) {
		if (nome.isEmpty() || nome.equalsIgnoreCase(null))
			throw new IllegalArgumentException(ERR_STRINGA_VUOTA);

		this.nome = nome;
	}

	/** Ritorna il valore di {@linkplain #affetto} */
	public float getAffetto() {
		return affetto;
	}

	/**
	 * Imposta il numero dato in ingresso all'attributo {@linkplain #affetto}.
	 * 
	 * @param affetto
	 * @see UtilTamagotchi#checkErrInBuild
	 */
	public void setAffetto(float affetto) {

		UtilTamagotchi.checkErrInBuild(affetto, MAX_VALORI_INTERNI, MIN_VALORI_INTERNI);
		this.affetto = affetto;

	}

	/** Ritorna il valore di {@linkplain #sazieta} */
	public float getSazieta() {
		return sazieta;
	}

	/**
	 * imposta il numero dato in ingresso all'attributo {@linkplain #sazieta}
	 * 
	 * @see UtilTamagotchi#checkErrInBuild
	 * 
	 * @param sazieta
	 */
	public void setSazieta(float sazieta) {
		UtilTamagotchi.checkErrInBuild(sazieta, MAX_VALORI_INTERNI, MIN_VALORI_INTERNI);
		this.sazieta = sazieta;

	}

	/**
	 * Ritorna una {@linkplain String} tipo
	 * ({@linkplain #sazieta}/{@linkplain #MAX_VALORI_INTERNI})
	 */
	public String getSazietaFormattata() {
		return String.format("(%.2f/%d)%s", getSazieta(), MAX_VALORI_INTERNI, System.lineSeparator());
	}

	/**
	 * Ritorna una {@linkplain String} tipo
	 * ({@linkplain #affetto}/{@linkplain #MAX_VALORI_INTERNI})
	 */
	public String getAffettoFormattato() {
		return String.format("(%.2f/%d)%s", getAffetto(), MAX_VALORI_INTERNI, System.lineSeparator());
	}

	/**
	 * Ritorna una {@linkplain String} con {@linkplain #nome},
	 * {@linkplain #umore()}, ed {@linkplain #sazieta} e {@linkplain #affetto}
	 * formattate
	 * 
	 * @see {@linkplain #getSazietaFormattata()},
	 *      {@linkplain #getAffettoFormattato()}
	 */
	public String toString() {
		return String.format(
				System.lineSeparator() + "%s " + System.lineSeparator() + "%s %s" + System.lineSeparator() + "%s %s",getTipo(),
				umore(), SAZIETA.toUpperCase(), getSazietaFormattata(), AFFETTO.toUpperCase(), getAffettoFormattato());
	}

	/**
	 * dando in input X biscotti essi<b> aumenteranno del
	 * {@linkplain #PERCENTUALE_AUMENTA_BISCOTTI} l'attributo {@linkplain #sazieta}
	 * per OGNI BISCOTTO DATO</b> e <b>diminuira' l'{@linkplain #affetto} con la
	 * formula: {@code affetto=affetto-(numerobiscotti/4)}</b>. In piu' questo
	 * metodo <b>controlla tutte le possibili combinazioni possibili</b> per non
	 * settare a un valore, stabilito da noi, troppo alto
	 * ({@linkplain #MAX_VALORI_INTERNI}) o basso ({@linkplain #MIN_VALORI_INTERNI})
	 * gli attributi
	 * 
	 * @param numeroBiscotti
	 * @return {@linkplain String} con i parametri aggiornati e tutti i messaggi
	 *         d'errore del caso
	 * @see {@linkplain UtilTamagotchi#checkErrInBuild},
	 *      {@linkplain Tamagotchi#toString()}
	 */
	public String riceviBiscotti(int numeroBiscotti) {
		numVolteDaiBiscotti++;
		numVolteDaiCarezze = 0;// numVolteDaiCarezze--;
		StringBuffer error = new StringBuffer();
		if (numVolteDaiBiscotti > TOO_MUCH_BISCOTTI) {
			int numeroBiscottiConRiduzione = (int) Math.round((double) numeroBiscotti / RIDUZ_EFF_STIMULUS);
			numeroBiscotti = numeroBiscottiConRiduzione;// numeroBiscotti=numeroBiscotti/2;
			error.append(String.format(TOO_MUCH_STIMULUS + "%n", BISCOTTI.toUpperCase()));
		}
		// terzo check se la sazieta'  e' gia'  al massimo, non si puo' piu' dare
		// biscotti
		if (Math.min(getSazieta(), MAX_VALORI_INTERNI) == MAX_VALORI_INTERNI)

			error.append(ERR_TAMAGOTCHI_SAZIO_AL_MAX);

		try {
			// lanciata eccezione se si prova ad impostare l'affetto a meno di
			// MIN_VALORI_INTERNI
			float nuovoAffetto = (getAffetto() - (float) (numeroBiscotti) / (float) (FATTORE_BISCOTTI));
			setAffetto(nuovoAffetto);
		} catch (IllegalArgumentException e) {
			setAffetto(MIN_VALORI_INTERNI);
		}
		try {
			float nuovaSazieta = (float) UtilTamagotchi.incrementoInPercentuale(getSazieta(), numeroBiscotti,
					PERCENTUALE_AUMENTA_BISCOTTI);
			setSazieta(nuovaSazieta);

		} catch (IllegalArgumentException e) {
			setSazieta(MAX_VALORI_INTERNI);
		}
		if (getAffetto() == MIN_VALORI_INTERNI)
			error.append(String.format(WARNING_LOW, AFFETTO));

		if (getSazieta() == MAX_VALORI_INTERNI) {
			if (error.length() > 0)
				error.append('\t');
			error.append(String.format(WARNING_HIGH, SAZIETA));
		}
		return error.toString() + toString();

	}

	/**
	 * dando in input X carezze esse<b> aumenteranno di X l'attributo
	 * {@linkplain #affetto}</b> e <b>diminuiranno la {@linkplain #sazieta} tramite
	 * la formula: {@code sazieta=sazieta-(numeroCarezze/2)}</b>. In piu' questo
	 * metodo <b>controlla tutte le possibili combinazioni possibili</b>, per non
	 * settare a un valore, stabilito da noi, troppo alto
	 * ({@linkplain #MAX_VALORI_INTERNI}) o basso ({@linkplain #MIN_VALORI_INTERNI})
	 * gli attributi
	 * 
	 * @param numeroCarezze
	 * @return {@linkplain String} con i parametri aggiornati e tutti i messaggi
	 *         d'errore del caso
	 * @see {@linkplain UtilTamagotchi#checkErrInBuild},
	 *      {@linkplain Tamagotchi#toString()}
	 * 
	 */
	public String riceviCarezze(int numeroCarezze) {
		numVolteDaiCarezze++;
		numVolteDaiBiscotti = 0;
		StringBuffer error = new StringBuffer();

		if (numVolteDaiCarezze > TOO_MUCH_CAREZZE) {
			int numeroCarezzeConRiduzione = (int) Math.round(numeroCarezze / RIDUZ_EFF_STIMULUS);
			numeroCarezze = numeroCarezzeConRiduzione;
			error.append(String.format(TOO_MUCH_STIMULUS + "%n", CAREZZE.toUpperCase()));
		}
		// terzo check se l'affetto e' gia'  al massimo, non si puo' piu' dare carezze
		if (Math.min(getAffetto(), MAX_VALORI_INTERNI) == MAX_VALORI_INTERNI)
			error.append(ERR_TAMAGOTCHI_AFFETTO_MAX);
		try {
			// lanciata eccezione se si prova ad impostare la sazieta' a meno di
			// MIN_VALORI_INTERNI
			float nuovaSazieta = getSazieta() - (float) (numeroCarezze) / (float) (FATTORE_CAREZZE);
			setSazieta((nuovaSazieta));
		} catch (IllegalArgumentException e) {
			setSazieta(MIN_VALORI_INTERNI);
		}
		try {
			setAffetto((float) (getAffetto() + numeroCarezze));
		} catch (IllegalArgumentException e) {

			setAffetto(MAX_VALORI_INTERNI);
		}
		if (getSazieta() == MIN_VALORI_INTERNI)
			error.append(String.format(WARNING_LOW, SAZIETA));

		if (getAffetto() == MAX_VALORI_INTERNI) {
			if (error.length() > 0)
				error.append('\t');
			error.append(String.format(WARNING_HIGH, AFFETTO));
		}
		return error.toString() + toString();
	}

	/**
	 * metodo che dice se il {@linkplain Tamagotchi} e' triste
	 * 
	 * @return boolean
	 */
	public boolean sonoTriste() {
		if (getAffetto() < SOGLIA_TRISTEZZA || getSazieta() < SOGLIA_TRISTEZZA || getSazieta() > SOGLIA_SAZIETA)
			return true;
		return false;
	}

	/**
	 * metodo che dice se il {@linkplain Tamagotchi} e' felice
	 * 
	 * @return boolean
	 * 
	 */
	public boolean isFelice() {
		if (getAffetto() > SOGLIA_FELICITA && getSazieta() > SOGLIA_FELICITA)
			return true;
		return false;
	}

	/**
	 * metodo che capisce se il {@linkplain Tamagotchi} e' morto
	 * 
	 * @return {@linkplain boolean}
	 */
	public boolean sonoMorto() {

		if (UtilTamagotchi.inRange(sazieta, MAX_VALORI_INTERNI - 1, MIN_VALORI_INTERNI + 1) != 0
				|| getAffetto() == MIN_VALORI_INTERNI)
			return true;
		return false;
	}

	/**
	 * capisce com'e' l'umore del {@linkplain Tamagotchi}, descrivendolo
	 * 
	 * @return {@linkplain String}
	 */
	public String umore() {

		if (sonoMorto())
			return getNome() + " \u00e8 morto " + DIE;

		if (isFelice())
			return getNome() + " \u00e8 felice " + HAPPY;

		if (sonoTriste())
			return getNome() + " \u00e8 triste " + SAD;

		return getNome() + " sta bene " + NORMAL;
	}

	/**
	 * restituisce una {@linkplain String} con le statistiche del
	 * {@linkplain Tamagotchi}
	 * 
	 * @see {@link #getAffettoFormattato()} , {@link #getSazietaFormattata()}
	 */
	public String getStatistiche() {
		return getSazietaFormattata() + getAffettoFormattato();

	}

	public Specie getTipo() {
		return Specie.Standar;
	}

	/**
	 * @return true se i nome dei 2 {@linkplain Tamagotchi} sono uguali, false
	 *         altrimenti
	 */
	public boolean equals(Tamagotchi tam) {
		return getNome().equalsIgnoreCase(tam.getNome());

	}

	public String eco(String messaggio) {
		return String.format("%s dice-> \"%s\"", getNome(), messaggio);
	}

}
