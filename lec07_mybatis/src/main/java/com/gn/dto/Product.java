package com.gn.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
	// DB Column
	private int productNo;
	private String productName;
	private int productPrice;
	private int productCategory;
	
	// My Custom Field
	private int sort;
}
