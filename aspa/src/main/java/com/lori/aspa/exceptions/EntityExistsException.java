/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lori.aspa.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author bruno2
 */
@ResponseStatus(value=HttpStatus.CONFLICT, reason="Entiteti ekziston")
public class EntityExistsException extends AppException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 7268310653039569420L;

	public EntityExistsException() {
    }

    public EntityExistsException(String message) {
        super(message);
    }
    
}