import java.io.IOException;

import com.google.gson.JsonSyntaxException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RemoveBearTest extends SetupsTest {

    @Test
    public void removeBear() throws IOException {
        int id = alaska.create(new Bear(BearType.POLAR, "тест", 0.0)).execute().body();
        alaska.remove(id).execute();
        try {
            alaska.getBear(id).execute();
            Assert.fail("Bear doesn't remove");
        } catch (JsonSyntaxException ignored) {}
    }
}