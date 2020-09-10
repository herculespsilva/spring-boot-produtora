package br.gov.sp.fatec.springbootprodutora.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@DiscriminatorValue(value = "A")
public class Ator extends Pessoa{
	
	@Column(name = "atr_fama")
	private String fama;

	public String getFama() {
		return fama;
	}

	public void setFama(String fama) {
		this.fama = fama;
	}
}