import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.XMLWriter;

public class Principal extends Thread{
	
	public static void main(String[] args) throws InterruptedException {
		Scanner leer = new Scanner(System.in);
		System.out.println("Ingrese el número de comprobantes: ");
		Date horaInicio = new Date();
		
		int nroComprobantes = leer.nextInt();
		
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
		
		Date horaFin = new Date();
		
		Long tiempo = horaFin.getTime() - horaInicio.getTime();
		
		System.out.println("Comprobantes creados.");
		System.out.println("Tiempo total : " + tiempo.doubleValue()/1000 + " segundos" );
		
	}
	

}
