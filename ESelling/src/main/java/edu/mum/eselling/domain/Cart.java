package edu.mum.eselling.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.Map;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/*@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)*/
public class Cart implements Serializable {

	private static final long serialVersionUID = -6212595579666071819L;

	private Map<Product, Integer> cartProducts;
	private BigDecimal grandTotal;

	public Cart() {
		super();
	}

    public Map<Product, Integer> getProducts() {
        return Collections.unmodifiableMap(this.cartProducts);
    }

    public void addProduct(Product book) {
        if (this.cartProducts.containsKey(book)) {
            int quantity = this.cartProducts.get(book);
            quantity++;
            this.cartProducts.put(book, quantity);
        } else {
            this.cartProducts.put(book, 1);
        }
    }

    public void removeProduct(Product book) {
        this.cartProducts.remove(book);
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
