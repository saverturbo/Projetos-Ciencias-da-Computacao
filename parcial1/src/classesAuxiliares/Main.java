package classesAuxiliares;

import interfacesgui.GerJanelasFacade;

/**
 * Projeto da Parcial adaptado para Padrões de Projeto, criado Log de Erros e Gerada documentação do sistema. 
 * @author Hudor Champoudry, Gustavo Souza, Johnnystefany Magalhães, Joserio Carvalho e Tobias Silva.
 * @since 2.0
 */
public class Main {
	/**
	 *O metodo {@code main} inicia o sistema chamando a Classe gerenciador de janelas e iniciando o metodo inicial
	 *@param args paramentro esperado pelo metodo main().
	 */
	public static void main(String[] args) {
		
		//Chamada antiga da tela inicial direto pela classe;
		//new TelaInicial();
		
		//Chamada nova ao metodo inicial do gerenciador de janelas Facade
				GerJanelasFacade.inicial();
	
	}
}

