package br.com.product.service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import br.com.product.dto.FindProducts;
import br.com.product.dto.SaveProd;
import br.com.product.dto.UpdateProd;
import br.com.product.entity.Product;
import br.com.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {
	
	private final ModelMapper modelMapper;
	private final ProductRepository productRepository;

	public Product saveProduct(SaveProd saveProd) {	
		//var saveDto = modelMapper.map(saveProd, Product.class);
		return productRepository.save(modelMapper.map(saveProd, Product.class));
	}
	
	public List<FindProducts>findAll(){
		return productRepository.findAll().stream()
	            .map(product -> modelMapper.map(product, FindProducts.class)) 
	            .collect(Collectors.toList());	
	
	
	}
	
	public Product findById(Long id) {
		Optional<Product>find = productRepository.findById(id);
		return find.orElseThrow();
	}
	
	public Product updateProduct(UpdateProd updateProd) {	
		var update = productRepository.getReferenceById(updateProd.getId());		
		update.updating(updateProd);
		return productRepository.save(update);	
		
		
		
	}
	
	public void deleteProduct(Long id) {
		productRepository.deleteById(id);;
	}
}
