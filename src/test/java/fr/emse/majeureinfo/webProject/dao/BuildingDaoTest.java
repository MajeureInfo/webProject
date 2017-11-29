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
public class BuildingDaoTest {

    protected static final DbSetupTracker TRACKER = new DbSetupTracker();
    private static final Operation DELETE_ALL = DeleteAll.from( "BUILDING_ROOMS", "BUILDING", "ROOM", "LIGHT", "NOISE");

    @Autowired
    private BuildingDao buildingDao;
    @Qualifier("dataSource")
    @Autowired
    private DataSource dataSource;

    protected void dbSetup(Operation op1, Operation op2, Operation op3, Operation op4, Operation op5, Operation op6, Operation op7, Operation op8, Operation op9, Operation op10, Operation op11, Operation op12, Operation op13, Operation op14) {
        DbSetup setup = new DbSetup(new DataSourceDestination(dataSource),
                Operations.sequenceOf(DELETE_ALL, op1, op2, op3, op4, op5, op6, op7, op8, op9, op10, op11, op12, op13, op14));
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
        Operation light3 =
                Insert.into("LIGHT")
                        .columns("id", "level", "status")
                        .values(3L, 3, Status.OFF)
                        .build();
        Operation noise3 =
                Insert.into("NOISE")
                        .withDefaultValue("status", Status.ON)
                        .columns("id", "level")
                        .values(3L, 33)
                        .build();
        Operation room3 =
                Insert.into("ROOM")
                        .columns("ID", "LIGHT_ID", "NOISE_ID")
                        .values(3L, 3L, 3L)
                        .build();
        Operation building1 =
                Insert.into("BUILDING")
                    .columns("ID", "NAME")
                    .values(1L,"Espace Fauriel")
                    .build();
        Operation building2 =
                Insert.into("BUILDING")
                        .columns("ID", "NAME")
                        .values(2L,"158 Cours Fauriel")
                        .build();
        Operation building_rooms1 =
                Insert.into("BUILDING_ROOMS")
                    .columns("BUILDING_ID", "ROOMS_ID")
                    .values(1L,1L)
                    .build();
        Operation building_rooms2 =
                Insert.into("BUILDING_ROOMS")
                        .columns("BUILDING_ID", "ROOMS_ID")
                        .values(1L,2L)
                        .build();
        Operation building_rooms3 =
                Insert.into("BUILDING_ROOMS")
                        .columns("BUILDING_ID", "ROOMS_ID")
                        .values(2L,3L)
                        .build();
        dbSetup(light1, noise1, room1, light2, noise2, room2, light3, noise3, room3, building1, building2, building_rooms1, building_rooms2, building_rooms3);
    }

    @Test
    public void shouldFindAllBuildings() {
        TRACKER.skipNextLaunch();
        assertThat(buildingDao.findAll()).hasSize(2);
    }
}
