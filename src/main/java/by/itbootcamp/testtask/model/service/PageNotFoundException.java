package by.itbootcamp.testtask.model.service;

public class PageNotFoundException extends RuntimeException {

    private static final long serialVersionUID = -6875038727088216298L;

    public PageNotFoundException() {
    }

    public PageNotFoundException(String message) {
        super(message);
    }

    public PageNotFoundException(String message, Exception exception) {
        super(message, exception);
    }

    public PageNotFoundException(Exception exception) {
        super(exception);
    }
}
