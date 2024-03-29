package com.example.emp.exception;

import com.example.emp.dto.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class EmployeeExceptionHandler
{
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseDto> handleMethodArgumentNotvalidException(MethodArgumentNotValidException e)
    {
        List<ObjectError> errors = e.getBindingResult().getAllErrors();
        List<String> errMsg = errors
                .stream()
                .map(ObjectError-> ObjectError.getDefaultMessage())
                .collect(Collectors.toList());
        ResponseDto responseDto = new ResponseDto("Occurence of Exception in Usage of REST",errMsg.toString());
        return new ResponseEntity<>(responseDto, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(EmployeeException.class)
    public ResponseEntity<ResponseDto> handleEmployeeException(EmployeeException e)
    {
        ResponseDto responseDto = new ResponseDto("Occurence of Exception in Usage of REST",e.getMessage());
        return new ResponseEntity<>(responseDto,HttpStatus.BAD_GATEWAY);
    }

}