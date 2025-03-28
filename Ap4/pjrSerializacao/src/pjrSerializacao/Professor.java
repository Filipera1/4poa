package pjrSerializacao;

import java.io.Serializable;
public class Professor implements Serializable {
	
	//private static final long serialVersionUID = 1L;
	private String nome;
	private int idade;
	private transient String cpf;
	private String disciplina;
	
	public Professor(String nome, int idade, String cpf, String disciplina) {
		super();
		this.nome = nome;
		this.idade = idade;
		this.cpf = cpf;
		this.disciplina = disciplina;
	}
	
	public String toString() {
		return "Professor [nome=" + nome + ", idade=" + idade + ", CPF=" + cpf + ", disciplina=" + disciplina + ",]";
	}
	
		public String getNome() {return nome;}
		public void setNome(String nome) {this.nome = nome;}
		public int getIdade() {return idade;}
		public void setIdade(int idade) {this.idade = idade;}
		public String getCPF() {return cpf;}
		public void setCPF(String cpf) {this.cpf = cpf;}	
		public String getDisciplina() {return disciplina;}
		public void setDisciplina(String disciplina) {this.disciplina = disciplina;}
}

