package org.iesvdm.ud4desarrollopresentacionapirestpreproyecto.exception;

public class MaestroNotFoundException extends RuntimeException{
    public MaestroNotFoundException(Integer id){
        super("Not found Maestro with id:" + id);
    }
}
