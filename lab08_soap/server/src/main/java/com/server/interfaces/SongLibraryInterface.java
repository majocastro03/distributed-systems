package com.server.interfaces;

import com.server.model.Song;
import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService
public interface SongLibraryInterface {
    @WebMethod
    List<Song> searchByTitle(String title);

    @WebMethod
    List<Song> searchByGenre(String genre);

    @WebMethod
    List<Song> searchByAuthor(String author);
}
