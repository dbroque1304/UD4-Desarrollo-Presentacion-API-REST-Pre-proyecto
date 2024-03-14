package org.iesvdm.ud4desarrollopresentacionapirestpreproyecto.exception;

public class SesionNotFoundException extends RuntimeException{
    public SesionNotFoundException(Integer id){
        super("Not found Sesion with id:" + id);
    }
}
