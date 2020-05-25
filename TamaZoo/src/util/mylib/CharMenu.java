package util.mylib;

public class CharMenu extends MyMenu {
	private static final int VOCI_DISPONIBILI = 26;
	private static final String IMPOSSIBILE_CREARE_CHARMENU = "Impossibile creare un CharMenu con piu' di "
			+ VOCI_DISPONIBILI + " voci. Verra' usato MyMenu";
	final private static String RICHIESTA_INSERIMENTO = "Digita il carattere dell'opzione desiderata > ";
	private static final int LUNGHEZZA_RICHIESTA = RICHIESTA_INSERIMENTO.length();
	/**
	 * attributo che capisce se e' possibile creare un CharMenu. In caso non sia
	 * possibile, esso crea un normale {@link MyMenu}
	 */
	final private boolean isPossibile;
	final private String ammissibili = creaAmmissibili();

	private CharMenu(String titolo, String[] voci, boolean isPossibile) {
		super(titolo, voci);
		this.isPossibile = isPossibile;
	}

	public CharMenu(String titolo, String[] voci) {
		this(titolo, voci, !(voci.length > VOCI_DISPONIBILI));
	}

	@Override
	public void stampaMenu() {
		if (!isPossibile) {
			System.out.println(IMPOSSIBILE_CREARE_CHARMENU);
			super.stampaMenu();
		} else {
			System.out.println(BelleStringhe.incorniciaCentrato(getTitolo(),LUNGHEZZA_RICHIESTA));
			for (char a = 'A', i = 0; i < getVoci().length; a++, i++) {
				System.out.println((a) + ")\t" + getVoci()[i]);
			}

			System.out.println('\n' + VOCE_USCITA + '\n');
		}
	}

	@Override
	public int scegli() {
		if (!isPossibile)
			return super.scegli();
		else {
			stampaMenu();
			return InputDati.leggiUpperChar(RICHIESTA_INSERIMENTO, ammissibili);

		}

	}

	private String creaAmmissibili() {
		StringBuilder ammissibili = new StringBuilder();
		for (char i = 'A'; i < 'A' + getVoci().length; i++) {
			ammissibili.append(i);
		}
		ammissibili.append(0);
		return ammissibili.toString();
	}
}
