package Model;

public class TenisPlayer {

    protected int Id;
    protected String Name;
    protected String Country;
    protected int Age;
    protected int TotalTitles;
    protected int GrandSlamTitles;

    public TenisPlayer() {}

    public TenisPlayer(int id, String name, String country, int age, int totalTitles, int grandSlamTitles) {
        Id = id;
        Name = name;
        Country = country;
        Age = age;
        TotalTitles = totalTitles;
        GrandSlamTitles = grandSlamTitles;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public int getTotalTitles() {
        return TotalTitles;
    }

    public void setTotalTitles(int totalTitles) {
        TotalTitles = totalTitles;
    }

    public int getGrandSlamTitles() {
        return GrandSlamTitles;
    }

    public void setGrandSlamTitles(int grandSlamTitles) {
        GrandSlamTitles = grandSlamTitles;
    }

    @Override
    public String toString() {
        return Id + "," + Name + ',' + Country + ',' + Age + "," + TotalTitles + "," + GrandSlamTitles;
    }


}
