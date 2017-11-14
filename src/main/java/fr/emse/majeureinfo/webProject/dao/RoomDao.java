package fr.emse.majeureinfo.webProject.dao;

import fr.emse.majeureinfo.webProject.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomDao extends JpaRepository<Room, Long> {

}
