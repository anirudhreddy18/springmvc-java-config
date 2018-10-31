package springmvc.java.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {

	@Id
	@Column(name = "productId" , nullable = false)
	private Long productId;
	
	@Column(name = "productName", nullable = false)
	private String productName;
	
	@Column(name = "productCost", nullable = false)
	private double productCost;
	
	@Column(name = "productDescription")
	private String productDescription;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "categoryId", nullable = false)
	private Category category;

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getProductCost() {
		return productCost;
	}

	public void setProductCost(double productCost) {
		this.productCost = productCost;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	
}
