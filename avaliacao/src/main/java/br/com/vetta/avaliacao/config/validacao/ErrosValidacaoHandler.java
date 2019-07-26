package br.com.vetta.avaliacao.config.validacao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.vetta.avaliacao.dto.ErroValidationDto;

@RestControllerAdvice
public class ErrosValidacaoHandler {
	
	@Autowired
	MessageSource message;
	
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public List<ErroValidationDto> handle(MethodArgumentNotValidException exception) {
		List<ErroValidationDto> listErros = new ArrayList<ErroValidationDto>();
		List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
		
		for(FieldError erro : fieldErrors){
			
			String mensagem = message.getMessage(erro, LocaleContextHolder.getLocale());
			ErroValidationDto erroDto = new ErroValidationDto(erro.getField(), mensagem);
			listErros.add(erroDto);
		}
		
		return listErros;
	}

}
