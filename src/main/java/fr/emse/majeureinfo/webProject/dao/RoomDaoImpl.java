package fr.emse.majeureinfo.webProject.dao;

import fr.emse.majeureinfo.webProject.model.Room;
import fr.emse.majeureinfo.webProject.model.Status;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

public class RoomDaoImpl implements RoomDaoCustom{
    @PersistenceContext
    private EntityManager em;

    /**
     * @return the list of rooms whose light is on
     */
    @Override
    public List<Room> listWithLightOn() {
        String jpql = "select r from Room r where r.light.status = :value";
        TypedQuery<Room> query = em.createQuery(jpql, Room.class);
        return query.setParameter("value", Status.ON)
                .getResultList();
    }

    /**
     * @return the list of rooms whose light is off
     */
    @Override
    public List<Room> listWithLightOff() {
        String jpql = "select r from Room r where r.light.status = :value";
        TypedQuery<Room> query = em.createQuery(jpql, Room.class);
        return query.setParameter("value", Status.OFF)
                .getResultList();
    }

    /**
     * @return the list of rooms whose ringer is on
     */
    @Override
    public List<Room> listWithRingerOn() {
        String jpql = "select r from Room r where r.noise.status = :value";
        TypedQuery<Room> query = em.createQuery(jpql, Room.class);
        return query.setParameter("value", Status.ON)
                .getResultList();
    }

    /**
     * @return the list of rooms whose ringer is off
     */
    @Override
    public List<Room> listWithRingerOff() {
        String jpql = "select r from Room r where r.noise.status = :value";
        TypedQuery<Room> query = em.createQuery(jpql, Room.class);
        return query.setParameter("value", Status.OFF)
                .getResultList();
    }
}
