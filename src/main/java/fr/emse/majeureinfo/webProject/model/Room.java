package fr.emse.majeureinfo.webProject.model;

import javax.persistence.*;

@Entity
@SuppressWarnings("serial")
public class Room {

    @Id
    @GeneratedValue
    private Long id;

    /**
     * The Building where a room is located
     */
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "building_id")
    private Building building;

    /**
     * The Light of a room
     */
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Light light;

    /**
     * The ringer of a room
     */
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Noise noise;

    @SuppressWarnings("unused")
    public Room() {
    }

    public Room(Building building, Light light, Noise noise) {
        this.building = building;
        this.light = light;
        this.noise = noise;
    }

    public Building getBuilding() {
        return building;
    }

    public Long getId() {
        return id;
    }

    public Light getLight() {
        return light;
    }

    public Noise getNoise() {
        return noise;
    }

    public void switchLight() { light.switchStatus();}

    public void switchNoise(){
        noise.switchStatus();
    }
}
