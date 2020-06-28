package app;

import telas.TelaPrototipo;

public class ClassePrincipal {

	public static void main(String[] args) {
		Tester tester = new Tester();
		tester.run();
		
		TelaPrototipo janela = new TelaPrototipo();
		janela.show();
	}

}
