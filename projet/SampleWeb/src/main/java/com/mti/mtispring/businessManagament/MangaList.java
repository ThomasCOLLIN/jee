package com.mti.mtispring.businessManagament;

import com.mti.mtispring.entities.Manga;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MangaList {
    public MangaList() {
        
    }
    /**
     * a list of mangas used to convert the result of a research to XML
     */
    public MangaList(List<Manga> mangas) {
        this.mangas = mangas;
    }
    
    List<Manga> mangas;

    /**
     * get the list of mangas
     */
    @XmlElement(name = "manga")
    public List<Manga> getMangas() {
        return this.mangas;
    }

    /**
     * set the list of mangas
     */
    public void setMangas(List<Manga> mangas) {
        this.mangas = mangas;
    }

    /**
     * add a manga to the list
     */
    public void addManga(Manga manga) {
        this.mangas.add(manga);
    }
}
