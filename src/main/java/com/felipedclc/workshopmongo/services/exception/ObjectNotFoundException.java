package com.felipedclc.workshopmongo.services.exception;

public class ObjectNotFoundException extends RuntimeException { // O COPILADOR NÃO OBRIGA A TRATAR(excessões personalizadas)
	private static final long serialVersionUID = 1L;

	public ObjectNotFoundException(String msg) {
		super(msg); //PASSA A CHAMADA PARA A CLASSE RuntimeException 
	}
}
