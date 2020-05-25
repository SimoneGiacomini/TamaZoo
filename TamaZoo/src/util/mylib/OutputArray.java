package util.mylib;



public class OutputArray {
	
	private static final String PROSSIMO_ELEMENTO = "< Per visualizzare il prossimo elemento, premi invio >";

	private OutputArray() {
	}
	
	public static void arrayStringConsoleConAttesa(String[] array) {
		for (int i = 0; i < array.length; i++) {
			InputDati.isUnTastoPremuto(array[i],PROSSIMO_ELEMENTO);
			
		}
	}
	
	public static void arrayStringConsole(String[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}
}
