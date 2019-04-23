package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import interfacesgui.Cadastro;
import logErros.LogDeErro;
/**
 * Classe de Conexao que implementa o padrao de projeto criacional Singleton.
 * @see java.sql.Connection
 */
public class ConexaoSingleton {
	
	private Connection conexao;
	private final String strConexao = "jdbc:mysql://localhost:3306/banco_teste_singleton?useTimezone=true&serverTimezone=UTC&useSSL=false";
	private final String usuario = "root";
	private final String senha = "";
	public PreparedStatement statment;
	public static ConexaoSingleton instancia;
	
	/**
	 * Construtor da classe ConexaoSingleton
	 */
	private ConexaoSingleton() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexao = DriverManager.getConnection(strConexao,usuario,senha);
			System.out.println("Conectado com Sucesso!");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			LogDeErro.gravarErro(e.toString(), 33, "ConexaoSingleton");
			JOptionPane.showMessageDialog(null, e, "Erro!", JOptionPane.ERROR_MESSAGE);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			LogDeErro.gravarErro(e.toString(), 33, "ConexaoSingleton");
			JOptionPane.showMessageDialog(null, e, "Erro!", JOptionPane.ERROR_MESSAGE);
		}
	}
	/**
	 * O metodo {@code ConexaoSingleton} verifica se alguma instancia da classe ja foi criada e retorna a mesma.
	 * @return instancia a instancia da conexao
	 */
	public static ConexaoSingleton getInstance() {
		
		
		if(instancia == null) {
			instancia = new ConexaoSingleton();
		}
		
		return instancia;
	}
	
	/// Area das Queries Sql ----------------------------------------------------------------------------------------
	/**
	 * O metodo {@code insertInto} persiste dados recebidos do usuario no banco de dados.
	 * @param cadastro contem os dados a serem salvos.
	 */
	public void insertInto(Cadastro cadastro) {
		
		try {
			statment = conexao.prepareStatement("insert into cadastro (nome,endereco,telefone,cpf,tiposanguineo,fatorrh,curso,cttemergencia,telcttemerg) values (?,?,?,?,?,?,?,?,?)");
			statment.setString(1, cadastro.getNome());
			statment.setString(2, cadastro.getEndereco());
			statment.setString(3, cadastro.getTelefone());
			statment.setString(4, cadastro.getCpf());
			statment.setString(5, cadastro.getTipoSangue());
			statment.setString(6, cadastro.getFatorRh());
			statment.setString(7, cadastro.getCurso());
			statment.setString(8, cadastro.getCttEmerg());
			statment.setString(9, cadastro.getTelCttEmerg());
			
			//Executa a query----------------------------------------------------------------------------
			statment.execute();
			//Fecha conexao------------------------------------------------------------------------------
			
			//conexao.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			LogDeErro.gravarErro(e.toString(), 62, "ConexaoSingleton");
			JOptionPane.showMessageDialog(null, e, "Erro!", JOptionPane.ERROR_MESSAGE);
		}
		
	}//Fim do metodo InsertInto--------------------------------------------------------------------------

	//Select from sem parametro  ------------------------------------------------------------------------
	/**
	 * O metodo {@code selectFrom} Faz uma busca sem parametros no banco.
	 * @return rs O result set de registros da busca.
	 */
	public ResultSet selectFrom() {
		
		ResultSet rs = null;
		try {
			statment = conexao.prepareStatement("select *from cadastro");
			rs = statment.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
			LogDeErro.gravarErro(e.toString(), 97, "Conexao Singleton");
		}
		
		return rs;
	}// FIM Select from sem parametro  -------------------------------------------------------------------
	
	//Select from com parametro nome --------------------------------------------------------------------
	/**
	 * O metodo {@code selectFrom} o mesmo metodo de busca, porem desta vez com parametro para a busca.
	 * @param pesquisa. Um termo para busca por nome no banco.
	 * @return rs o resgistro encontrado na busca
	 */
	public ResultSet selectFrom(String pesquisa) {
		
		
		ResultSet rs = null;
		
		try {
			statment = conexao.prepareStatement("select *from cadastro  where  nome = '"+ pesquisa + "'");
			rs = statment.executeQuery();
		} catch (SQLException e) {
		    	e.printStackTrace();
		    	LogDeErro.gravarErro(e.toString(), 119, "Conexao Singleton");
		}
		return rs;
	}// Fim do Select por nome---------------------------------------------------------------------------

	// ALterar um registro ------------------------------------------------------------------------------
	/**
	 * O metodo {@code alterTable} metodo responsavel por alterar dados de um registro especifico.
	 * @param cadastro contem os novos dados que devem ser salvos no banco.
	 */
	public void alterTable(Cadastro cadastro) {
		
		try {
			statment = conexao.prepareStatement("UPDATE cadastro SET nome = ?, endereco =?, telefone = ?, cpf = ?, tiposanguineo = ?,fatorrh = ? ,curso = ? ,cttemergencia = ?,telcttemerg = ? WHERE id = ?");
			statment.setString(1, cadastro.getNome());
			statment.setString(2, cadastro.getEndereco());
			statment.setString(3, cadastro.getTelefone());
			statment.setString(4, cadastro.getCpf());
			statment.setString(5, cadastro.getTipoSangue());
			statment.setString(6, cadastro.getFatorRh());
			statment.setString(7, cadastro.getCurso());
			statment.setString(8, cadastro.getCttEmerg());
			statment.setString(9, cadastro.getTelCttEmerg());
			statment.setInt(10, cadastro.getId());
	
			//Executa a query------------------------------------------------------------------------
			statment.executeUpdate();
				
			//Fecha conexao--------------------------------------------------------------------------
			//fechar Conexao();
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			LogDeErro.gravarErro(e.toString(),135, "Conexao Singleton");
		}

	}//Fim do metodo AlterTable--------------------------------------------------------------------------
	
	// Metodo que apaga um registro do banco
	/**
	 * O metodo {@code deleteFrom} busca e apaga definitivamente um registro do banco.
	 * @param id do registro a ser deletado
	 */
	public void deleteFrom (int id) {
		
		try {
			statment = conexao.prepareStatement("DELETE from cadastro  WHERE id = ?");
			statment.setInt(1, id);
			statment.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			LogDeErro.gravarErro(e.toString(), 168, "Conexao Singleton");
		}
	}//Fim deleteFrom -------------------------------------------------------------------------------

	/// --------------------------FIM DO CODIGO DAS REQUISICOES SQL --------------------------------------------->>>>

	// Metodo que fecha a Conexao com o banco de dados---------------------------------------------------
	/**
	 * O metodo {@code fecharConexao} fecha a conexao com o banco.
	 */	
	public void fecharConexao() {
			
			try {
					conexao.close();
					System.out.println("Conexao Finalizada!");
			} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					LogDeErro.gravarErro(e.toString(), 186, "Conexao Singleton");
			}
		}// Fim fecharConexao------------------------------------------------------------------------
}//Fim da classe de ConexaoSingleton------------------------------------------------------------------------------