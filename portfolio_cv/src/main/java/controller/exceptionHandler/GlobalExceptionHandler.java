package controller.exceptionHandler;

import exceptions.SkillNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(SkillNotFoundException.class)
    public ResponseEntity<String> handlerSkillNotFoundException(){
        return  new ResponseEntity<>("Skill not found", HttpStatus.NOT_FOUND);
    }
}
