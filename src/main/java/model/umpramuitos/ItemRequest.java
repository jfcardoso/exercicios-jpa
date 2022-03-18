package model.umpramuitos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import model.basic.Product;

@Entity
@Table(name = "itens_request")
public class ItemRequest {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne
	private Request request; 	
	
	//por padrão, por ser relação "pra um(toOne)", é como se colocasse na anotação o 
	// atributo fecth=FetchType.Eager - o que carregaria automaticamente tbm o 
	// produto e o pedido ao carregar a entidade item.
	
	//por padrão, a relação "pra muitos(toMany)", é como se colocasse na anotação o 
	// atributo fecth=FetchType.Lazy
	
	@ManyToOne
	private Product product;  
	
	@Column(nullable = false)
	private int quantity;
	
	@Column(nullable = false)
	private Double price;
	
	public ItemRequest() {
		
	}	

	public ItemRequest(Request request, Product product, int quantity) {
		this.setRequest(request);
		this.setProduct(product);
		this.setQuantity(quantity);
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Request getRequest() {
		return request;
	}

	public void setRequest(Request request) {
		this.request = request;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
		if(product != null && this.price == null) {
			this.setPrice(product.getPreco());			
		}
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	
	
	

}
