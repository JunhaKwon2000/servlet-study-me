package com.gn.dto;

import com.gn.common.vo.Paging;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Board extends Paging {
	
	private int boardNo;
	private String boardTitle;
	private String boardContent;
	private int boardWriter;
	
	private String regDate;
	private String modDate;
	
	
	// 여기는 커스텀의 영역
	private String memberTrueId;
	
	private String keyword;

}
