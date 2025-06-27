package com.gn.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Planet {
	private String name;
	private double distance;
	private boolean travel;
}
