package com.mti.mtispring.businessManagament;

import com.mti.mtispring.entities.Manga;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MangaList {
    public MangaList() {
        
    }
    
    public MangaList(List<Manga> mangas) {
        this.mangas = mangas;
    }
    
    List<Manga> mangas;

    @XmlElement(name = "manga")
    public List<Manga> getMangas() {
        return this.mangas;
    }

    public void setMangas(List<Manga> mangas) {
        this.mangas = mangas;
    }

    public void addManga(Manga manga) {
        this.mangas.add(manga);
    }
}
