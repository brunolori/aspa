package com.lori.aspa.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author bruno2
 */
@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="Nuk u gjend asnje rezultat")
public class NoResultFoundException extends AppException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 780166032683959435L;

	public NoResultFoundException() {
    }

    public NoResultFoundException(String message) {
        super(message);
    }
}
