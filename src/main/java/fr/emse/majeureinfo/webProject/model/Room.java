package fr.emse.majeureinfo.webProject.model;

import javax.persistence.*;

@Entity
@SuppressWarnings("serial")
public class Room {

    @Id
    @GeneratedValue
    private Long id;

    /**
     * The Light of a room
     */
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Light light;

    /**
     * The Noise of a room
     */
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Noise noise;

    @SuppressWarnings("unused")
    public Room() {
    }

    public Room(Light light, Noise noise) {
        this.light = light;
        this.noise = noise;
    }

    public Long getId() {
        return id;
    }

    public Light getLight() {
        return light;
    }

    public Noise getNoise() {
        return noise; }

    public void switchLight() {
        this.light.switchStatus();
    }

    public void switchNoise(){
        this.noise.switchStatus();
    }
}
