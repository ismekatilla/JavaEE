package org.ismek.web;

import org.ismek.client.SakilaFilmDto;
import org.ismek.client.SakilaWebService;
import org.ismek.client.SakilaWebServiceImplService;
import org.junit.Test;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class SakilaServiceTest {

    @Test
    public void findAllFilmTest() throws MalformedURLException {

        URL url = new URL("http://localhost:8080/SakilaUi/SakilaService?wsdl");
        //1st argument service URI, refer to wsdl document above
        //2nd argument is service name, refer to wsdl document above
        QName qname = new QName("http://web.ismek.org/", "SakilaWebService");
        Service service = Service.create(url, qname);
        SakilaWebService sakilaWebService = service.getPort(SakilaWebService.class);

        List<SakilaFilmDto> filmList = sakilaWebService.findAllFilmList();
        for (SakilaFilmDto sakilaFilmDto : filmList) {
            System.out.println(sakilaFilmDto.getTitle());
        }


//        URL url = new URL("http://localhost:8080/SakilaUi/SakilaService?wsdl");
//        SakilaWebServiceImplService sakilaWebServiceImplService = new SakilaWebServiceImplService(url);
//        SakilaWebService sakilaWebServiceImplPort = sakilaWebServiceImplService.getSakilaWebServiceImplPort();
//        List<SakilaFilmDto> filmList = sakilaWebServiceImplPort.findAllFilmList();
//        for (SakilaFilmDto sakilaFilmDto : filmList) {
//            System.out.println(sakilaFilmDto.getTitle());
//        }
    }
}