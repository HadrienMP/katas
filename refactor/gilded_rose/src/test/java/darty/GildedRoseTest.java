package darty;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class GildedRoseTest {

    public static final String GOLDEN_MASTER_PATH = "/home/hadrienmp/Projets/katas/GildedRose/src/test/java/darty/golden-master.txt";

    @Test
    public void golden_master() throws IOException, URISyntaxException {
        List<String> goldenMaster = Files.readAllLines(
                Paths.get(
                        ClassLoader.getSystemResource("darty/golden-master.txt")
                                .toURI()),
                StandardCharsets.UTF_8);
        System.out.print(goldenMaster);

        List<String> ouput = TextTestFixture.runGoldenMaster(new String[] {});

        ouput.remove(ouput.size() - 1);

        Assertions.assertThat(ouput).isEqualTo(goldenMaster);

    }
}