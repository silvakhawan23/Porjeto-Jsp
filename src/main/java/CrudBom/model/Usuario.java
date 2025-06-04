package CrudBom.model;

public class Usuario {
	private int id ;
	private String nome ;
	private String email;
	private String cpf ;
	private Municipio municipio ;
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Municipio getMunicipio() {
		return municipio;
	}
	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}
	public Usuario(int id, String nome, String email,String cpf, Municipio municipio) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cpf =cpf ;
		this.municipio = municipio;
	}
	public Usuario() {
		super();
	}
	
	

}
