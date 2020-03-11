package com.stefanini.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tb_pessoa_perfil")
public class PessoaPerfil implements Serializable {

	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "co_seq_pessoal_perfil")
    private long id;

    @ManyToOne
    @JoinColumn(name = "co_seq_perfil", referencedColumnName = "co_seq_perfil", nullable = false)
    private Perfil perfil;
    @ManyToOne
    @JoinColumn(name = "co_seq_pessoa", referencedColumnName = "co_seq_pessoa", nullable = false)
    private Pessoa pessoa;

    public PessoaPerfil() {
	}

    public PessoaPerfil(Perfil perfil, Pessoa pessoa) {
        this.perfil = perfil;
        this.pessoa = pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((perfil == null) ? 0 : perfil.hashCode());
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
		PessoaPerfil other = (PessoaPerfil) obj;
		if (id != other.id)
			return false;
		if (perfil == null) {
			if (other.perfil != null)
				return false;
		} else if (!perfil.equals(other.perfil))
			return false;
		if (pessoa == null) {
			if (other.pessoa != null)
				return false;
		} else if (!pessoa.equals(other.pessoa))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PessoaPerfil [id=" + id + ", perfil=" + perfil + ", pessoa=" + pessoa + "]";
	}
    
    
}
