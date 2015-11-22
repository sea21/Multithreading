
public class GeneraNumeros {
	
	public int num() {
		int numero = (int)Math.floor(Math.random()*(1-10)+10);
		return numero;
	}
	
	public String numero(){
		String numero = ""; 
		for (int i = 0; i < 10; i++) {
			numero = numero + num();
		}
		return numero;
	}

}
