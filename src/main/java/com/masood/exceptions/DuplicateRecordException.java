package com.masood.exceptions;

public class DuplicateRecordException extends RuntimeException{

	public DuplicateRecordException(String msg) {super(msg);}
	
	public DuplicateRecordException() {super("This record already exists");}
	
}
