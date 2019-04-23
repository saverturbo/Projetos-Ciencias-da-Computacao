package interfacesgui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
/**
 * Esta classe cria a janela inicial do sistema.
 * @see javax.swing.JFrame
 */
public class TelaInicial extends JFrame{
	
	private static final long serialVersionUID = 1L;
	JLabel lblTitulo,lblIco,lblseta,lblseta1,lblseta2,lblbanco,lblSobre;
	JButton btnNovo, btnBuscar, btnEditar, btnExcluir,btnSobre, btnFechar, btnLog;
	private Container container ;
	
	/**
	 * Metodo construtor da classe TelaInicial.
	 */
	public TelaInicial() {
		
		// Configuracao de Icones------------------------------------------------------------------------
		Icon novo = new ImageIcon ("src\\icones\\novo.png");
		Icon psq = new ImageIcon ("src\\icones\\psq.png");
		Icon edit = new ImageIcon ("src\\icones\\alterar.png");
		Icon delete = new ImageIcon ("src\\icones\\dalete.png");
		Icon pc = new ImageIcon ("src\\icones\\pc.png");
		Icon seta = new ImageIcon ("src\\icones\\seta.png");
		Icon banco = new ImageIcon ("src\\icones\\data.png");
		Icon sobre = new ImageIcon ("src\\icones\\sobre.png");
		Icon close = new ImageIcon ("src\\icones\\fechar.png");
		Icon log = new ImageIcon("src\\icones\\log.png");
		//Instanciacao dos objetos-----------------------------------------------------------------------
		
		lblTitulo = new JLabel("TELA INICIAL");
		btnNovo = new JButton("NOVO",novo);
		btnBuscar = new JButton("BUSCAR",psq);
		btnEditar = new JButton("EDITAR",edit);
		btnExcluir = new JButton(" EXCLUIR",delete);
		btnFechar = new JButton("SAIR",close);
		btnLog = new JButton("LOGS",log);
		btnSobre = new JButton(sobre);
		lblSobre = new JLabel("Sobre:");
		lblTitulo = new JLabel("SISTEMA DE CADASTRO Ver.: 1.1");
		lblIco = new JLabel(pc);
		lblseta = new JLabel(seta);
		lblseta1 = new JLabel(seta);
		lblseta2 = new JLabel(seta);
		lblbanco = new JLabel(banco);
		
		//Configuracao do JFrame-------------------------------------------------------------------------
		setSize(300,500);
		setTitle("SISTEMA DE CADASTRO");
		setLocationRelativeTo(null);
		setVisible(true);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		//Pocionamento dos componentes no JFrame---------------------------------------------------------
		lblTitulo.setBounds(60, 0, 300, 50);
		lblIco.setBounds(20, 50, 80, 80);
		lblseta.setBounds(100, 65, 35, 35);
		lblseta1.setBounds(125, 65, 35, 35);
		lblseta2.setBounds(150, 65, 35, 35);
		lblbanco.setBounds(180, 50, 80, 80);
		btnNovo.setBounds(15, 170, 122, 50);
		btnBuscar.setBounds(145, 170, 122, 50);
		btnEditar.setBounds(15, 230, 122, 50);
		btnExcluir.setBounds(145, 230, 122, 50);
		btnLog.setBounds(15, 290, 122, 50);
		btnSobre.setBounds(235, 425, 30, 30);
		btnFechar.setBounds(145, 290, 120, 50);
		lblSobre.setBounds(190, 435, 50, 25);
		
		container = getContentPane();
		
		//Adiciona componentes ao JFrame-----------------------------------------------------------------
		container.add(lblTitulo);
		container.add(lblIco);
		container.add(btnNovo);
		container.add(btnBuscar);
		container.add(btnEditar);
		container.add(btnExcluir);
		container.add(btnLog);
		container.add(lblseta);
		container.add(lblseta1);
		container.add(lblseta2);
		container.add(lblbanco);
		container.add(btnSobre);
		container.add(lblSobre);
		container.add(btnFechar);
		
		btnSobre.addActionListener(about);
		btnEditar.addActionListener(editar);
		btnFechar.addActionListener(fecha);
		btnExcluir.addActionListener(excluir);
		btnNovo.addActionListener(novoContato);
		btnBuscar.addActionListener(buscarContato);
		btnLog.addActionListener(logs);
		
	}// Fim do construtor--------------------------------------------------------------------------------
		
	
	// Botao buscar--------------------------------------------------------------------------------
	ActionListener buscarContato = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			/**
			 * Metodo ({@code actionPerformed} que trata eventos do botao buscar.
			 * @param e. Espera parametro do tipo ActionEvent.
			 */
			Mediator.exibir();
			setVisible(false);
		}
	};
	
	// Botao novo--------------------------------------------------------------------------------
	ActionListener novoContato = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			Mediator.novo();
			setVisible(false);
		}
	};
	// Botao editar--------------------------------------------------------------------------------	
	ActionListener editar = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			Mediator.editar();
			setVisible(false);
			
		}
	};
	
	// Botao sobre--------------------------------------------------------------------------------
	ActionListener about = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			Mediator.sobre();
			setVisible(false);
			
		}
	};
	
	// Botao sair --------------------------------------------------------------------------------
	ActionListener fecha = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			//Fecha todas as conexoes.
			GerJanelasFacade.fecharConexao();
			dispose();
		}
	};
	//Botoao excluir --------------------------------------------------------------------------------
	ActionListener excluir = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			Mediator.excluir();
			setVisible(false);
			
		}
	};
	
	ActionListener logs = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			Mediator.logs();
			setVisible(false);
		}
	};
}// Fim da Classe----------------------------------------------------------------------------------------
