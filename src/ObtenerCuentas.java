import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;


public class ObtenerCuentas {
	
	public List<String> obtenerCodigos(){
		File xmlCuentas = new File("xml/cuentas.xml");
		SAXReader reader = new SAXReader();
		Document doc = null;
		List<String> codigos = new ArrayList<String>();
		 try {
				doc = reader.read(xmlCuentas);
				Element root = doc.getRootElement();
				for ( Iterator i = root.elementIterator( "Cuenta" ); i.hasNext(); ) {
		            Element cuenta = (Element) i.next();
		            for (Iterator j = cuenta.elementIterator("Codigo"); j.hasNext();) {
		            	Element cuentas = (Element) j.next();
		            	codigos.add(cuentas.getText());
					}
				}
			} catch (DocumentException e) {
				e.printStackTrace();
			}
		return codigos;
	}
	
	public List<String> obtenerNombres(){
		File xmlCuentas = new File("xml/cuentas.xml");
		SAXReader reader = new SAXReader();
		Document doc = null;
		List<String> nombres = new ArrayList<String>();
		 try {
				doc = reader.read(xmlCuentas);
				Element root = doc.getRootElement();
				for ( Iterator i = root.elementIterator( "Cuenta" ); i.hasNext(); ) {
		            Element cuenta = (Element) i.next();
		            for (Iterator j = cuenta.elementIterator("Nombre"); j.hasNext();) {
		            	Element cuentas = (Element) j.next();
		            	nombres.add(cuentas.getText());
					}
				}
			} catch (DocumentException e) {
				e.printStackTrace();
			}
		return nombres;
	}

}
