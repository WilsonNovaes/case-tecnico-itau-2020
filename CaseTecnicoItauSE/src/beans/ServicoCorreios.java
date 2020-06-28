package beans;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;

public class ServicoCorreios {
	
	private String codigoServico;
	private String nomeServico;
	
	public ServicoCorreios(String _codigoServico, String _nomeServico) {
		codigoServico = _codigoServico;
		nomeServico = _nomeServico;
	}

	public String getCodigoServico() {
		return codigoServico;
	}

	public void setCodigoServico(String codigoServico) {
		this.codigoServico = codigoServico;
	}

	public String getNomeServico() {
		return nomeServico;
	}

	public void setNomeServico(String nomeServico) {
		this.nomeServico = nomeServico;
	}
	
	public static ArrayList<ServicoCorreios> retornaListaServicos() {
		try (InputStream input = new FileInputStream("aux_files/servicos.properties")) {
            Properties prop = new Properties();
            prop.load(input);
            prop.keySet();
            ArrayList<ServicoCorreios> servicos= new ArrayList<>();
            prop.forEach((k, v) -> {
            	servicos.add(new ServicoCorreios((String) k, (String) v));
            });
            
            return servicos;
            
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (Exception es) {
        	es.printStackTrace();
        }
		return null;
	}
	
}
