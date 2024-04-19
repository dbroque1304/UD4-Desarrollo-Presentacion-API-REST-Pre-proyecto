package org.iesvdm.ud4desarrollopresentacionapirestpreproyecto.exception;

public class HorarioNotFoundException extends RuntimeException{
    public HorarioNotFoundException(Integer id){
        super("Not found Horario with id:" + id);
    }
}
