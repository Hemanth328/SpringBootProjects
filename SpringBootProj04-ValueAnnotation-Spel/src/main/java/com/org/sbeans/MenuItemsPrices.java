package com.org.sbeans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component("menup")
@Data
public class MenuItemsPrices {
	
	@Value("${menu.dosaPrice}")
	private int dosaPrice;
	
	@Value("${menu.idlyPrice}")
	private int idlyPrice;
	
	@Value("${menu.parathaPrice}")
	private int parathaPrice;
	
	@Value("${menu.puriPrice}")
	private int puriPrice;

}
