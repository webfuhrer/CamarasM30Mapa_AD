import java.io.IOException;
import java.util.ArrayList;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class ClasePpal {
	public static void main(String[] args) {
//		String texto_xml=ConexionWeb.hacerPeticion();
//		ArrayList<Camara> lista_camaras=ParsearXML.parsear(texto_xml);
//		
//		SalidaFichero.crearTabla(lista_camaras);
		Element elemento_raiz=new Element("agenda");
		Document d=new Document(elemento_raiz);
		Element elemento_contacto=new Element("contacto");
		Element elemento_nombre=new Element("nombre");
		elemento_nombre.setText("Pepe");
		elemento_contacto.addContent(elemento_nombre);
		elemento_raiz.addContent(elemento_contacto);
		System.out.println(elemento_raiz.toString());
		XMLOutputter xmlOutput = new XMLOutputter();

        // display ml
        xmlOutput.setFormat(Format.getPrettyFormat());
        try {
			xmlOutput.output(elemento_raiz, System.out);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
