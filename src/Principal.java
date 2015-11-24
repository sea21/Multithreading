import java.util.Date;
import java.util.Scanner;

public class Principal extends Thread{
	
	public static void main(String[] args) throws InterruptedException {
		Scanner leer = new Scanner(System.in);
		System.out.println("Ingrese el número de comprobantes: ");
		Date horaInicio = new Date();
		
		int nroComprobantes = leer.nextInt();
		
		if (nroComprobantes == 1){
			
			CrearDocumento crearDocu = new CrearDocumento();
			CrearDocumentosThread t1;
			t1 = new CrearDocumentosThread(crearDocu, nroComprobantes);
			t1.start();
			t1.join();
			
		}else if((nroComprobantes % 2) == 0 ){
			
				int mitad = nroComprobantes / 2;
				CrearDocumento crearDocu = new CrearDocumento();
				CrearDocumentosThread t1, t2;
				t1 = new CrearDocumentosThread(crearDocu, mitad);
				t2 = new CrearDocumentosThread(crearDocu, mitad);
				t1.start();
				t2.start();
				t1.join();
				t2.join();
				
			}else if ((nroComprobantes % 3) == 0) {
				
				int mitad = nroComprobantes / 3;
				CrearDocumento crearDocu = new CrearDocumento();
				CrearDocumentosThread t1, t2, t3;
				t1 = new CrearDocumentosThread(crearDocu, mitad);
				t2 = new CrearDocumentosThread(crearDocu, mitad);
				t3 = new CrearDocumentosThread(crearDocu, mitad);
				t1.start();
				t2.start();
				t3.start();
				t1.join();
				t2.join();
				t3.join();
				
			}else {
				int mitad = nroComprobantes / 4;
				CrearDocumento crearDocu = new CrearDocumento();
				CrearDocumentosThread t1, t2, t3, t4;
				t1 = new CrearDocumentosThread(crearDocu, mitad);
				t2 = new CrearDocumentosThread(crearDocu, mitad);
				t3 = new CrearDocumentosThread(crearDocu, mitad);
				t4 = new CrearDocumentosThread(crearDocu, mitad);
				t1.start();
				t2.start();
				t3.start();
				t4.start();
				t1.join();
				t2.join();
				t3.join();
				t4.join();
			}
			
		Date horaFin = new Date();
		
		Long tiempo = horaFin.getTime() - horaInicio.getTime();
		
		System.out.println("Comprobantes creados.");
		System.out.println("Tiempo total : " + tiempo.doubleValue()/1000 + " segundos" );
		}
	}
