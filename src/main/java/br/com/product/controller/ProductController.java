package br.com.product.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.product.dto.FindProducts;
import br.com.product.dto.SaveProd;
import br.com.product.dto.UpdateProd;
import br.com.product.service.ProductService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
	private final ModelMapper modelMapper;

	private final ProductService productService;
	
	@PostMapping
	public ResponseEntity<SaveProd>saveProducts(@RequestBody SaveProd saveProd){
		var save = productService.saveProduct(saveProd);
		var uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
				buildAndExpand(save.getId()).toUri();		
		return ResponseEntity.created(uri).body(modelMapper.map(save, SaveProd.class));
	}
	
	@PutMapping
	public ResponseEntity<UpdateProd>updateProducts(@RequestBody UpdateProd updateProd){
		var update = productService.updateProduct(updateProd);
	
		return ResponseEntity.ok().body(modelMapper.map(update, UpdateProd.class));
	}
	
	@GetMapping
	public ResponseEntity<List<FindProducts>>fundAll(){
		var findAll = productService.findAll();
		return ResponseEntity.ok().body(findAll);	
		
		
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<FindProducts>findById(@PathVariable Long id){
		var find = productService.findById(id);		
		return ResponseEntity.ok(modelMapper.map(find, FindProducts.class));
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void>deleteProduct(@PathVariable Long id){
		productService.findById(id);
		return ResponseEntity.noContent().build();
	}
}
