package interfacesgui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
/**
 * Esta classe cria a janela de Logs do sistema.
 * @see javax.swing.JFrame
 */
public class TelaLogs extends JFrame{
	
	private static final long serialVersionUID = 1L;
	JLabel lblLog;
	JButton btnAbrir, btnTestar, btnLimpar, btnVoltar;
	private Container container ;
	/**
	 * Metodo construtor da classe TelaLogs.
	 */
	public TelaLogs() {
		
		// Configuracao de Icones------------------------------------------------------------------------
		Icon abrir = new ImageIcon ("src\\icones\\log.png");
		Icon test = new ImageIcon ("src\\icones\\test.png");
		Icon limpar = new ImageIcon ("src\\icones\\limpa.png");
		Icon logBig = new ImageIcon ("src\\icones\\logBig.png");
		Icon volta = new ImageIcon ("src\\icones\\volta.png");
		
		//Instanciacao dos objetos-----------------------------------------------------------------------
	
		btnAbrir = new JButton("ABRIR",abrir);
		btnTestar = new JButton("TESTAR",test);
		btnLimpar = new JButton("LIMPAR",limpar);
		btnVoltar = new JButton("VOLTAR",volta);
		lblLog = new JLabel(logBig);

		//Configuracao do JFrame-------------------------------------------------------------------------
		setSize(300,500);
		setTitle("MENU DE LOGS");
		setLocationRelativeTo(null);
		setVisible(true);
		setLayout(null);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Pocionamento dos componentes no JFrame---------------------------------------------------------
		
		lblLog.setBounds(100, 20, 100, 100);
		btnAbrir.setBounds(90, 150, 122, 50);
		btnTestar.setBounds(90, 210, 122, 50);
		btnLimpar.setBounds(90, 270, 122, 50);
		btnVoltar.setBounds(90, 330, 122, 50);
		container = getContentPane();
		
		//Adiciona componentes ao JFrame-----------------------------------------------------------------
		
		container.add(lblLog);
		container.add(btnAbrir);
		container.add(btnTestar);
		container.add(btnLimpar);
		container.add(btnVoltar);
		
		btnAbrir.addActionListener(open);
		btnTestar.addActionListener(testar);
		btnLimpar.addActionListener(clr);
		btnVoltar.addActionListener(retr);
	}

	ActionListener open = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				//Abre o arquivo de log.
				Runtime.getRuntime().exec("notepad src\\logErros\\dir_log_erro\\log_erro.txt");
			} catch (IOException e1) {
			// TODO Auto-generated catch block
				e1.printStackTrace();
				GerJanelasFacade.gravarLog(e1.toString(), 208, "TelaLogs");
			}
		}
	};
	
	ActionListener testar = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			GerJanelasFacade.gravarLog("Teste de Log", 102, "TelaLogs");
			JOptionPane.showMessageDialog(btnTestar, "Um registro de Teste foi criado!" +"\n" +"Por favor verifique o arquivo de Log!", "Testar Log", JOptionPane.INFORMATION_MESSAGE);
		}
	};
	
	ActionListener clr = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(JOptionPane.showConfirmDialog(btnLimpar, "Apagar todos os registros de LOG?","ATENÇÃO",JOptionPane.OK_CANCEL_OPTION) == 0) {
				GerJanelasFacade.apagarLog();
				JOptionPane.showMessageDialog(btnLimpar, "Dados apagados com sucesso!","ATENÇÃO", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	};
	
	ActionListener retr = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			dispose();
			Mediator.inicial();
		}
	};
}
