package org.iesvdm.ud4desarrollopresentacionapirestpreproyecto.exception;

public class UsuarioNotFoundException extends RuntimeException{
    public UsuarioNotFoundException(Integer id){
        super("Not found Usuario with id:" + id);
    }
}
