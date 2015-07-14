package edu.mum.eselling.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.springframework.stereotype.Component;

@Component
public class Cart implements Serializable {

	private static final long serialVersionUID = -6212595579666071819L;

	private Map<Product, Integer> cartProducts = new HashMap<Product, Integer>();
	private BigDecimal grandTotal;

	public Cart() {
		super();
		grandTotal = new BigDecimal(0);
	}

    public Map<Product, Integer> getProducts() {
        return Collections.unmodifiableMap(this.cartProducts);
    }

    public void addProduct(Product product, Integer productQuantity) {
        if (this.cartProducts.containsKey(product)) {
        	/*System.out.println("Key contained");
            int quantity = this.cartProducts.get(product);
            quantity++;*/
            this.cartProducts.put(product, productQuantity);
            grandTotal = product.getUnitPrice().multiply(new BigDecimal(productQuantity));
        } else {
        	/*System.out.println("Key not contained");
            this.cartProducts.put(product, 1);
            grandTotal = grandTotal.add(product.getUnitPrice().multiply(new BigDecimal(1)));*/
        	this.cartProducts.put(product, productQuantity);
            grandTotal = product.getUnitPrice().multiply(new BigDecimal(productQuantity));
        }
        
        Iterator it = cartProducts.entrySet().iterator();   //line 1
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            System.out.println(((Product)pair.getKey()).getProductName() + " = " + pair.getValue());
            /*it.remove();*/
           }
    }

    public void removeProduct(Product product) {
        this.cartProducts.remove(product);
    }

    public void clear() {
        this.cartProducts.clear();
    }

    @Override
    public String toString() {
        ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE);
        builder.append("cartProducts", this.cartProducts.keySet());
        return ToStringBuilder.reflectionToString(this);
    }

	public BigDecimal getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(BigDecimal grandTotal) {
		this.grandTotal = grandTotal;
	}

}
