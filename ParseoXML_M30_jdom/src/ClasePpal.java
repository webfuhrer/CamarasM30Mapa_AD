import java.util.ArrayList;

public class ClasePpal {
	public static void main(String[] args) {
		String texto_xml=ConexionWeb.hacerPeticion();
		ArrayList<Camara> lista_camaras=ParsearXML.parsear(texto_xml);
		
		SalidaFichero.crearTabla(lista_camaras);
	}
}
