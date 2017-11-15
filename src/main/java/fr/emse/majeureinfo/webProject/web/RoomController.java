package fr.emse.majeureinfo.webProject.web;

import fr.emse.majeureinfo.webProject.dao.RoomDao;
import fr.emse.majeureinfo.webProject.model.Room;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/rooms")
@Transactional
public class RoomController {

    private final RoomDao roomDao;


    public RoomController(RoomDao roomDao) {
        this.roomDao = roomDao;
    }

    @GetMapping
    public List<RoomDto> list() {
        return roomDao.findAll()
                .stream()
                .map(RoomDto::new)
                .collect(Collectors.toList());
    }

    @GetMapping("/{roomId}")
    public RoomDto get(@PathVariable Long roomId) {
        return new RoomDto(roomDao.findOne(roomId));
    }

    @PostMapping("/{roomId}/switch-light")
    public List<RoomDto> switchLight(@PathVariable Long roomId) {
        Room room = roomDao.findOne(roomId);
        room.switchLight();
        return roomDao.findAll()
                .stream()
                .map(RoomDto::new)
                .collect(Collectors.toList());
    }

    @PostMapping("/{roomId}/switch-ringer")
    public List<RoomDto> switchRinger(@PathVariable Long roomId) {
        Room room = roomDao.findOne(roomId);
        room.switchNoise();
        return roomDao.findAll()
                .stream()
                .map(RoomDto::new)
                .collect(Collectors.toList());
    }

    @GetMapping("/list-with-on-lights")
    public List<RoomDto> listWithOnLight() {
        return roomDao.listWithOnLight()
                .stream()
                .map(RoomDto::new)
                .collect(Collectors.toList());
    }
}