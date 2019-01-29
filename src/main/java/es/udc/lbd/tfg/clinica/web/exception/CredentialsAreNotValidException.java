package es.udc.lbd.tfg.clinica.web.exception;

public class CredentialsAreNotValidException extends ResourceException {

    public CredentialsAreNotValidException(String errorMsg) {
        super(errorMsg);
    }
}
