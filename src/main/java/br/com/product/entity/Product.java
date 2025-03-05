package br.com.product.entity;

import br.com.product.dto.UpdateProd;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_produtos")
@Data
@NoArgsConstructor
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String description;
	private Integer amount;
	private Double price;
	
	public void updating(UpdateProd updateProd) {
	if(updateProd.getName() != null) {
		this.name = updateProd.getName();
	}
	if(updateProd.getDescription() != null) {
		this.description = updateProd.getDescription();
	}
	if(updateProd.getAmount() != null)	{
	   this.amount = updateProd.getAmount();
	}
	
	if(updateProd.getPrice() != null) {
	   this.price = updateProd.getPrice();
	
	}
	
	}


	
}
