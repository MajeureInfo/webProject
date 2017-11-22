package fr.emse.majeureinfo.webProject.web;


import fr.emse.majeureinfo.webProject.dao.BuildingDao;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/buildings")
@Transactional
public class BuildingController {

    private final BuildingDao buildingDao;

    public BuildingController(BuildingDao buildingDao) { this.buildingDao = buildingDao; }

    @GetMapping
    public List<BuildingDto> list() {
        return buildingDao.findAll()
                .stream()
                .map(BuildingDto::new)
                .collect(Collectors.toList());
    }
}
