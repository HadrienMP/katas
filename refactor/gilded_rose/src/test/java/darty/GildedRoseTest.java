package darty;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class GildedRoseTest {

    public static final String GOLDEN_MASTER_PATH = "/home/hadrienmp/Projets/katas/GildedRose/src/test/java/darty/golden-master.txt";

    @Test
    public void golden_master() throws IOException {
        List<String> goldenMaster = Files.readAllLines(Paths.get(GOLDEN_MASTER_PATH), StandardCharsets.UTF_8);
        System.out.print(goldenMaster);

        List<String> ouput = TextTestFixture.runGoldenMaster(new String[] {});

        ouput.remove(ouput.size() - 1);

        Assertions.assertThat(ouput).isEqualTo(goldenMaster);

    }

    @Test
    public void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

}