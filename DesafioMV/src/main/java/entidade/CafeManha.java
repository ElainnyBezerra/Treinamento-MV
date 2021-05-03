package entidade;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class CafeManha {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "s_opcao")
	@SequenceGenerator(name = "s_opcao", sequenceName = "S_COD_OPCAO", allocationSize = 1, initialValue = 3)
	private int cod_opcao;

	private String opcao;

	@JoinColumn(name = "CPF_PESSOA", referencedColumnName = "CPF")
	@ManyToOne(cascade = CascadeType.ALL)
	private Pessoa pessoa;

	public int getCod_opcao() {
		return cod_opcao;
	}

	public void setCod_opcao(int l) {
		this.cod_opcao = l;
	}

	public String getOpcao() {
		return opcao;
	}

	public void setOpcao(String opcao) {
		this.opcao = opcao;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	@Override
	public String toString() {
		return "CafeManha [cod_opcao=" + cod_opcao + ", opcao=" + opcao + ", pessoa=" + pessoa + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cod_opcao;
		result = prime * result + ((opcao == null) ? 0 : opcao.hashCode());
		result = prime * result + ((pessoa == null) ? 0 : pessoa.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CafeManha other = (CafeManha) obj;
		if (cod_opcao != other.cod_opcao)
			return false;
		if (opcao == null) {
			if (other.opcao != null)
				return false;
		} else if (!opcao.equals(other.opcao))
			return false;
		if (pessoa == null) {
			if (other.pessoa != null)
				return false;
		} else if (!pessoa.equals(other.pessoa))
			return false;
		return true;
	}

}
