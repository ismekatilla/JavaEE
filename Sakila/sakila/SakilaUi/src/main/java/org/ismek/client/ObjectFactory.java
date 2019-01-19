
package org.ismek.client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.ismek.client package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _FindAllFilmList_QNAME = new QName("http://web.ismek.org/", "findAllFilmList");
    private final static QName _FindAllFilmListResponse_QNAME = new QName("http://web.ismek.org/", "findAllFilmListResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.ismek.client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link FindAllFilmListResponse }
     * 
     */
    public FindAllFilmListResponse createFindAllFilmListResponse() {
        return new FindAllFilmListResponse();
    }

    /**
     * Create an instance of {@link FindAllFilmList }
     * 
     */
    public FindAllFilmList createFindAllFilmList() {
        return new FindAllFilmList();
    }

    /**
     * Create an instance of {@link SakilaFilmDto }
     * 
     */
    public SakilaFilmDto createSakilaFilmDto() {
        return new SakilaFilmDto();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAllFilmList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://web.ismek.org/", name = "findAllFilmList")
    public JAXBElement<FindAllFilmList> createFindAllFilmList(FindAllFilmList value) {
        return new JAXBElement<FindAllFilmList>(_FindAllFilmList_QNAME, FindAllFilmList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAllFilmListResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://web.ismek.org/", name = "findAllFilmListResponse")
    public JAXBElement<FindAllFilmListResponse> createFindAllFilmListResponse(FindAllFilmListResponse value) {
        return new JAXBElement<FindAllFilmListResponse>(_FindAllFilmListResponse_QNAME, FindAllFilmListResponse.class, null, value);
    }

}
