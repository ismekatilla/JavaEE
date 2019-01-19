package org.ismek.web;

import org.ismek.dto.SakilaFilmDto;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.List;

@WebService
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT,use= SOAPBinding.Use.LITERAL) //optional
public interface SakilaWebService {

    @WebMethod(operationName = "findAllFilmList")
    public List<SakilaFilmDto> findAllFilmList();
}