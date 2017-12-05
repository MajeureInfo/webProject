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

    protected void dbSetup(Operation op) {
        DbSetup setup = new DbSetup(new DataSourceDestination(dataSource), op);
        TRACKER.launchIfNecessary(setup);
    }

    @Before
    public void prepare() {
        Operation op = Operations.sequenceOf(DELETE_ALL,
                Insert.into("LIGHT")
                        .columns("id", "level", "status")
                        .values(1L, 22, Status.ON)
                        .build(),

                Insert.into("NOISE")
                        .withDefaultValue("status", Status.OFF)
                        .columns("id", "level")
                        .values(1L, 12)
                        .build(),

                Insert.into("ROOM")
                        .columns("ID", "LIGHT_ID", "NOISE_ID")
                        .values(1L, 1L, 1L)
                        .build(),

                Insert.into("LIGHT")
                        .columns("id", "level", "status")
                        .values(2L, 223, Status.OFF)
                        .build(),

                Insert.into("NOISE")
                        .withDefaultValue("status", Status.ON)
                        .columns("id", "level")
                        .values(2L, 34)
                        .build(),

                Insert.into("ROOM")
                        .columns("ID", "LIGHT_ID", "NOISE_ID")
                        .values(2L, 2L, 2L)
                        .build(),

                Insert.into("LIGHT")
                        .columns("id", "level", "status")
                        .values(3L, 56, Status.ON)
                        .build(),

                Insert.into("NOISE")
                        .withDefaultValue("status", Status.ON)
                        .columns("id", "level")
                        .values(3L, 42)
                        .build(),

                Insert.into("ROOM")
                        .columns("ID", "LIGHT_ID", "NOISE_ID")
                        .values(3L, 3L, 3L)
                        .build());
        dbSetup(op);
    }

    @Test
    public void shouldFindAllLights() {
        TRACKER.skipNextLaunch();
        assertThat(roomDao.findAll()).hasSize(3);
    }

    @Test
    public void listWithLightOn() {
        TRACKER.skipNextLaunch();
        assertThat(roomDao.listWithLightOn()).hasSize(2);
    }

    @Test
    public void listWithLightOff() {
        TRACKER.skipNextLaunch();
        assertThat(roomDao.listWithLightOff()).hasSize(1);
    }

    @Test
    public void listWithRingerOn() {
        TRACKER.skipNextLaunch();
        assertThat(roomDao.listWithRingerOn()).hasSize(2);
    }

    @Test
    public void listWithRingerOff() {
        TRACKER.skipNextLaunch();
        assertThat(roomDao.listWithRingerOff()).hasSize(1);
    }
}
