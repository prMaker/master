package com.kaishengit.exception;


/*
 * �Զ����쳣������������ݿ���ʳ��ֵ��쳣
 */
public class DataAccessException extends RuntimeException{

	
	private static final long serialVersionUID = 1L;

	public DataAccessException(){}
	
	public DataAccessException(Throwable th){
		super(th);
		
	}
	
	public DataAccessException(Throwable th,String message){
		
		super(message,th);
	}
}
