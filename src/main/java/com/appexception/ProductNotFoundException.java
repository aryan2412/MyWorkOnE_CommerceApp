package com.appexception;

import com.annotations.Generated;

@Generated
public class ProductNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ProductNotFoundException()
	{
		
	}
	public String toString()
	{
		return "Product Not Found.";
	}
}
