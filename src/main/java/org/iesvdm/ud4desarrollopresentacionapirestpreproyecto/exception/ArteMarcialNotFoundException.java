package org.iesvdm.ud4desarrollopresentacionapirestpreproyecto.exception;

public class ArteMarcialNotFoundException extends RuntimeException{
    public ArteMarcialNotFoundException(Integer id){
        super("Not found ArteMarcial with id:" + id);
    }
}
