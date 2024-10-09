package com.neo.crud.exception;

public class DepartmentNotFoundException extends RuntimeException{
    public DepartmentNotFoundException(String msg) {
        super(msg);
    }
}
