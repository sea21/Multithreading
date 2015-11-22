import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.XMLWriter;


public class CrearDocumento {
	
public Document createDocument(int nroComprobantes) throws IOException, InterruptedException {
		
		ObtenerEmpresayTercero empresaytercero = new ObtenerEmpresayTercero();
		List<String> codigosTerceros = empresaytercero.obtenerCodigos();
		List<String> nombresTerceros = empresaytercero.obtenerNombres();
		
		ObtenerCuentas obtenerCuentas = new ObtenerCuentas();
		List<String> codCuentas = obtenerCuentas.obtenerCodigos();
		List<String> nomCuentas = obtenerCuentas.obtenerNombres();
		
		Document document = null;
        for (int i=0; i<=nroComprobantes; i++){
        	
        	document = DocumentHelper.createDocument();
            
            Element root = document.addElement( "Comprobante" );
        	
            GeneraFechas fecha = new GeneraFechas();
    		GeneraNumeros numero = new GeneraNumeros();
        	
        	int emp = (int)Math.floor(Math.random()*(0-codigosTerceros.size())+codigosTerceros.size());
        	
        	int ter = (int)Math.floor(Math.random()*(0-codigosTerceros.size())+codigosTerceros.size());

            Element tipo = root.addElement( "Tipo" )
                .addText( "Comprobante de Egreso" );
            
            Element numeroCompe = root.addElement( "Numero" )
                .addText( numero.numero() );

            Element fechaComp = root.addElement( "Fecha" )
                    .addText( fecha.fecha() );
            
            Element nota = root.addElement( "Nota" )
                    .addText( "Ninguna." );
            
            Element empresa = root.addElement( "Empresa" );
          
            	Element codEmpresa = empresa.addElement("Codigo")
            			.addText( codigosTerceros.get(emp).toString() );
            
            	Element nomEmpresa = empresa.addElement("Nombre")
            			.addText( nombresTerceros.get(emp).toString() );
            
            Element tercero = root.addElement("Tercero");
            
            	Element codTercero = tercero.addElement("Codigo")
            			.addText( codigosTerceros.get(ter).toString() );
            
            	Element nomTercero = tercero.addElement("Nombre")
            			.addText( nombresTerceros.get(ter).toString() );
            
            Element totales = root.addElement("Totales");
            
            	Element valor = totales.addElement("Valor")
            			.addText( "" );
            
            Element conta = root.addElement("Contabilizacion");

            int nroAsientos = numero.asientos();
            
            for (int j = 0; j < nroAsientos; j++) {
            
            GeneraDebitosCreditos genDebyCred = new GeneraDebitosCreditos();
            int debito = genDebyCred.debito();
            int credito = genDebyCred.credito(debito);
            
            // **** Asiento 1 ****
            
            int cuenta1 = (int)Math.floor(Math.random()*
            		(1-664)+664);
            //System.out.println(cuenta1);
            
            Element as1 = conta.addElement("Asiento");
            
            	Element libro = as1.addElement("Libro")
            			.addText( "COMUN" );
            
            	Element cuenta = as1.addElement("Cuenta");
            	
            		Element codCuenta = cuenta.addElement("Codigo")
            				.addText( codCuentas.get(cuenta1).toString() );
            
            		Element nomCuenta = cuenta.addElement("Nombre")
            				.addText( nomCuentas.get(cuenta1).toString() );
            		
	            Element terceroAs1 = as1.addElement("Tercero");
	            
	            	Element codTerceroAs1 = terceroAs1.addElement("Codigo")
	            			.addText( codigosTerceros.get(ter).toString() );
	            
	                Element nomTerceroAs1 = terceroAs1.addElement("Nombre")
	                		.addText( nombresTerceros.get(ter).toString() );
	                
	            Element debitoAs1 = as1.addElement("Debitos")
                		.addText( Integer.toString(debito) );
                
                Element creditoAs1 = as1.addElement("Creditos")
                		.addText( "" );
                
            // **** Asiento 2 ****
                
            int cuen2 = (int)Math.floor(Math.random()*
              		(1-664)+664);
            
            Element as2 = conta.addElement("Asiento");
                
            	Element libro2 = as2.addElement("Libro")
            			.addText( "COMUN" );
            
            	Element cuenta2 = as2.addElement("Cuenta");
            	
            		Element codCuenta2 = cuenta2.addElement("Codigo")
            				.addText( codCuentas.get(cuen2).toString() );
            
            		Element nomCuenta2 = cuenta2.addElement("Nombre")
            				.addText( nomCuentas.get(cuen2).toString() );
            		
	            Element terceroAs2 = as2.addElement("Tercero");
	            
	            	Element codTerceroAs2 = terceroAs2.addElement("Codigo")
	            			.addText( codigosTerceros.get(ter).toString() );
	            
	                Element nomTerceroAs2 = terceroAs2.addElement("Nombre")
	                		.addText( nombresTerceros.get(ter).toString() );
	                
	            Element debitoAs2 = as2.addElement("Debitos")
                		.addText( "" );
                
                Element creditoAs2 = as2.addElement("Creditos")
                		.addText( Integer.toString(credito) );
            
            }
            // lets write to a file
            String id = java.util.UUID.randomUUID().toString();
            id.replaceAll("-", "");
            id.substring(0, 10); 
            XMLWriter writer = new XMLWriter(
                new FileWriter( "salidas/comprobante-"+ (id) + ".xml" )
            );
            writer.write( document );
            writer.close();
           
        }
        return document;
    }

}
