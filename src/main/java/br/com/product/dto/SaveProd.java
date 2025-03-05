package br.com.product.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SaveProd{
	private	String name;
	private	String description;
	private	int amount;
	private double price;
	
	
}

