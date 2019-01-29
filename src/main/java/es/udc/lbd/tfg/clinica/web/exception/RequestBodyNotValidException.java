package es.udc.lbd.tfg.clinica.web.exception;

public class RequestBodyNotValidException extends ResourceException {
    public RequestBodyNotValidException(String errorMsg) {
        super(errorMsg);
    }
}
