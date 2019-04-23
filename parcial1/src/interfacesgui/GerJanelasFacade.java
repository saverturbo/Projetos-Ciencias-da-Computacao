package interfacesgui;

import java.sql.ResultSet;

import conexao.ConexaoSingleton;
import logErros.LogDeErro;
/**
 * Classe responsavel por oferecer uma fachada(FACADE) aos componetes externos do sistema de 
 * acordo com a estrutura de padrao de projetos Facade.
 */
public class GerJanelasFacade {
	/**
	 * O metodo {@code inicial} recebe a chamada da main e inicializa o mediador de 
	 * classes do pacote gui chamando o metodo da janela correspondente.
	 */
	public static void inicial() {
		
		// Chama o mediador do pacote e solicita uma janela.
	  Mediator.inicial();
	}
	/**
	 * O metodo {@code apagarLog} Solicita o acesso a um metodo de outro pacote
	 */
	public static void apagarLog() {
		
		// apaga os registros do log de erro.
		new LogDeErro().apagarRegistros();
	}
	/**
	 * O metodo {@code gravarLog} Solicita o a um metodo de outro pacote
	 * @param erro o erro que ocorreu
	 * @param linha de codigo que apresentou erro
	 * @param classe em qual classe o erro ocorreu
	 */
	public static void gravarLog(String erro, int linha, String classe) {
		
		// grava os registros do log de erro.
		LogDeErro.gravarErro(erro, linha, classe);
	}
	/**
	 * O metodo {@code salvarDados} Solicita uma gravação a classe de conexao.
	 * @param cad o cadastro com dos a serem salvos.
	 */
	public static void salvarDados(Cadastro cad) {
		
		ConexaoSingleton.getInstance().insertInto(cad);
	}
	/**
	 * O metodo {@code buscarDados} Solicita uma busca a classe de conexao.
	 * @return ResultSet dados encontrados
	 */
	public static ResultSet buscarDados() {
		
		return ConexaoSingleton.getInstance().selectFrom();
	}
	/**
	 * O metodo {@code buscarDados} Solicita uma busca a classe de conexao.
	 * @param nome a ser pesquisado.
	 * @return ResultSet dados encontrados
	 */
	public static ResultSet buscarDados(String nome) {
		
		return ConexaoSingleton.getInstance().selectFrom(nome);
	}
	/**
	 * O metodo {@code apagarDados} Solicita uma exclusao a classe de conexao.
	 * @param id do cadastro a ser exluido.
	 */
	public static void apagarDados(int id) {
		
		ConexaoSingleton.getInstance().deleteFrom(id);;
	}
	/**
	 * O metodo {@code salvarDados} Solicita uma alteração a classe de conexao.
	 * @param cad o cadastro com dos a serem alterados.
	 */
	public static void alterarDados(Cadastro cad) {
		
		ConexaoSingleton.getInstance().alterTable(cad);
	}
	/**
	 * O metodo {@code salvarDados} Solicita o fechamento da conexao.
	 */
	public static void fecharConexao() {
		
		ConexaoSingleton.getInstance().fecharConexao();
	}
}
