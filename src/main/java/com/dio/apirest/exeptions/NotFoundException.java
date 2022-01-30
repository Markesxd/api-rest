package com.dio.apirest.exeptions;

public class NotFoundException extends Exception {
    
    public NotFoundException(long id){
        super("Pessoa " + id + "não encontrada");
    }
}
