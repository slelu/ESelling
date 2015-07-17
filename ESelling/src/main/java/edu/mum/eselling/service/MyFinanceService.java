package edu.mum.eselling.service;

import java.util.List;

import edu.mum.eselling.domain.MyFinance;
import edu.mum.eselling.domain.Transaction;

public interface MyFinanceService {
	
	public List<MyFinance> getAll(); 
	public MyFinance findMyFinanceByCreditCardNo(String myFinanceId);
	public MyFinance store(MyFinance myFinance);
	public Transaction store(Transaction mytransaction);
}
