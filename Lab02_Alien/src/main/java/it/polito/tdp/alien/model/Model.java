package it.polito.tdp.alien.model;

import java.util.*;

public class Model {

	private String pInserita;
	private String pTradotta;
	private Map<String,Collection> traduzioni;
	private List<String> trad=new LinkedList<String>();
	
	public Model() {
		traduzioni=new TreeMap<String,Collection>();
	}
	
	public void addTrduzione(String pInserita,String pTradotta) {
		String pInserita1=pInserita.toLowerCase();
		String pTradotta1=pTradotta.toLowerCase();
		if(isDigital(pInserita)) {
			throw new IllegalStateException("Senza numeri\n");
		}
		if(isDigital(pTradotta)) {
			throw new IllegalStateException("Senza numeri\n");
		}
		
		trad.add(pTradotta1);
		traduzioni.put(pInserita1,trad);
	}
	
	
	
	public Collection traduci(String s) {
		String s1=s.toLowerCase();
		
		if(isDigital(s1)) {
			throw new IllegalStateException("Senza numeri\n");
		}
		
		if(traduzioni.containsKey(s1)) {
			return traduzioni.get(s1);
		}
		else
			return null;
	}
	
	public void clearMap() {
		traduzioni.clear();
	}

	public boolean isDigital(String s) {
		for(int i=0;i<s.length();i++) {
			if(Character.isDigit(s.charAt(i))){
				return true;
			}
		}
			return false;
	}
	
	
	
	
	
	
	
	
}
