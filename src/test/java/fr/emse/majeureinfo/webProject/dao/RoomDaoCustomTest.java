package fr.emse.majeureinfo.webProject.dao;


import com.ninja_squad.dbsetup.DbSetup;
import com.ninja_squad.dbsetup.DbSetupTracker;
import com.ninja_squad.dbsetup.Operations;
import com.ninja_squad.dbsetup.destination.DataSourceDestination;
import com.ninja_squad.dbsetup.operation.DeleteAll;
import com.ninja_squad.dbsetup.operation.Insert;
import com.ninja_squad.dbsetup.operation.Operation;
import fr.emse.majeureinfo.webProject.model.Status;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestPropertySource("/test.properties")
public class RoomDaoCustomTest {

    protected static final DbSetupTracker TRACKER = new DbSetupTracker();
    private static final Operation DELETE_ALL = DeleteAll.from("ROOM", "LIGHT", "NOISE");

    @Autowired
    private RoomDao roomDao;
    @Qualifier("dataSource")
    @Autowired
    private DataSource dataSource;

    protected void dbSetup(Operation op1, Operation op2, Operation op3, Operation op4, Operation op5, Operation op6) {
        DbSetup setup = new DbSetup(new DataSourceDestination(dataSource),
                Operations.sequenceOf(DELETE_ALL, op1, op2, op3, op4, op5, op6));
        TRACKER.launchIfNecessary(setup);
    }

    @Before
    public void prepare() {
        Operation light1 =
                Insert.into("LIGHT")
                        .columns("id", "level", "status")
                        .values(1L, 22, Status.ON)
                        .build();
        Operation noise1 =
                Insert.into("NOISE")
                        .withDefaultValue("status", Status.ON)
                        .columns("id", "level")
                        .values(1L, 12)
                        .build();
        Operation room1 =
                Insert.into("ROOM")
                        .columns("ID", "LIGHT_ID", "NOISE_ID")
                        .values(1L, 1L, 1L)
                        .build();
        Operation light2 =
                Insert.into("LIGHT")
                        .columns("id", "level", "status")
                        .values(2L, 223, Status.OFF)
                        .build();
        Operation noise2 =
                Insert.into("NOISE")
                        .withDefaultValue("status", Status.ON)
                        .columns("id", "level")
                        .values(2L, 34)
                        .build();
        Operation room2 =
                Insert.into("ROOM")
                        .columns("ID", "LIGHT_ID", "NOISE_ID")
                        .values(2L, 2L, 2L)
                        .build();
        dbSetup(light1, noise1, room1, light2, noise2, room2);
    }

    @Test
    public void listWithOnLight() {
        TRACKER.skipNextLaunch();
        assertThat(roomDao.listWithOnLight()).hasSize(1);
    }

    @Test
    public void shouldFindAllLights() {
        TRACKER.skipNextLaunch();
        assertThat(roomDao.findAll()).hasSize(2);
    }
}
