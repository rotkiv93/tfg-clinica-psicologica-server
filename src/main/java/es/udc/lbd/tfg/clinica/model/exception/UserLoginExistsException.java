package es.udc.lbd.tfg.clinica.model.exception;

public class UserLoginExistsException extends ModelException {
    public UserLoginExistsException(String msg) {
        super(msg);
    }
}
