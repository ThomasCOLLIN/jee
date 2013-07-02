package com.mti.mtispring.businessManagament;

import com.mti.mtispring.db.entities.Manga;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "mangas")
public class MangaList {

    List<Manga> mangas;

    @XmlElement
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
