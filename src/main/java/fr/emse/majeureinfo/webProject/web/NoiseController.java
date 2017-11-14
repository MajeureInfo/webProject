package fr.emse.majeureinfo.webProject.web;

import fr.emse.majeureinfo.webProject.dao.NoiseDao;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/noises")
@Transactional
public class NoiseController {

    private final NoiseDao noiseDao;


    public NoiseController(NoiseDao noiseDao) {
        this.noiseDao = noiseDao;
    }

    @GetMapping
    public List<NoiseDto> list() {
        return noiseDao.findAll().stream().map(NoiseDto::new).collect(Collectors.toList());
    }

}