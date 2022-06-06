package MoedaCRUD;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cotacao {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private int idMoeda;
	private String data;
	private float valor;
	
	public Cotacao() {
		super();
	}
	
	public Cotacao(int idMoeda, String data, float valor) {
		this.idMoeda = idMoeda;
		this.data = data;
		this.valor = valor;
	}
	
	public int getId() {
		return id;
	}

	public int getId_moeda() {
		return idMoeda;
	}

	public void setId_moeda(int idMoeda) {
		this.idMoeda = idMoeda;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}
	
}
