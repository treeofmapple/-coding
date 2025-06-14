package Abstract;

import java.util.Random;

public class Aluno {
	private String nome;
	private String matricula;
	private String[] randomed = {"John","Marlon","Michael","Dovan","Eldri"};
	
	
	public Aluno() {
		Random random = new Random();
		String randomized = randomed[random.nextInt(randomed.length)];
		
		this.nome = randomized;
		this.matricula = ""; 
	}
	
	public Aluno(String nome) {
		this.nome = nome;
		this.matricula = "000000";
	}

	public Aluno(String nome, String matricula) {
		this.nome = nome;
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	@Override
	public String toString() {
		return nome + (matricula.isEmpty() ? "" : "-" + matricula);
	}
}
