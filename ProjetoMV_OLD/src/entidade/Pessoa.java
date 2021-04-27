package entidade;

public class Pessoa {

	private String cpf;
	private String nome;
	private String sexo;
	private int idade;
	
	@Override
	public boolean equals(Object obj) {
		Pessoa pessoaEntrada = (Pessoa)obj;
		if(pessoaEntrada.getCpf().equals(this.cpf)) {
			return true;
		}else {
			return false;
		}
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

}
