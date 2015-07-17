package edu.mum.eselling.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;

@Entity
public class ProductOrder implements Serializable {

	private static final long serialVersionUID = -3794885616176050983L;
	@Id
	@GeneratedValue
	private long orderId;
	@Temporal(TemporalType.DATE)
	private Date orderDate;
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@Valid
	private Address shippingAddress;
	private BigDecimal orderPrice;
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Customer customer;
	@JoinColumn(name = "order_id")
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private final List<OrderDetail> orderDetails = new ArrayList<OrderDetail>();
	
	private  BigDecimal tax;
	
	private BigDecimal total;


	public ProductOrder() {
		super();
	}

	public Address getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(Address shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public BigDecimal getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(BigDecimal orderPrice) {
		this.orderPrice = orderPrice;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

    public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<OrderDetail> getOrderDetails() {
        return this.orderDetails;
    }
	
	public int getTotalNumberOfProducts() {
        int total = 0;
        for (OrderDetail orderDetail : getOrderDetails()) {
            total += orderDetail.getQuantity();
        }
        return total;
    }
	
	public BigDecimal getTax(){
		return tax;
	}
	
	public void setTax(BigDecimal tax) {
		this.tax = tax;
	}
	
	public BigDecimal getTotal(){
		return total;
	}
	
	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	/**
     * Update the order details and update the total price. If the quantity is 0 or less the order detail is removed from the list.
     */
    public void updateOrderDetails() {
        BigDecimal total = BigDecimal.ZERO;
        Iterator<OrderDetail> details = this.orderDetails.iterator();
        while (details.hasNext()) {
            OrderDetail detail = details.next();
            if (detail.getQuantity() <= 0) {
                details.remove();
            } else {
                total = total.add(detail.getPrice());

            }
        }
        this.orderPrice = total;
        this.tax = this.orderPrice.multiply(new BigDecimal(0.05));
        this.total = this.orderPrice.add(this.tax);
        this.tax.setScale(2, RoundingMode.CEILING);
        this.total.setScale(2, RoundingMode.CEILING);
    }
    
    public void addOrderDetail(OrderDetail detail) {
        if (this.orderDetails.add(detail)) {
            if (this.orderPrice == null) {
                this.orderPrice = detail.getPrice();
            } else {
                this.orderPrice = this.orderPrice.add(detail.getPrice());
            }
            this.tax = this.orderPrice.multiply(new BigDecimal(0.05));
            this.total = this.orderPrice.add(this.tax);
            this.tax.setScale(2, RoundingMode.CEILING);
            this.total.setScale(2, RoundingMode.CEILING);
        }
    }
}
