package logErros;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;
/**
 * Esta classe é a responsavel pelo registro dos erros gerados pela execução do sistema.
 * @see java.io.File
 * @see java.io.FileWriter
 */
public class LogDeErro {
	/**
	 *O metodo {@code gravaErro} cria um arquivo de log de erro ou atualiza caso ja exista.
	 *@param erro exibe o tipo erro gerado.
	 *@param linha registra linha onde o erro ocorreu.
	 *@param classe indica a classe que gerou o erro.
	 */
	public static void gravarErro(String erro, int linha, String classe){
		
		File arquivo = new File("src\\logErros\\dir_log_erro\\Log_erro.txt");
		
		if(arquivo.exists() == false) {
				try {
					arquivo.createNewFile();
					FileWriter gravador = new FileWriter(arquivo);
					gravador.write("Erro: "+ erro + "// Linha:" +linha + "// Classe: "+ classe);
					gravador.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, e, "Erro!", JOptionPane.ERROR_MESSAGE);
				}
				
		}else {
				try {
					FileWriter gravador = new FileWriter(arquivo,true);
					BufferedWriter bufferedWriter = new BufferedWriter(gravador);
					bufferedWriter.newLine();
					bufferedWriter.write("Erro: "+ erro + "// Linha:" +linha + "// Classe: "+ classe);
					bufferedWriter.close();
					gravador.close();
				}catch (IOException e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, e, "Erro!", JOptionPane.ERROR_MESSAGE);
				}
		}
	}
	/**
	 *O metodo {@code apagarRegistros} apaga todos os registros de erro do arquivo.
	 */
	public void apagarRegistros() {
		
		File arquivo = new File("src\\logErros\\dir_log_erro\\Log_erro.txt");
		if(arquivo.exists() == true) {
			arquivo.delete();
			try {
				arquivo.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, e, "Erro!", JOptionPane.ERROR_MESSAGE);
			}
		}	
	}
}
