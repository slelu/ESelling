package edu.mum.eselling.domain;
/**
 * Object to hold the search criteria to search products.
 * 
 * @author Filmon
 *
 */
public class ProductSearchCriteria {
	private String productName;
	private String productCategory;
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	
	
}
