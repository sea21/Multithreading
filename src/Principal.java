import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		//Scanner leer = new Scanner(System.in);
		System.out.println("Ingrese el n�mero de comprobantes: ");
		//int nroComprobantes = leer.nextInt();
		
		GeneraFechas fecha = new GeneraFechas();
		GeneraNumeros numero = new GeneraNumeros();
		
		ObtenerEmpresayTercero empresaytercero = new ObtenerEmpresayTercero();
		
		ObtenerCuentas obtenerCuentas = new ObtenerCuentas();
		
		obtenerCuentas.obtenerNombres();
	}

}
