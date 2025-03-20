package com.train8.train8mvp.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {

	private String detailedAddress;
	private String city;
	private String state;
	private String pinCode;
}
