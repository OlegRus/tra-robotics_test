import java.util.Objects;

import com.google.gson.annotations.SerializedName;

public class Bear {

    @SerializedName("id")
    private int id;
    @SerializedName("bear_type")
    private BearType type;
    @SerializedName("bear_name")
    private String name;
    @SerializedName("bear_age")
    private double age;

    public Bear(BearType type, String name, double age) {
        this.id = 0;
        this.type = type;
        this.name = name;
        this.age = age;
    }

    public Bear(int id, BearType type, String name, double age) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public BearType getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public double getAge() {
        return age;
    }

    public void setType(BearType type) {
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(double age) {
        this.age = age;
    }

    @Override
    public int hashCode() {
        return this.type.hashCode() + this.name.hashCode() + Double.valueOf(this.age).hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Bear bear = (Bear) obj;
        return Objects.equals(type, bear.type) && Objects.equals(name, bear.name) && Objects.equals(age, bear.age);
    }

    @Override
    public String toString() {
        return type.name() + " " + name + " " + age;
    }
}