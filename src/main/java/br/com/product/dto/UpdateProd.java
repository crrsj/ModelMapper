package br.com.product.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UpdateProd{	
	private	Long id;
	private	String name;
	private	String description;
	private	Integer amount;
	private	Double price;

}
