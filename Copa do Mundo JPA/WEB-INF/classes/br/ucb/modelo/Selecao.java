package br.ucb.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Selecao implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String nome;
	private int qtdTitulos;
	
	@OneToMany(mappedBy="selecao", fetch=FetchType.EAGER)
	private List<Jogador> jogadores;
	
	@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(name="selecaoHotel",
		joinColumns=@JoinColumn(name="idSelecao"),
		inverseJoinColumns=@JoinColumn(name="idHotel"))
	private List<Hotel> hoteis;
	
	public Selecao() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getQtdTitulos() {
		return qtdTitulos;
	}

	public void setQtdTitulos(int qtdTitulos) {
		this.qtdTitulos = qtdTitulos;
	}

	public List<Hotel> getHoteis() {
		return hoteis;
	}

	public void setHoteis(List<Hotel> hoteis) {
		this.hoteis = hoteis;
	}

	public List<Jogador> getJogadores() {
		return jogadores;
	}

	public void setJogadores(List<Jogador> jogadores) {
		this.jogadores = jogadores;
	}

}
