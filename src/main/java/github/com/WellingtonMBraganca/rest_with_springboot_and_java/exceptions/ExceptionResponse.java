package github.com.WellingtonMBraganca.rest_with_springboot_and_java.exceptions;

import java.util.Date;

//classe apenas para armazenar valores, não pode ser mudada... Record ja possui
//construtor, getters, toString, Equals e hashCode, na compiação.
public record ExceptionResponse(Date timestamp, String messege, String details) {

}
