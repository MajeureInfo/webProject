package fr.emse.majeureinfo.webProject.web;


import fr.emse.majeureinfo.webProject.model.Room;

public class RoomDto {

    private final Long id;
    private final NoiseDto noise;
    private final LightDto light;


    public RoomDto(Room room) {
        this.id = room.getId();
        this.noise = room.getNoise() == null ? null : new NoiseDto(room.getNoise());
        this.light = room.getLight() == null ? null : new LightDto(room.getLight());

    }

    public Long getId() {
        return id;
    }

    public NoiseDto getNoise() {
        return noise;
    }

    public LightDto getLight() {
        return light;
    }


}

