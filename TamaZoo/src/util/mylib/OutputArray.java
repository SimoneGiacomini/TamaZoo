package util.mylib;



public class OutputArray {
	
	private OutputArray() {
	}
	
	public static void arrayStringConsole(String[] array) {
		for (int i = 0; i < array.length; i++) {
			InputDati.premutoTasto(array[i]);
		}
	}
}
