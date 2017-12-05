package fr.emse.majeureinfo.webProject.model;

import javax.persistence.*;

@Entity
@SuppressWarnings("serial")
public class Noise {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private Integer level;

    @Enumerated(EnumType.STRING)
    private Status status;

    @SuppressWarnings("unused")
    public Noise() {
    }

    public Noise(Integer level, Status status) {
        this.level = level;
        this.status = status;
    }

    public void switchStatus() {
        this.status = this.status == Status.ON ? Status.OFF : Status.ON;
    }

    public Long getId() {
        return id;
    }

    public Integer getLevel() {
        return level;
    }

    public Status getStatus() {
        return status;
    }

}
