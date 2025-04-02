import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class AdTest {
    public Ad a1;

    @BeforeEach
    void setUp() {
        new Ad(1, 4, "200,500" +
                "" +
                "   ", 4, 800, "jofele", false,
            "asd.com/img", "3030-04-24",
            new Seller(1, "Leon", "0652035674"), new Category(1, "elado"));
    }

    @Test
    void loadFromCsv() {
        // ...
    }

    @Test
    void distanceTo() {
        a1.distanceTo(123.21, 255.89);
        Assertions.assertEquals(0, a1.distanceTo(123, 255));
    }

    @Test
    void getFloors() {
    }

    @Test
    void getArea() {
    }

    @Test
    void isFreeOfCharge() {
    }

    @Test
    void getSeller() {
    }

    @Test
    void getRooms() {
    }
}