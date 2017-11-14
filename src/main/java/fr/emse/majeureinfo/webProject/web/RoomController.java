package fr.emse.majeureinfo.webProject.web;

import fr.emse.majeureinfo.webProject.dao.RoomDao;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public RoomDto single(@PathVariable Long roomId) {
        return new RoomDto(roomDao.findOne(roomId));
    }
}