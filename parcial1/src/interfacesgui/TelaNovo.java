package interfacesgui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
/**
 * Classe responsavel pela criação da interface de inserção no banco.
 * @see javax.swing.JFrame
 */
public class TelaNovo extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	// Elementos como atributos da Classe----------------------------------------------------------------
	private JLabel lblNome, lblEndereco, lblTelefone, lblTelefone1, lblCPF, lblTipoSangue, lblFatorRh , lblCurso, lblCttEmerg,lblEmergencia;
	private JTextField txtNome, txtEndereco, txtCttEmerg;
	private final String [] listaSangue = {"...","A","B","AB","O"};
	@SuppressWarnings("rawtypes")
	private JComboBox cmbTipoSague,cmbFatorRh,cmbCurso;
	private final String [] listaTipoRh = {"...","+","-"};
	private final String [] listaCurso = {"...","Ciências da Computação","Outros"};
	private JFormattedTextField txtTelefone, txtCPF, txtTelefone1;
	private JButton btnInserir,btnLimpar, btnVoltar;
	private Container container;
	private JTable tblPrincipal;
	private String strColunas[] = {"Nome","Endereco","Telefone","CPF",};
	DefaultTableModel tableModel = new DefaultTableModel(strColunas,0);
	/**
	 * Metodo construtor da classe TelaNovo.
	 */
	public  TelaNovo() {
		
		//Labels da tela---------------------------------------------------------------------------------
		lblNome = new JLabel("Nome");
		lblEndereco = new JLabel("Endereço");
		lblTelefone = new JLabel("Telefone");
		lblTelefone1 = new JLabel("Telefone");
		lblCPF = new JLabel("CPF");
		lblTipoSangue = new JLabel("Tipo Sanguineo");
		lblFatorRh = new JLabel("Fator RH");
		lblCurso = new JLabel("Curso");
		lblCttEmerg = new JLabel("Contado de");
		lblEmergencia = new JLabel("Emergencia");
		tblPrincipal = new JTable(tableModel);
		
		//BOTAO COM ICONE--------------------------------------------------------------------------------
		
		Icon save = new ImageIcon ("src\\icones\\save.png");
		Icon limpa = new ImageIcon ("src\\icones\\limpa.png");
		Icon voltar = new ImageIcon ("src\\icones\\volta.png");
		// Campos da tela--------------------------------------------------------------------------------
		
		txtNome = new JTextField();
		txtEndereco = new JTextField();
		//JTable tblTable = new JTable();
		JScrollPane scrollPane = new JScrollPane(tblPrincipal);
		
		try {
			txtTelefone = new JFormattedTextField(new MaskFormatter("(##) ####-####"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			GerJanelasFacade.gravarLog(e.toString(), 75, "TelaNovo");
		}
		try {
			txtCPF = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			GerJanelasFacade.gravarLog(e.toString(), 82, "TelaNovo");
		}
		
		try {
			txtTelefone1 = new JFormattedTextField(new MaskFormatter("(##) ####-####"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			GerJanelasFacade.gravarLog(e.toString(), 90, "TelaNovo");
		}
		
		cmbTipoSague = new JComboBox<>(listaSangue);
		cmbFatorRh = new JComboBox<>(listaTipoRh);
		cmbCurso = new JComboBox<>(listaCurso);
		txtCttEmerg = new JTextField();
		btnInserir = new JButton("SALVAR",save);
		btnLimpar = new JButton("LIMPAR", limpa);
		btnVoltar = new JButton("Voltar", voltar);
		
		setSize(450,650);
		setTitle("Sistema de Cadastro");
		setLocationRelativeTo(null);
		setVisible(true);
		setLayout(null);
		
		container = getContentPane();
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		
		//Posicionamento dos elementos na tela.
		
		lblNome.setBounds(5, 10, 100, 25);
		txtNome.setBounds(110, 10, 250, 25);
		lblEndereco.setBounds(5, 50, 100, 25);
		txtEndereco.setBounds(110, 50, 250, 25);
		lblTelefone.setBounds(5, 100, 100, 25);
		txtTelefone1.setBounds(110, 100, 250, 25);
		lblCPF.setBounds(5, 150, 100, 25);
		txtCPF.setBounds(110, 150, 250, 25);
		lblTipoSangue.setBounds(5, 200, 100, 25);
		cmbTipoSague.setBounds(110, 200, 50, 25);
		lblFatorRh.setBounds(200, 200, 100, 25);
		cmbFatorRh.setBounds(260, 200, 50, 25);
		lblCurso.setBounds(5, 250, 100, 25);
		cmbCurso.setBounds(110, 250, 250, 25);
		lblCttEmerg.setBounds(5, 290, 100, 25);
		lblEmergencia.setBounds(5, 305, 100, 25);
		txtCttEmerg.setBounds(110, 300, 250, 25);
		lblTelefone1.setBounds(5, 350, 100, 25);
		txtTelefone.setBounds(110, 350, 250, 25);
		btnInserir.setBounds(25, 390, 120, 50);
		btnLimpar.setBounds(145, 390, 120, 50);
		btnVoltar.setBounds(265, 390, 120, 50);
		scrollPane.setBounds(10, 460, 363, 100);
		
		//Adicionando elementos a tela.
		
		container.add(lblNome);
		container.add(txtNome);
		container.add(lblEndereco);
		container.add(txtEndereco);
		container.add(lblTelefone);
		container.add(txtTelefone1);
		container.add(lblCPF);
		container.add(txtCPF);
		container.add(lblTipoSangue);
		container.add(cmbTipoSague);
		container.add(lblFatorRh);
		container.add(cmbFatorRh);
		container.add(lblCurso);
		container.add(cmbCurso);
		container.add(lblCttEmerg);
		container.add(txtCttEmerg);
		container.add(lblEmergencia);
		container.add(lblTelefone1);
		container.add(txtTelefone);
		container.add(btnInserir);
		container.add(btnLimpar);
		container.add(btnVoltar);
		container.add(scrollPane);

		//Chama o metodo de tratamento da acao;
		btnInserir.addActionListener(inserir);
		btnLimpar.addActionListener(limpar);
		btnVoltar.addActionListener(volta);
	}// Fim do Construtor.
	
	
	//Este trecho verifica se o cpf foi preencido
	boolean temNumeros(String texto) {
		   for (int i = 0; i < texto.length(); i++) {
		      if (Character.isDigit(texto.charAt(i))) 
		         return true;
		   }
		   return false;
		}

	///--------------------------ABAIXO O BLOCO DE CODIGO DO TRATAMENTO DO BOTAO NOVO ---------------------------------------------

	// Metodo de tratamento da acao do botao novo
	ActionListener inserir = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			//Validação de CPF e Nome.
			if((temNumeros(txtCPF.getText()) && (txtNome.getText().length() > 0))) {
				
				// Adiciona linha ao JTable
				tableModel.addRow(new Object[] {txtNome.getText(),txtEndereco.getText(),txtTelefone1.getText(),txtCPF.getText()});
				Cadastro  cadastro = new Cadastro();
				cadastro.setNome(txtNome.getText());
				cadastro.setEndereco(txtEndereco.getText());
				cadastro.setTelefone(txtTelefone1.getText());
				cadastro.setCpf(txtCPF.getText());
				cadastro.setTipoSangue(cmbTipoSague.getSelectedItem().toString());
				cadastro.setFatorRh(cmbFatorRh.getSelectedItem().toString());
				cadastro.setCurso(cmbCurso.getSelectedItem().toString());
				cadastro.setCttEmerg(txtCttEmerg.getText());
				cadastro.setTelCttEmerg(txtTelefone.getText());
				
				//Limpar os campos
				txtNome.setText("");
				txtCPF.setText("");
				
				//new ConexaoBD().insertInto(cadastro);
				GerJanelasFacade.salvarDados(cadastro);
			}else {
				JOptionPane.showMessageDialog(null, "Os campos Nome e CPF não podem ser vazios", "Alerta",JOptionPane.WARNING_MESSAGE);
				txtNome.setText("");
				txtCPF.setText("");
			}
		}
	};
	
	//Botao limpar ------------------------------------------------------------------------------
	ActionListener limpar = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			tableModel.setNumRows(0);
			txtNome.setText(""); 
			txtEndereco.setText("");
			txtTelefone1.setText("");
			txtCPF.setText("");
			cmbTipoSague.setSelectedItem(0);
			cmbFatorRh.setSelectedItem(0);
			cmbCurso.setSelectedItem(0);
			txtCttEmerg.setText("");
			txtTelefone.setText("");
			
		}
	};
	//Botao voltar --------------------------------------------------------------------------------
	ActionListener volta = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			dispose();
			Mediator.inicial();
		}
	};
}// Fim da Classe ---------------------------------------------------------------------------------------
