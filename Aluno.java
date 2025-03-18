package dominio;

public class Aluno {
	private int matricula;
	private String nome;
	
	public Aluno(int matricula, String nome) {
		super();
		this.setMatricula(matricula);
		this.setNome(nome); 
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	public String toString() {
		return this.matricula + ": " + this.getNome();
	}
}
