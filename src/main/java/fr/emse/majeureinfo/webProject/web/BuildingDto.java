package fr.emse.majeureinfo.webProject.web;

import fr.emse.majeureinfo.webProject.model.Building;
import fr.emse.majeureinfo.webProject.model.Room;

import java.util.ArrayList;
import java.util.List;

public class BuildingDto {

    private final Long id;
    private final String name;
    private final List<RoomDto> rooms;

    public BuildingDto(Building building){
        this.id = building.getId();
        this.name = building.getName();
        this.rooms = new ArrayList<RoomDto>();
        for (Room room : building.getRooms()) {
            this.rooms.add(new RoomDto(room));
        }
    }

    public Long getId() {
        return id;
    }

    public String getName() { return name; }

    public List<RoomDto> getRooms() { return rooms; }
}
