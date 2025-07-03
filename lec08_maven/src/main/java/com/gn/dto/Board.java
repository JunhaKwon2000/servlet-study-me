package com.gn.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Board {
	
	private int boardNo;
	private String boardTitle;
	private String boardContent;
	private int boardWriter;
	
	private String regDate;
	private String modDate;
	
	private String memberTrueId;

}
