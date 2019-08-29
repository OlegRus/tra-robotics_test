import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

class SetupsTest {

    private static Retrofit retrofit;
    protected final static AlaskaApi alaska;

    static {
        Gson gson = new GsonBuilder().setLenient().create();

        retrofit = new Retrofit.Builder().baseUrl("http://localhost:8091")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        alaska = retrofit.create(AlaskaApi.class);
    }

    @BeforeSuite
    public void setUp() {
        ContainerManager.run();
    }

    @AfterSuite
    public void tearDown() {
        ContainerManager.stop();
        ContainerManager.delete();
    }

}