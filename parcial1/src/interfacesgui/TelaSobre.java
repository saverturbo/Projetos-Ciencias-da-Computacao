package interfacesgui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
/**
 * Classe TelaSobre exibe informaçoes sobre o trabalho para obtenção da nota da Parcial 2
 * e o grupo de desenvolvimento do sistema.
 * @see javax.swing.JFrame
 */
public class TelaSobre extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JLabel lblTitulo;
	private JButton btnFechar;
	private Container container;
	private final static String newline = "\n";
	/**
	 * O metodo {@code TelaSobre} é o metodo construtor da classe
	 */
	public TelaSobre() {
		
				
		// Configuracao de Icones------------------------------------------------------------------------
		Icon fechar = new ImageIcon ("src\\icones\\fechar.png");

		//Configuracao do JFrame-------------------------------------------------------------------------
		setSize(300,500);
		setTitle("SISTEMA DE CADASTRO");
		setLocationRelativeTo(null);
		setVisible(true);
		setLayout(null);
		container = getContentPane();
		
		//Instanciacao dos objetos-----------------------------------------------------------------------
		
		lblTitulo = new JLabel("Sobre esta aplicação . . .");
		btnFechar = new JButton("FECHAR",fechar);
		btnFechar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				Mediator.inicial();
			}
		});
		
		JTextArea area = new JTextArea(20,20);
		area.setEditable(false);
	
		area.append(" Este aplicativo foi desenvolvido como "+ newline +" trabalho da Avaliação Parcial II, da disciplina" + newline
				+ " Programação Orientada a Objetos II."+ newline 
				+ " Faculdade Pitágoras, 6º Período - Noturno." + newline 
				+ "\n Professor: Msc. Roberth Silva. " + newline
				+ "\n Equipe:\tGustavo Souza;\n"
				+ "\t Hudor Champoudry;\n"
				+ "\t Johnystefany Magalhães;\n"
				+ "\t Joserio Carvalho; e\n"
				+ "\t Tobias Silva.");
	
		//Pocionamento dos componentes no JFrame---------------------------------------------------------
		lblTitulo.setBounds(10, 0, 300, 50);
		area.setBounds(10, 50, 260, 260);
		btnFechar.setBounds(90, 350, 122, 50);

		//Adiciona componentes ao JFrame-----------------------------------------------------------------
		container.add(lblTitulo);
		container.add(area);
		container.add(btnFechar);

	}

}
