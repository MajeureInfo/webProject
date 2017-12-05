package fr.emse.majeureinfo.webProject.web;

import fr.emse.majeureinfo.webProject.dao.RoomDao;
import fr.emse.majeureinfo.webProject.model.Room;
import fr.emse.majeureinfo.webProject.model.Status;
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

    @GetMapping("/list-with-light-on")
    public List<RoomDto> listWithLightOn() {
        return roomDao.listWithLightOn()
                .stream()
                .map(RoomDto::new)
                .collect(Collectors.toList());
    }

    @GetMapping("/list-with-light-off")
    public List<RoomDto> listWithLightOff() {
        return roomDao.listWithLightOff()
                .stream()
                .map(RoomDto::new)
                .collect(Collectors.toList());
    }

    @GetMapping("/list-with-ringer-on")
    public List<RoomDto> listWithRingerOn() {
        return roomDao.listWithRingerOn()
                .stream()
                .map(RoomDto::new)
                .collect(Collectors.toList());
    }

    @GetMapping("/list-with-ringer-off")
    public List<RoomDto> listWithRingerOff() {
        return roomDao.listWithRingerOff()
                .stream()
                .map(RoomDto::new)
                .collect(Collectors.toList());
    }

    @PostMapping("/switch-all-lights-on")
    public List<RoomDto> switchAllLightsOn() {
        List<Room> rooms = roomDao.findAll();
        for (Room room : rooms){
            if (room.getLight().getStatus() == Status.OFF){
                room.switchLight();
            }
        }
        return roomDao.findAll()
                .stream()
                .map(RoomDto::new)
                .collect(Collectors.toList());
    }

    @PostMapping("/switch-all-lights-off")
    public List<RoomDto> switchAllLightsOff() {
        List<Room> rooms = roomDao.findAll();
        for (Room room : rooms){
            if (room.getLight().getStatus() == Status.ON){
                room.switchLight();
            }
        }
        return roomDao.findAll()
                .stream()
                .map(RoomDto::new)
                .collect(Collectors.toList());
    }

    @PostMapping("/switch-all-ringers-on")
    public List<RoomDto> switchAllRingersOn() {
        List<Room> rooms = roomDao.findAll();
        for (Room room : rooms){
            if (room.getNoise().getStatus() == Status.OFF){
                room.switchNoise();
            }
        }
        return roomDao.findAll()
                .stream()
                .map(RoomDto::new)
                .collect(Collectors.toList());
    }

    @PostMapping("/switch-all-ringers-off")
    public List<RoomDto> switchAllRingersOff() {
        List<Room> rooms = roomDao.findAll();
        for (Room room : rooms){
            if (room.getNoise().getStatus() == Status.ON){
                room.switchNoise();
            }
        }
        return roomDao.findAll()
                .stream()
                .map(RoomDto::new)
                .collect(Collectors.toList());
    }

}