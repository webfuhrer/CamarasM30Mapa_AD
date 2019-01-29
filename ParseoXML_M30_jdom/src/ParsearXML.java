import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.xml.sax.InputSource;

public class ParsearXML {

	public static ArrayList<Camara> parsear(String texto_xml) {
		ArrayList<Camara> lista_camaras=new ArrayList<Camara>();
		SAXBuilder constructor=new SAXBuilder();
		InputSource entrada;
		try {
			entrada = new InputSource(new ByteArrayInputStream(texto_xml.getBytes("utf-8")));
			Document d=constructor.build(entrada);
			Element raiz=d.getRootElement();
			List<Element> lista_objetos_camaras=raiz.getChildren();
			
			for (Element elemento_camara : lista_objetos_camaras) {
				Element elemento_posicion=elemento_camara.getChild("Posicion");
				Element elemento_latitud=elemento_posicion.getChild("Latitud");
				Element elemento_longitud=elemento_posicion.getChild("Longitud");
				Element elemento_url=elemento_camara.getChild("URL");
				String latitud=elemento_latitud.getValue();
				String longitud=elemento_longitud.getValue();
				String url=elemento_url.getValue();
				Camara c=new Camara(Double.parseDouble(latitud), Double.parseDouble(longitud), "http://"+url);
				lista_camaras.add(c);
			}
		} catch (JDOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista_camaras;
	}

}
