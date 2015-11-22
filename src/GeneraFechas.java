
public class GeneraFechas {
	
	public int ano(){
	    int ano = (int)Math.floor(Math.random()*(2013-2016)+2016);
		return ano;
	}
	
	public int mes(){
		int mes = (int)Math.floor(Math.random()*(1-13)+13);
		return mes;
	}
	
	public int dia(){
		int dia = (int)Math.floor(Math.random()*(1-32)+32);
		return dia;
	}
	
	public String fecha(){
		String fecha = null;
		int ano = ano();
		int mes = mes();
		int dia = dia();
		fecha = ano + "-" + mes + "-" + dia;
		return fecha;
	}

}
