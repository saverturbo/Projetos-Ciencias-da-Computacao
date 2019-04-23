package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import interfacesgui.Cadastro;

public class ConexaoBD {

	private Connection conexao;
	private final String strConexao = "jdbc:mysql://localhost:3306/dbaula?useTimezone=true&serverTimezone=UTC&useSSL=false";
	private final String usuario = "root";
	private final String senha = "";
	
	public PreparedStatement statment;
	
	public ConexaoBD(){
		
		/// --------------------------ABAIXO O BLOCO DE CODIGO DE CONFIGURACAO DA CONEXAO COM BANCO ---------------------------------------------
		 
		
		//Tentative of Connection------------------------------------------------------------------------
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexao = DriverManager.getConnection(strConexao,usuario,senha);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	/// -------------------------FIM DO CODIGO DE CONFIGURACAO DA CONEXAO COM BANCO ---------------------------------------------

	/// --------------------------INICIO O BLOCO DE CODIGO DAS REQUISICOES SQL ---------------------------------------------

	//Metodo do InsertInto-------------------------------------------------------------------------------
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
			fecharConexao();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}//Fim do metodo InsertInto--------------------------------------------------------------------------

	//Select from sem parametro  ------------------------------------------------------------------------
	public ResultSet selectFrom() {
		
		ResultSet rs = null;
		
		try {
			statment = conexao.prepareStatement("select *from cadastro");
			rs = statment.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
	}// FIM Select from sem parametro  -------------------------------------------------------------------
	
	//Select from com parametro nome --------------------------------------------------------------------
	public ResultSet selectFrom(String pesquisa) {
		
		ResultSet rs = null;
		
		try {
			
			statment = conexao.prepareStatement("select *from cadastro  where  nome = '"+ pesquisa + "'");
			rs = statment.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;

	}// Fim do Select por nome---------------------------------------------------------------------------

	// ALterar um registro ------------------------------------------------------------------------------
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
				fecharConexao();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}//Fim do metodo AlterTable--------------------------------------------------------------------------
	
	// Metodo que apaga um registro do banco
	public void deleteFrom (int id) {
		try {
			
			statment = conexao.prepareStatement("DELETE from cadastro  WHERE id = ?");
			statment.setInt(1, id);
			statment.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}//Fim 

	/// --------------------------FIM DO CODIGO DAS REQUISICOES SQL --------------------------------------------->>>>

	// Metodo que fecha a Conexao com o banco de dados---------------------------------------------------
		public void fecharConexao() {
				
				try {
					conexao.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}// Fim fecharConexao------------------------------------------------------------------------
		
}//Fim da classe de ConexaoDB------------------------------------------------------------------------------
