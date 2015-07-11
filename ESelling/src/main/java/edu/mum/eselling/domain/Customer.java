package edu.mum.eselling.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
	public class Customer extends User implements Serializable{


		private static final long serialVersionUID = -3794885616176050983L;
		
			
		@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
		private CreditCard creditCard;

		@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
		private List<ProductOrder> orders;
		
		public Customer(){
			super();
		}

		public CreditCard getCreditCard() {
			return creditCard;
		}

		public void setCreditCard(CreditCard creditCard) {
			this.creditCard = creditCard;
		}
		
		public List<ProductOrder> getOrders() {
			return orders;
		}

		public void addOrders(ProductOrder order) {
			orders.add(order);
		}

		
		
}
