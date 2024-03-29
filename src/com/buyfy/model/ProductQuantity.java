// model package 
package com.buyfy.model;

//Import Files Used In this Program
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/*
 * Products Quantity Entity
 * This will use to store product quantity details.
 */
@Entity
@Table(name = "Product_Quantity")
public class ProductQuantity implements Serializable 
{
	// serial version uid
	private static final long serialVersionUID = -6010814780343668916L;

	/* **** Product Quantity Attributes ***** */
	/* Product Quantity Primary Key (ProductQuantity_ID)
	 * Product Quantity Id will be Generated by Sequence Strategy  ProductQuantity_SQE_GEN
	 * */
	@Id
	@Column(name = "ProductQuantity_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)	
	private long id;	
	
	/*
	 * Relations 
	 */
	@OneToOne(fetch=FetchType.EAGER)
	@JoinTable(name="ProductQuantity_Product")
	private Product product;
	
	// No Argument ProductQuantity Constructor
	@Column(name="quantity")
	private int quantity;

	// Parameterized ProductQuantity Constructor
	public ProductQuantity() {}
	public ProductQuantity(long id, Product product, int quantity) {
		super();
		this.id = id;
		this.product = product;
		this.quantity = quantity;
	}

	/*
	 * ProductQuantity Getters and Setters 
	 */
	// getter for id
	public long getId() {
		return id;
	}

	// setter for id
	public void setId(long id) {
		this.id = id;
	}

	// getter for product
	public Product getProduct() {
		return product;
	}

	// setter for product
	public void setProduct(Product product) {
		this.product = product;
	}

	// getter for quantity
	public int getQuantity() {
		return quantity;
	}

	// setter for quantity
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/*
	 * Overriding toString for ProductQuantity
	 */
	@Override
	public String toString() {
		return "ProductQuantity [id=" + id + ", product name=" + product.getName() + ", quantity=" + quantity + "]";
	}
	
	
}
