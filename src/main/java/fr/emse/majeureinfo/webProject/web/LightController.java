package fr.emse.majeureinfo.webProject.web;

import fr.emse.majeureinfo.webProject.dao.LightDao;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/lights")
@Transactional
public class LightController {

    private final LightDao lightDao;


    public LightController(LightDao lightDao) {
        this.lightDao = lightDao;
    }

    @GetMapping
    public List<LightDto> list() {
        return lightDao.findAll().stream().map(LightDto::new).collect(Collectors.toList());
    }

}