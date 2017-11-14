package fr.emse.majeureinfo.webProject.dao;

import fr.emse.majeureinfo.webProject.model.Light;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LightDao extends JpaRepository<Light, Long>, LightDaoCustom {
}