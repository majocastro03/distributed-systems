
package com.client.proxy;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.client.proxy package. 
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

    private final static QName _SearchByAuthor_QNAME = new QName("http://interfaces.server.com/", "searchByAuthor");
    private final static QName _SearchByAuthorResponse_QNAME = new QName("http://interfaces.server.com/", "searchByAuthorResponse");
    private final static QName _SearchByGenre_QNAME = new QName("http://interfaces.server.com/", "searchByGenre");
    private final static QName _SearchByGenreResponse_QNAME = new QName("http://interfaces.server.com/", "searchByGenreResponse");
    private final static QName _SearchByTitle_QNAME = new QName("http://interfaces.server.com/", "searchByTitle");
    private final static QName _SearchByTitleResponse_QNAME = new QName("http://interfaces.server.com/", "searchByTitleResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.client.proxy
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SearchByAuthor }
     * 
     */
    public SearchByAuthor createSearchByAuthor() {
        return new SearchByAuthor();
    }

    /**
     * Create an instance of {@link SearchByAuthorResponse }
     * 
     */
    public SearchByAuthorResponse createSearchByAuthorResponse() {
        return new SearchByAuthorResponse();
    }

    /**
     * Create an instance of {@link SearchByGenre }
     * 
     */
    public SearchByGenre createSearchByGenre() {
        return new SearchByGenre();
    }

    /**
     * Create an instance of {@link SearchByGenreResponse }
     * 
     */
    public SearchByGenreResponse createSearchByGenreResponse() {
        return new SearchByGenreResponse();
    }

    /**
     * Create an instance of {@link SearchByTitle }
     * 
     */
    public SearchByTitle createSearchByTitle() {
        return new SearchByTitle();
    }

    /**
     * Create an instance of {@link SearchByTitleResponse }
     * 
     */
    public SearchByTitleResponse createSearchByTitleResponse() {
        return new SearchByTitleResponse();
    }

    /**
     * Create an instance of {@link Song }
     * 
     */
    public Song createSong() {
        return new Song();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchByAuthor }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SearchByAuthor }{@code >}
     */
    @XmlElementDecl(namespace = "http://interfaces.server.com/", name = "searchByAuthor")
    public JAXBElement<SearchByAuthor> createSearchByAuthor(SearchByAuthor value) {
        return new JAXBElement<SearchByAuthor>(_SearchByAuthor_QNAME, SearchByAuthor.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchByAuthorResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SearchByAuthorResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://interfaces.server.com/", name = "searchByAuthorResponse")
    public JAXBElement<SearchByAuthorResponse> createSearchByAuthorResponse(SearchByAuthorResponse value) {
        return new JAXBElement<SearchByAuthorResponse>(_SearchByAuthorResponse_QNAME, SearchByAuthorResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchByGenre }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SearchByGenre }{@code >}
     */
    @XmlElementDecl(namespace = "http://interfaces.server.com/", name = "searchByGenre")
    public JAXBElement<SearchByGenre> createSearchByGenre(SearchByGenre value) {
        return new JAXBElement<SearchByGenre>(_SearchByGenre_QNAME, SearchByGenre.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchByGenreResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SearchByGenreResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://interfaces.server.com/", name = "searchByGenreResponse")
    public JAXBElement<SearchByGenreResponse> createSearchByGenreResponse(SearchByGenreResponse value) {
        return new JAXBElement<SearchByGenreResponse>(_SearchByGenreResponse_QNAME, SearchByGenreResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchByTitle }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SearchByTitle }{@code >}
     */
    @XmlElementDecl(namespace = "http://interfaces.server.com/", name = "searchByTitle")
    public JAXBElement<SearchByTitle> createSearchByTitle(SearchByTitle value) {
        return new JAXBElement<SearchByTitle>(_SearchByTitle_QNAME, SearchByTitle.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchByTitleResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SearchByTitleResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://interfaces.server.com/", name = "searchByTitleResponse")
    public JAXBElement<SearchByTitleResponse> createSearchByTitleResponse(SearchByTitleResponse value) {
        return new JAXBElement<SearchByTitleResponse>(_SearchByTitleResponse_QNAME, SearchByTitleResponse.class, null, value);
    }

}
