import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateBearTest extends SetupsTest {

    @DataProvider
    public Object[][] bears() {
        return new Object[][]{
                {new Bear(BearType.GUMMY, "test1", 0.0)}, {new Bear(BearType.POLAR, "+test", 50.0)},
                {new Bear(BearType.BLACK, "+test", 0.0)}, {new Bear(BearType.BLACK, "тест", 50.0)},
                {new Bear(BearType.POLAR, "тест", 0.0)}, {new Bear(BearType.BLACK, "test1", 100.0)},
                {new Bear(BearType.BROWN, "tEst", 50.0)}, {new Bear(BearType.POLAR, "tEst", 100.0)},
                {new Bear(BearType.GUMMY, "+test", 100.0)}, {new Bear(BearType.BROWN, "test1", 100.0)},
                {new Bear(BearType.GUMMY, "тест", 50.0)}, {new Bear(BearType.POLAR, "test1", 50.0)},
                {new Bear(BearType.BROWN, "тест", 100.0)}, {new Bear(BearType.GUMMY, "tEst", 0.0)},
                {new Bear(BearType.BROWN, "+test", 0.0)}, {new Bear(BearType.BLACK, "tEst", 100.0)}};
    }

    @Test(dataProvider = "bears")
    public void testCreateBear(Bear bear) throws IOException {
        int id = alaska.create(bear).execute().body();
        Bear responseBear = alaska.getBear(id).execute().body();
        Assert.assertEquals(responseBear, bear);
    }
}
