package CrudBom;

public class Usuario {
	private int id ;
	private String nome ;
	private String email;
	private String municipio ;
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
	public String getMunicipio() {
		return municipio;
	}
	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}
	public Usuario(int id, String nome, String email, String municipio) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.municipio = municipio;
	}
	public Usuario() {
		super();
	}
	
	

}
