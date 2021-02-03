package org.zerock.domain;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Store {

	private Long sno;
	private String name,menu;
	private double lat,lng;
	private Date regdate, updateDate ;
	
}
