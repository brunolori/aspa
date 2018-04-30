package com.lori.aspa.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author lorela.shehu
 */
@ResponseStatus(value=HttpStatus.UNAUTHORIZED, reason="Nuk jeni i autorizuar")
public class NoRightsException extends AppException {

    /**
	 * 
	 */
	private static final long serialVersionUID = -2124038380958593160L;

	public NoRightsException() {
    }

    public NoRightsException(String message) {
        super(message);
    }
    
}