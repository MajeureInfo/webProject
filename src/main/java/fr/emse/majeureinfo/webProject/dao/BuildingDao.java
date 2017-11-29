package fr.emse.majeureinfo.webProject.dao;

import fr.emse.majeureinfo.webProject.model.Building;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuildingDao extends JpaRepository<Building, Long> {

}