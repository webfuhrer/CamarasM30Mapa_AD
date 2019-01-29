import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class SalidaFichero {

	public static void crearTabla(ArrayList<Camara> lista_camaras) {
		String aux="<html><head><style>.clase_capa_mapa{width: 300px;height: 300px}</style></head><body><table>";
		int i=0;
		for (Camara camara : lista_camaras) {
			aux+="<tr><td><div class='clase_capa_mapa' id='capa_mapa"+i+"' ></div></td><td><img src='"+camara.getUrl()+"'></td></tr>";
			i++;
					
		}
		
		aux+="</table></body>"+insertarFuncionJavascript(lista_camaras)+"<script async defer  src=\"https://maps.googleapis.com/maps/api/js?key=AIzaSyA2nnTwxI_6v6FgZQ_HYALbkWsL3qhFjT4&callback=mostrarMapa\"></script></html>";
		
		try {
			FileWriter fw=new FileWriter("tabla_m30.html");
			fw.write(aux);
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static String insertarFuncionJavascript(ArrayList<Camara> lista_camaras) {
		String aux="<script>\nfunction mostrarMapa() {";
		for (int i=0; i<lista_camaras.size(); i++)
		{
			Camara c=lista_camaras.get(i);
			aux+="var centro_"+i+"={lat:"+c.getLatitud()+", lng:"+c.getLongitud()+"};\n";
			aux+="var mapa_"+i+"=new google.maps.Map(document.getElementById('capa_mapa"+i+"'), {center:centro_"+i+", zoom: 15});\n";
			aux+="var marcador_"+i+"= new google.maps.Marker({position: centro_"+i+", map:mapa_"+i+"});\n";
			
		}
		aux+="}\n</script>";
		return aux;
	}

}
