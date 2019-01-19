package org.ismek.web;

import org.ismek.domain.Film;
import org.ismek.dto.SakilaFilmDto;
import org.ismek.service.FilmService;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.List;

@WebService(endpointInterface = "org.ismek.web.SakilaWebService")
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT,use= SOAPBinding.Use.LITERAL) //optional
public class SakilaWebServiceImpl implements SakilaWebService {

    @WebMethod(operationName = "findAllFilmList")
    public List<SakilaFilmDto> findAllFilmList() {
        FilmService filmService = new FilmService();
        List<Film> filmList = filmService.findAll();
        List<SakilaFilmDto> sakilaFilmDtoList = new ArrayList<SakilaFilmDto>();
        for (Film film : filmList) {
            SakilaFilmDto sakilaFilmDto = new SakilaFilmDto();
            sakilaFilmDto.setFilmId(film.getFilmId());
            sakilaFilmDto.setTitle(film.getTitle());
            sakilaFilmDto.setDescription(film.getDescription());
            sakilaFilmDtoList.add(sakilaFilmDto);
        }

        return sakilaFilmDtoList;
    }
}