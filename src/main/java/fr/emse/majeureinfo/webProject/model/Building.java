package fr.emse.majeureinfo.webProject.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Building {

    @Id
    @GeneratedValue
    private Long id;

    @Column (nullable = false)
    private String name;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Room> rooms;

    public Building() {
    }

    public Building(String name, List<Room> rooms){
        this.name = name;
        this.rooms = rooms;
    }

    public Long getId() {
        return id;
    }

    public String getName() { return name; }

    public List<Room> getRooms() { return rooms; }
}
