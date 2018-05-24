/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lori.aspa.exceptions;


/**
 *
 * @author bruno2
 */
public class EmptyFieldsException extends AppException {


	private static final long serialVersionUID = 2728568815005332483L;
	
	

	public EmptyFieldsException() {
    }

    public EmptyFieldsException(String message) {
        super(message);
    }
    
}
