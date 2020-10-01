package learn.java.cleancode;

import learn.java.cleancode.models.ClassificationLevel;
import learn.java.cleancode.models.ExperimentalTypes;
import learn.java.cleancode.models.MilitaryPlaneType;
import learn.java.cleancode.planes.ExperimentalPlane;
import learn.java.cleancode.planes.MilitaryPlane;
import learn.java.cleancode.planes.PassengerPlane;
import learn.java.cleancode.planes.Plane;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static learn.java.cleancode.models.MilitaryPlaneType.BOMBER;
import static learn.java.cleancode.models.MilitaryPlaneType.TRANSPORT;

public class AirportTest {
    private static List<Plane> planes = Arrays.asList(
            new PassengerPlane("Boeing-737", 900, 12000, 60500, 164),
            new PassengerPlane("Boeing-737-800", 940, 12300, 63870, 192),
            new PassengerPlane("Boeing-747", 980, 16100, 70500, 242),
            new PassengerPlane("Airbus A320", 930, 11800, 65500, 188),
            new PassengerPlane("Airbus A330", 990, 14800, 80500, 222),
            new PassengerPlane("Embraer 190", 870, 8100, 30800, 64),
            new PassengerPlane("Sukhoi Superjet 100", 870, 11500, 50500, 140),
            new PassengerPlane("Bombardier CS300", 920, 11000, 60700, 196),
            new MilitaryPlane("B-1B Lancer", 1050, 21000, 80000, MilitaryPlaneType.BOMBER),
            new MilitaryPlane("B-2 Spirit", 1030, 22000, 70000, MilitaryPlaneType.BOMBER),
            new MilitaryPlane("B-52 Stratofortress", 1000, 20000, 80000, MilitaryPlaneType.BOMBER),
            new MilitaryPlane("F-15", 1500, 12000, 10000, MilitaryPlaneType.FIGHTER),
            new MilitaryPlane("F-22", 1550, 13000, 11000, MilitaryPlaneType.FIGHTER),
            new MilitaryPlane("C-130 Hercules", 650, 5000, 110000, TRANSPORT),
            new ExperimentalPlane("Bell X-14", 277, 482, 500, ExperimentalTypes.HIGH_ALTITUDE, ClassificationLevel.SECRET),
            new ExperimentalPlane("Ryan X-13 Vertijet", 560, 307, 500, ExperimentalTypes.VTOL, ClassificationLevel.TOP_SECRET)
    );

    private Airport airport;

    @BeforeTest
    public void setUp() {
        airport = new Airport(planes);
    }

    @Test
    public void testGetTransportMilitaryPlanes() {
        // when
        List<MilitaryPlane> transportMilitaryPlanes = airport.getTransportMilitaryPlanes();
        // then
        Assert.assertEquals(transportMilitaryPlanes.size(), 1);
        MilitaryPlane actual = transportMilitaryPlanes.get(0);
        Assert.assertEquals(actual.getModel(), "C-130 Hercules");

    }

    @Test
    public void testGetPassengerPlaneWithMaxCapacity() {
        // when
        PassengerPlane expectedPlaneWithMaxPassengersCapacity = airport.getPassengerPlaneWithMaxPassengersCapacity();
        // then
        Assert.assertEquals(expectedPlaneWithMaxPassengersCapacity.getModel(), "Boeing-747");
    }

    @Test
    public void testArePlanesSortedByMaxLoadCapacity() {
        // when
        airport.sortByMaxLoadCapacity();
        // given
        List<? extends Plane> planes = airport.getPlanes();
        Assert.assertEquals(planes.get(0).getMaxLoadCapacity(), 500);
        Assert.assertEquals(planes.get(planes.size() - 1).getMaxLoadCapacity(), 110000);
    }

    @Test
    public void testArePlanesSortedByMaxSpeed() {
        // when
        airport.sortByMaxSpeed();
        // given
        List<? extends Plane> planes = airport.getPlanes();
        Assert.assertEquals(planes.get(0).getMaxSpeed(), 277);
        Assert.assertEquals(planes.get(planes.size() - 1).getMaxSpeed(), 1550);
    }

    @Test
    public void testArePlanesSortedByMaxDistance() {
        // when
        airport.sortByMaxDistance();
        // given
        List<? extends Plane> planes = airport.getPlanes();
        Assert.assertEquals(planes.get(0).getMaxFlightDistance(), 307);
        Assert.assertEquals(planes.get(planes.size() - 1).getMaxFlightDistance(), 22000);
    }

    @Test
    public void testHasAtLeastOneBomberInMilitaryPlanes() {
        // when
        List<MilitaryPlane> bomberMilitaryPlanes = airport.getBomberMilitaryPlanes();
        // then
        Assert.assertEquals(bomberMilitaryPlanes.size(), 3);
        Assert.assertSame(bomberMilitaryPlanes.get(0).getType(), BOMBER);
        Assert.assertSame(bomberMilitaryPlanes.get(1).getType(), BOMBER);
        Assert.assertSame(bomberMilitaryPlanes.get(2).getType(), BOMBER);
    }

    @Test
    public void testGetExperimentalPlanes() {
        // when
        List<ExperimentalPlane> experimentalPlanes = airport.getExperimentalPlanes();
        // then
        Assert.assertEquals(experimentalPlanes.size(), 2);
    }
}
