package fr.emse.majeureinfo.webProject.model;

import javax.persistence.*;

@Entity
@SuppressWarnings("serial")
public class Light {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private Integer level;

    @Enumerated(EnumType.STRING)
    private Status status;

    @SuppressWarnings("unused")
    public Light() {
    }

    public Light(Integer level, Status status) {
        this.level = level;
        this.status = status;
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
