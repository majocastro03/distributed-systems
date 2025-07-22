package service;

import models.Song;
import shared.SongServiceRMI;

import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.util.List;
import java.util.stream.Collectors;

public class SongServiceImpl extends UnicastRemoteObject implements SongServiceRMI {

    public SongServiceImpl() throws RemoteException {
        super();
    }

    @Override
    public List<Song> searchByTitle(String title) throws RemoteException {
        return SongService.getSongs().stream()
                .filter(s -> s.getTitle().equalsIgnoreCase(title))
                .collect(Collectors.toList());
    }

    @Override
    public List<Song> searchByGenre(String genre) throws RemoteException {
        return SongService.getSongs().stream()
                .filter(s -> s.getGenre().equalsIgnoreCase(genre))
                .collect(Collectors.toList());
    }

    @Override
    public List<Song> searchByAuthor(String author) throws RemoteException {
        return SongService.getSongs().stream()
                .filter(s -> s.getAuthor().equalsIgnoreCase(author))
                .collect(Collectors.toList());
    }
}
