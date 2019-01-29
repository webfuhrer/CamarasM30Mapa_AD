import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;



public class ConexionWeb {

	public static String hacerPeticion() {
		String aux=null;
		try {
		URL direccion_web = new URL("http://www.mc30.es/components/com_hotspots/datos/camaras.xml");
		URLConnection conexion_web = direccion_web.openConnection();
        BufferedReader br = new BufferedReader(new InputStreamReader(conexion_web.getInputStream()));
        String linea=br.readLine();
         aux="";
		        while(linea!=null)
		        {
		        	//System.out.println(linea);
		        	aux=aux+linea;//En aux estará todo el documento.
		        	
						linea=br.readLine();
					
		        
		        }
		        br.close();
		        
		}
        catch(Exception e)
        {
        	
        }
		return aux;
	}

}
