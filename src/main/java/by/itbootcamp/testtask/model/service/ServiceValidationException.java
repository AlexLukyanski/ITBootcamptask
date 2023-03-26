package by.itbootcamp.testtask.model.service;

public class ServiceValidationException extends RuntimeException {

    private static final long serialVersionUID = 8208891671400253045L;

    public ServiceValidationException() {
    }

    public ServiceValidationException(String message) {
        super(message);
    }

    public ServiceValidationException(String message, Exception exception) {
        super(message, exception);
    }

    public ServiceValidationException(Exception exception) {
        super(exception);
    }
}
