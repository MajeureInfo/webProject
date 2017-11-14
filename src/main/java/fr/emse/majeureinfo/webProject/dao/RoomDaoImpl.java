package fr.emse.majeureinfo.webProject.dao;

        import fr.emse.majeureinfo.webProject.model.Light;
        import fr.emse.majeureinfo.webProject.model.Room;
        import fr.emse.majeureinfo.webProject.model.Status;

        import javax.persistence.EntityManager;
        import javax.persistence.PersistenceContext;
        import javax.persistence.TypedQuery;
        import java.util.List;

public class RoomDaoImpl implements RoomDaoCustom{
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Room> listWithOnLight() {
        String jpql = "select r from Room r where r.light.status = :value";
        TypedQuery<Room> query = em.createQuery(jpql, Room.class);
        return query.setParameter("value", Status.ON)
                .getResultList();
    }
}
