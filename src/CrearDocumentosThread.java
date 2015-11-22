import java.io.IOException;


public class CrearDocumentosThread extends Thread {
	
	CrearDocumento crearDocumento;
	int nroComprobantes;

	 
	CrearDocumentosThread(CrearDocumento crearDocumento, int nroComprobantes){
		this.crearDocumento = crearDocumento;
		this.nroComprobantes = nroComprobantes;
	}

	public void run() {
		try {
			crearDocumento.createDocument(nroComprobantes);
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
