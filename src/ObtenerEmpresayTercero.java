import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dom4j.*;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XPPReader;

public class ObtenerEmpresayTercero {

	public List<String> obtenerCodigos(){
		File xmlParties = new File("xml/parties.xml");
		SAXReader reader = new SAXReader();
		Document doc = null;
		List<String> codigos = new ArrayList<String>();
		 try {
				doc = reader.read(xmlParties);
				Element root = doc.getRootElement();
				for ( Iterator i = root.elementIterator( "Tercero" ); i.hasNext(); ) {
		            Element tercero = (Element) i.next();
		            for (Iterator j = tercero.elementIterator("Codigo"); j.hasNext();) {
		            	Element terceros = (Element) j.next();
		            	codigos.add(terceros.getText());
					}
				}
			} catch (DocumentException e) {
				e.printStackTrace();
			}
		return codigos;
	}
	
	public List<String> obtenerNombres(){
		File xmlParties = new File("xml/parties.xml");
		SAXReader reader = new SAXReader();
		Document doc = null;
		List<String> nombres = new ArrayList<String>();
		 try {
				doc = reader.read(xmlParties);
				Element root = doc.getRootElement();
				for ( Iterator i = root.elementIterator( "Tercero" ); i.hasNext(); ) {
		            Element tercero = (Element) i.next();
		            for (Iterator j = tercero.elementIterator("Nombre"); j.hasNext();) {
		            	Element terceros = (Element) j.next();
		            	nombres.add(terceros.getText());
					}
				}
			} catch (DocumentException e) {
				e.printStackTrace();
			}
		return nombres;
	}
	
}
