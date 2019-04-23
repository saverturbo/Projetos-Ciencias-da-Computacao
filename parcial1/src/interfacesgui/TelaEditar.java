package interfacesgui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;
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
 * Esta classe cria a janela de edição de dados.
 * @see javax.swing.JFrame
 */
public class TelaEditar extends JFrame {
	
	
	private static final long serialVersionUID = 1L;
	// Elementos como atributos da Classe-----------------------------------------------------------------
	private	Cadastro c = new Cadastro();
	private JLabel lblPesquisa,lblNome, lblEndereco, lblTelefone, lblTelefone1, lblCPF, lblTipoSangue, lblFatorRh , lblCurso, lblCttEmerg,lblEmergencia;
	private JTextField txtNome, txtEndereco, txtCttEmerg,txtPesquisa;
	@SuppressWarnings("rawtypes")
	private JComboBox cmbTipoSague,cmbFatorRh,cmbCurso;
	private JFormattedTextField txtTelefone, txtCPF, txtTelefone1;
	private JButton btnBuscar, btnEditar, btnFechar,btnSave; 
	private Container container;
	private JTable tblPrincipal;
	private String strColunas[] = {"","Id","Nome","Endereco","Telefone","CPF","Sangue", "Fator RH","Curso","",""};
	private ResultSet res;
	private final String [] listaSangue = {"...","A","B","AB","O"};
	private final String [] listaTipoRh = {"...","+","-"};
	private final String [] listaCurso = {"...","Ciências da Computação","Outros"};
	DefaultTableModel tableModel = new DefaultTableModel(strColunas,0);
		
	//Contrutor da Classe--------------------------------------------------------------------------------
	/**
	 * Metodo construtor da classe TelaEditar.
	 */
	public TelaEditar() {
		
		//Labels da tela---------------------------------------------------------------------------------
		lblPesquisa = new JLabel("PESQUISAR");
		txtPesquisa= new JTextField();
		lblNome = new JLabel("Nome");
		lblEndereco = new JLabel("End.");
		lblTelefone = new JLabel("Telefone");
		lblTelefone1 = new JLabel("Telefone");
		lblCPF = new JLabel("CPF");
		lblTipoSangue = new JLabel("Tipo Sanguineo");
		lblFatorRh = new JLabel("Fator RH");
		lblCurso = new JLabel("Curso");
		lblCttEmerg = new JLabel("Contato de");
		lblEmergencia = new JLabel("Emergencia");
		tblPrincipal = new JTable(tableModel);
		
		//Configuração linhas da JTable
		
		tblPrincipal.getColumnModel().getColumn(0).setMinWidth(30);
		tblPrincipal.getColumnModel().getColumn(0).setPreferredWidth(0);
		tblPrincipal.getColumnModel().getColumn(0).setMaxWidth(30);
		tblPrincipal.getColumnModel().getColumn(0).setCellRenderer(new CellRenderer());
		tblPrincipal.getColumnModel().getColumn(1).setMinWidth(0);
		tblPrincipal.getColumnModel().getColumn(1).setPreferredWidth(0);
		tblPrincipal.getColumnModel().getColumn(1).setMaxWidth(0);
		tblPrincipal.getColumnModel().getColumn(10).setMinWidth(0);
		tblPrincipal.getColumnModel().getColumn(10).setPreferredWidth(0);
		tblPrincipal.getColumnModel().getColumn(10).setMaxWidth(0);
		tblPrincipal.getColumnModel().getColumn(6).setMinWidth(0);
		tblPrincipal.getColumnModel().getColumn(6).setPreferredWidth(0);
		tblPrincipal.getColumnModel().getColumn(6).setMaxWidth(0);
		tblPrincipal.getColumnModel().getColumn(7).setMinWidth(0);
		tblPrincipal.getColumnModel().getColumn(7).setPreferredWidth(0);
		tblPrincipal.getColumnModel().getColumn(7).setMaxWidth(0);
		tblPrincipal.getColumnModel().getColumn(8).setMinWidth(0);
		tblPrincipal.getColumnModel().getColumn(8).setPreferredWidth(0);
		tblPrincipal.getColumnModel().getColumn(8).setMaxWidth(0);
		tblPrincipal.getColumnModel().getColumn(9).setMinWidth(0);
		tblPrincipal.getColumnModel().getColumn(9).setPreferredWidth(0);
		tblPrincipal.getColumnModel().getColumn(9).setMaxWidth(0);
		tblPrincipal.setRowHeight(26);

		//Adiciona icones aos botoes---------------------------------------------------------------------
		Icon bsc = new ImageIcon ("src\\icones\\bsc.png");
		Icon edit = new ImageIcon ("src\\icones\\edit.png");
		Icon fechar = new ImageIcon ("src\\icones\\volta.png");
		Icon save = new ImageIcon ("src\\icones\\save.png");

		// Campos da tela--------------------------------------------------------------------------------
		txtNome = new JTextField();
		txtEndereco = new JTextField();
		JScrollPane scrollPane = new JScrollPane(tblPrincipal);
		
		try {
			txtTelefone = new JFormattedTextField(new MaskFormatter("(##) ####-####"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			GerJanelasFacade.gravarLog(e.toString(), 111, this.getName());
		}
		try {
			txtCPF = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			GerJanelasFacade.gravarLog(e.toString(), 118, this.getName());
		}
		
		try {
			txtTelefone1 = new JFormattedTextField(new MaskFormatter("(##) ####-####"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			GerJanelasFacade.gravarLog(e.toString(), 125, this.getName());
		}
		
		cmbTipoSague = new JComboBox<>(listaSangue);
		cmbFatorRh = new JComboBox<>(listaTipoRh);
		cmbCurso = new JComboBox<>(listaCurso);
		txtCttEmerg = new JTextField();
		btnEditar = new JButton("EDITAR",edit);
		btnBuscar = new JButton(bsc);
		btnFechar = new JButton("VOLTAR",fechar);
		btnSave = new JButton("SALVAR",save);
		
		setSize(450,650);
		setTitle("Sistema de Cadastro");
		setLocationRelativeTo(null);
		setVisible(true);
		setLayout(null);
		container = getContentPane();
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		
		//Posicionamento dos elementos na tela.----------------------------------------------------------
		lblPesquisa.setBounds(5, 20, 100, 25);
		txtPesquisa.setBounds(80, 20, 275, 25);
		btnBuscar.setBounds(370, 20, 25, 25);
		scrollPane.setBounds(25, 60, 360, 100);
		lblNome.setBounds(70, 170, 100, 25);
		txtNome.setBounds(120, 170, 250, 25);
		lblEndereco.setBounds(70, 200, 100, 25);
		txtEndereco.setBounds(120, 200, 250, 25);
		lblTelefone.setBounds(70, 230, 100, 25);
		txtTelefone1.setBounds(120, 230, 250, 25);
		lblCPF.setBounds(70, 260, 100, 25);
		txtCPF.setBounds(120, 260, 250, 25);
		lblTipoSangue.setBounds(70, 290, 100, 25);
		cmbTipoSague.setBounds(165, 290, 50, 25);
		lblFatorRh.setBounds(270, 290, 100, 25);
		cmbFatorRh.setBounds(320, 290, 50, 25);
		lblCurso.setBounds(70, 320, 100, 25);
		cmbCurso.setBounds(120, 320, 250, 25);
		lblCttEmerg.setBounds(70, 350, 100, 25);
		lblEmergencia.setBounds(70, 360, 100, 25);
		txtCttEmerg.setBounds(140, 358, 230, 25);
		lblTelefone1.setBounds(70, 388, 100, 25);
		txtTelefone.setBounds(120, 388, 250, 25);
		btnEditar.setBounds(25, 450, 120, 50);
		btnSave.setBounds(145, 450, 120, 50);
		btnFechar.setBounds(265, 450, 120, 50);
		
		//Adicionando elementos a tela.------------------------------------------------------------------
		container.add(lblPesquisa);
		container.add(txtPesquisa);
		container.add(btnBuscar);
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
		container.add(btnEditar);
		container.add(btnFechar);
		container.add(btnSave);
		container.add(scrollPane);
		
		btnBuscar.addActionListener(busca);
		btnEditar.addActionListener(editar);
		btnFechar.addActionListener(close);
		btnSave.addActionListener(salvar);
		tblPrincipal.addMouseListener(selecionaLinha);
		btnEditar.setEnabled(false);
		btnSave.setEnabled(false);
		//btnFechar.setEnabled(false);
	}//Fim do Construtor

	 ///--------------------------ABAIXO O BLOCO DE CODIGO QUE TRATA EVENTO DO BOTAO PESQUISAR -----------------------------------------------

	// Acao do botao pesquisar---------------------------------------------------------------------------
	ActionListener busca = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			
			try {
				btnEditar.setEnabled(false);
				btnSave.setEnabled(false);
				//btnDelete.setEnabled(false);
				//Limpa os dados do JTable;------------------------------------------------------------------
				tableModel.setNumRows(0);
				//Busca todos os registros;------------------------------------------------------------------
				if(txtPesquisa.getText().length() == 0) { 
					//res = new ConexaoBD().selectFrom();
					res = GerJanelasFacade.buscarDados();
					while(res.next()){
					//Adiciona linhas a tabela --------------------------------------------------------------
						tableModel.addRow(new Object[] {"Abrir" ,res.getInt("id"),res.getString("Nome"),res.getString("Endereco"),res.getString("Telefone"),res.getString("Cpf"),res.getString("tiposanguineo"), res.getString("fatorrh"),res.getString("curso"),res.getString("cttemergencia"),res.getString("telcttemerg")});
					}
				}else {
					// Busca um registro pelo nome ----------------------------------------------------------
					//res = new ConexaoBD().selectFrom(txtPesquisa.getText());
					res = GerJanelasFacade.buscarDados(txtPesquisa.getText());
					while(res.next()){
						tableModel.addRow(new Object[] {"Abrir",res.getInt("id"),res.getString("Nome"),res.getString("Endereco"),res.getString("Telefone"),res.getString("Cpf"),res.getString("tiposanguineo"), res.getString("fatorrh"),res.getString("curso"),res.getString("cttemergencia"),res.getString("telcttemerg")});
					}// Fim do While ------------------------------------------------------------------------
				
				}//Fim do IF  --------------------------------------------------------------------------------
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				GerJanelasFacade.gravarLog(e1.toString(), 225, new TelaEditar().getName());
			}// Fim do clique na linha da JTable-------------------------------------------------------------
		}// fim do actionPerformed.
	};// fim do botao

 /// --------------------------ABAIXO O BLOCO DE CODIGO DO TRATAMENTO DO BOTAO EDITAR ---------------------------------------------
 
	ActionListener editar = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			
			txtNome.setEditable(true); 
			txtEndereco.setEditable(true);
			txtTelefone1.setEditable(true);
			txtCPF.setEditable(true);
			cmbTipoSague.setEnabled(true);
			cmbFatorRh.setEnabled(true);
			cmbCurso.setEnabled(true);
			txtCttEmerg.setEditable(true);
			txtTelefone.setEditable(true);
			btnSave.setEnabled(true);
			
		}//fim do actionPerformed

	}; //Fim do codigo do botao Editar

	/// --------------------------ABAIXO O BLOCO DE CODIGO DO TRATAMENTO DO CLIQUE NA LINHA ---------------------------------------------

	//Trata clique na linha da Jtable e carrega dos campos de texto------------------------------
	MouseListener selecionaLinha = new MouseListener() {
		@Override
		public void mouseReleased(MouseEvent e) {}
		@Override
		public void mousePressed(MouseEvent e) {}
		@Override
		public void mouseExited(MouseEvent e) {}
		@Override
		public void mouseEntered(MouseEvent e) {}
		@Override
		public void mouseClicked(MouseEvent e) {
			
		if (e.getClickCount() == 1){
						
					//recebe linha selecionada	---------------------------------------------------------
					int x	= tblPrincipal.getSelectedRow();
					Object z = tblPrincipal.getValueAt(x, 1);
					c.setId((int) z);
					c.setNome((String) tableModel.getValueAt(x, 2));
					c.setEndereco((String) tableModel.getValueAt(x, 3));
					c.setTelefone((String) tableModel.getValueAt(x, 4));
					c.setCpf((String) tableModel.getValueAt(x, 5));
					c.setTipoSangue((String) tableModel.getValueAt(x, 6));
					c.setFatorRh((String) tableModel.getValueAt(x, 7));
					c.setCurso((String) tableModel.getValueAt(x, 8));
					c.setCttEmerg((String) tableModel.getValueAt(x, 9));
					c.setTelCttEmerg((String) tableModel.getValueAt(x,10));
					
					// Nao deixa os campos editáveis-----------------------------------------------------
					txtNome.setEditable(false); 
					txtEndereco.setEditable(false);
					txtTelefone1.setEditable(false);
					txtCPF.setEditable(false);
					cmbTipoSague.setEnabled(false);
					cmbFatorRh.setEnabled(false);
					cmbCurso.setEnabled(false);
					txtCttEmerg.setEditable(false);
					txtTelefone.setEditable(false);
					
						// Carrega os dados para as caixas de texto -----------------------------------------
						txtNome.setText(c.getNome()); 
						txtEndereco.setText(c.getEndereco());
						txtTelefone1.setText(c.getTelefone());
						txtCPF.setText(c.getCpf());
						cmbTipoSague.setSelectedItem(c.getTipoSangue());
						cmbFatorRh.setSelectedItem(c.getFatorRh());
						cmbCurso.setSelectedItem(c.getCurso());
						txtCttEmerg.setText(c.getCttEmerg());
						txtTelefone.setText(c.getTelCttEmerg());
						
						btnEditar.setEnabled(true);
						btnSave.setEnabled(false);
						//btnFechar.setEnabled(true);
			         }// FIm do IF ----------------------------------------------------------------------
			
				}// Fim do Clique com mouse--------------------------------------------------------------
		
	};// FIM DO MOUSE LISTENER

	 /// --------------------------ABAIXO O BLOCO DE CODIGO DO TRATAMENTO DO BOTAO SALVAR --------------------------------------------->>>>
	 
	// Listener do botao salvar
	ActionListener salvar = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			
			if((temNumeros(txtCPF.getText()) && (txtNome.getText().length() > 0))) {
				
				//Adicionar novos dados ---------------------------------------------------------------------
				c.setNome(txtNome.getText());
				c.setEndereco(txtEndereco.getText());
				c.setTelefone(txtTelefone1.getText());
				c.setCpf(txtCPF.getText());
				c.setTipoSangue(cmbTipoSague.getSelectedItem().toString());
				c.setFatorRh(cmbFatorRh.getSelectedItem().toString());
				c.setCurso(cmbCurso.getSelectedItem().toString());
				c.setCttEmerg(txtCttEmerg.getText());
				c.setTelCttEmerg(txtTelefone.getText());
			
				txtNome.setEditable(false); 
				txtEndereco.setEditable(false);
				txtTelefone1.setEditable(false);
				txtCPF.setEditable(false);
				cmbTipoSague.setEnabled(false);
				cmbFatorRh.setEnabled(false);
				cmbCurso.setEnabled(false);
				txtCttEmerg.setEditable(false);
				txtTelefone.setEditable(false);
				
					if(0 == JOptionPane.showConfirmDialog(null, "Deseja realmente alterar?", "ATENÇÃO", JOptionPane.OK_CANCEL_OPTION)) {
						//new ConexaoBD().alterTable(c);
						GerJanelasFacade.alterarDados(c);
						JOptionPane.showMessageDialog(null, "Dados Alterados com sucesso!", "ATENÇÃO", JOptionPane.INFORMATION_MESSAGE);
						tableModel.setNumRows(0);
						tableModel.addRow(new Object [] {"",c.getId(),c.getNome(),c.getEndereco(),c.getTelefone(),c.getCpf(),c.getTipoSangue(),c.getFatorRh(),c.getCurso(),c.getCttEmerg(),c.getTelCttEmerg()});
						btnEditar.setEnabled(false);
						btnSave.setEnabled(false);
						//btnFechar.setEnabled(false);
						
					}// fim do if.
			}else { 
				JOptionPane.showMessageDialog(null, "Os campos Nome e CPF não podem ser vazios", "ATENÇÃO",JOptionPane.WARNING_MESSAGE);
				txtNome.setText("");
				txtCPF.setText("");
			}// fim do if.
	
		}// fim do actionPerformed.
	}; // Fim do BOTAO SALVAR----------------------------------------------------------------------------

	/// --------------------------ABAIXO O BLOCO DE CODIGO DO TRATAMENTO DO BOTAO APAGAR ---------------------------------------------
	 
	ActionListener close = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
				dispose();
				Mediator.inicial();
		}// fim do actionPerformed.
	};// Fim do listener do Botao APAGAR----------------------------------------------------------------------------
	/**
	 * Metodo {@code temNumeros} verifica se o cfp foi preenchido corretamente.
	 * @param texto. String a ser validada.
	 * @return false se nao estiver preenchido normamente
	 */
	boolean temNumeros(String texto) {
		
		   for (int i = 0; i < texto.length(); i++) {
		      if (Character.isDigit(texto.charAt(i))) 
		         return true;
		   }
		   return false;
		}
}//Fim da Classe ---------------------------------------------------------------------------------------------------
