package br.gov.sp.fatec.springbootprodutora.entity;

import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.CascadeType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "pes_pessoa")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo", length = 1, discriminatorType = DiscriminatorType.STRING)
@AttributeOverride(name = "id", column = @Column(name = "pes_id"))
public class Pessoa extends Main{
    @Column(name = "pes_nome")
	private String nome;

	@Column(name = "pes_cpf")
    private Long cpf;
    
    @JsonIgnore
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "pessoas", cascade = CascadeType.REMOVE)
	private Set<Filmagem> filmagemParticipadas;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
    }
    
    public Set<Filmagem> getFilmagemParticipadas() {
		return filmagemParticipadas;
	}

	public void setFilmagemParticipadas(Set<Filmagem> filmagemParticipadas) {
		this.filmagemParticipadas = filmagemParticipadas;
	}
}