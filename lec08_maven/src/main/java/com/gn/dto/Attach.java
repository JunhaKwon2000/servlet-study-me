package com.gn.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Attach {

	  private int attachNo;
	  private int boardNo;
	  private String oriName;
	  private String reName;
	  private String regDate;
	
}
