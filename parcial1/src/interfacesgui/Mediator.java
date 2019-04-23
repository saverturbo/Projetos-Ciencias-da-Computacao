package interfacesgui;
/**
 * Classe responsavel pela mediação da comunicação entre as classes do mesmo subsistema de  
 * acordo com a estrutura de padrao de projetos Mediator.
 */
public class Mediator {
	/**
	 * O metodo {@code inicial} recebe a chamada da classe Facade e disponibiliza a janela  
	 * solicitada.
	 * @return new TelaInicial a janela solicitada TelaInicial.
	 */
	public static TelaInicial inicial() {
		
		return new TelaInicial();
	}
	/**
	 * O metodo {@code editar} recebe a chamada da classe Facade e disponibiliza a janela  
	 * solicitada.
	 * @return new TelaEditar a janela solicitada .
	 */
	public static TelaEditar editar() {
		
		return new TelaEditar();
	}
	/**
	 * O metodo {@code excluir} recebe a chamada da classe Facade e disponibiliza a janela  
	 * solicitada.
	 * @return new TelaExcluir a janela solicitada .
	 */
	public static TelaExcluir excluir() {
		
		return new TelaExcluir();
	}
	/**
	 * O metodo {@code exibir} recebe a chamada da classe Facade e disponibiliza a janela  
	 * solicitada.
	 * @return new TelaExibir a janela solicitada .
	 */
	public static TelaExibir exibir() {
		
		return new TelaExibir();
	}
	/**
	 * O metodo {@code novo} recebe a chamada da classe Facade e disponibiliza a janela  
	 * solicitada.
	 * @return new TelaNovo a janela solicitada .
	 */
	public static TelaNovo novo() {
		
		return new TelaNovo();
	}
	/**
	 * O metodo {@code sobre} recebe a chamada da classe Facade e disponibiliza a janela  
	 * solicitada.
	 * @return new TelaSobre a janela solicitada .
	 */
	public static TelaSobre sobre() {
		
		return new TelaSobre();
	}
	/**
	 * O metodo {@code logs} recebe a chamada da classe Facade e disponibiliza a janela  
	 * solicitada.
	 * @return new TelaLogs a janela solicitada .
	 */
	public static TelaLogs logs() {
		
		return new TelaLogs();
	}
}
