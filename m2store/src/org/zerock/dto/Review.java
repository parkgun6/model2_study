package org.zerock.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Review {

	private Long sno,score;
	private String mid,text;
	private Date regdate, updateDate ;
}
