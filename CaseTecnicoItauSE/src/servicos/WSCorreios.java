package servicos;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Properties;

public class WSCorreios {
	
	private HashMap<String, String> parametros;
	private String url;
	private String urlAux;
	
	
	public WSCorreios() {
		parametros = new HashMap<>();
		url = "http://ws.correios.com.br/calculador/CalcPrecoPrazo.aspx";
		try (InputStream input = new FileInputStream("aux_files/WSCorreios.properties")) {
            Properties prop = new Properties();
            prop.load(input);
            prop.forEach((key, value) -> parametros.put((String) key ,(String) value));
            
		} catch (IOException io_ex) {
			io_ex.printStackTrace();
		}
	}
	
	
	public HashMap<String, String> getParametros() {
		return parametros;
	}

	public void setParametros(HashMap<String, String> parametros) {
		this.parametros = parametros;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setParametro(String chave, String valor) {
		parametros.put(chave, valor);
	}
	
	public void getParametros(String chave) {
		parametros.get(chave);
	}
	
	
	public String retiraUltimoCaractere(String str) {
	    if (str != null && str.length() > 0 && str.charAt(str.length() - 1) == 'x') {
	        str = str.substring(0, str.length() - 1);
	    }
	    return str;
	}
	
	private String preparaURL(String _url) {
		urlAux = _url+"?";
		parametros.entrySet().forEach(entry->{
			urlAux+=entry.getKey() + "=" + entry.getValue()+"&";
         });

		urlAux = retiraUltimoCaractere(urlAux);
		return urlAux;
	}
	
	public String solicitaGET() {

		try {
			
			URL url = new URL(preparaURL(getUrl()));
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(
				(conn.getInputStream())));

			String output;
			StringBuilder totalOut =  new StringBuilder();
			
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				totalOut.append(output);
			}
			
			System.out.println(totalOut);
			
			conn.disconnect();
			return totalOut.toString();

		  } catch (MalformedURLException e) {
			e.printStackTrace();
		  } catch (IOException e) {
			e.printStackTrace();
		  } 
		
		
		return null;
	}

}
