package interfacesgui;
/**
 * A classe Cadastro e uma classe de apoio para persistencia de dados, facilitando
 * as operaçoes entre Queries Sql.
 * 
 */
public class Cadastro {
	
	private int id;
	private String nome;
	private String endereco;
	private String telefone;
	private String cpf;
	private String tipoSangue;
	private String fatorRh;
	private String curso;
	private String cttEmerg;
	private String telCttEmerg;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getTipoSangue() {
		return tipoSangue;
	}
	public void setTipoSangue(String tipoSangue) {
		this.tipoSangue = tipoSangue;
	}
	public String getFatorRh() {
		return fatorRh;
	}
	public void setFatorRh(String fatorRh) {
		this.fatorRh = fatorRh;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public String getCttEmerg() {
		return cttEmerg;
	}
	public void setCttEmerg(String cttEmerg) {
		this.cttEmerg = cttEmerg;
	}
	public String getTelCttEmerg() {
		return telCttEmerg;
	}
	public void setTelCttEmerg(String telCttEmerg) {
		this.telCttEmerg = telCttEmerg;
	}
}
