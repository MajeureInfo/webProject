package fr.emse.majeureinfo.webProject.dao;

import fr.emse.majeureinfo.webProject.model.Noise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoiseDao extends JpaRepository<Noise, Long> {

}
