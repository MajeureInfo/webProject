package fr.emse.majeureinfo.webProject.dao;

import fr.emse.majeureinfo.webProject.model.Room;

import java.util.List;

/**
 * A custom DAO for the Room with additional functions
 */
public interface RoomDaoCustom {

    /**
     * @return the list of rooms whose light is on
     */
    List<Room> listWithLightOn();

    /**
     * @return the list of rooms whose light is off
     */
    List<Room> listWithLightOff();

    /**
     * @return the list of rooms whose ringer is on
     */
    List<Room> listWithRingerOn();

    /**
     * @return the list of rooms whose ringer is off
     */
    List<Room> listWithRingerOff();
}
