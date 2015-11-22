
public class GeneraDebitosCreditos {
	
	public int debito(){
		int num = (int)Math.floor(Math.random()*(1-6)+6);
		int debito = 0;
		switch (num) {
		case 1:
			debito = 50000;
		case 2:
			debito = 100000;
			break;
		case 3:
			debito = 150000;
		case 4:
			debito = 200000;
		case 5:
			debito = 500000;

		default:
			break;
		}
		return debito;
	}
	
	public int credito(int debito){
		int credito = debito;
		return credito;
	}

}
