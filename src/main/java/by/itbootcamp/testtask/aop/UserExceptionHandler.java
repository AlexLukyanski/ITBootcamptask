package by.itbootcamp.testtask.aop;

import by.itbootcamp.testtask.model.service.PageNotFoundException;
import by.itbootcamp.testtask.model.service.ServiceValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class UserExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public Map<String, String> handleNorBlankFieldsValidationExceptions(MethodArgumentNotValidException e) {

        Map<String, String> exceptions = new HashMap<>();
        List<ObjectError> errors = e.getBindingResult().getAllErrors();

        for (ObjectError error : errors) {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            exceptions.put(fieldName, errorMessage);
        }
        return exceptions;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ServiceValidationException.class)
    @ResponseBody
    public String handleServiceValidationExceptions(ServiceValidationException e) {

        return e.getMessage();
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(PageNotFoundException.class)
    @ResponseBody
    public String handlePageNotFoundException(PageNotFoundException e) {

        return e.getMessage();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public String handleUnexpectedException(Exception e) {

        return e.getMessage();
    }
}
