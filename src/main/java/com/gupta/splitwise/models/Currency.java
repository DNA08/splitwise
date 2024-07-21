package com.gupta.splitwise.models;

import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity @Getter @Setter @Builder
public class Currency extends BaseModel {
	private String name;
	private String symbol;
	@Override
	public String toString() {
		return "Currency [name=" + name + ", symbol=" + symbol + "]";
	}
	

}
