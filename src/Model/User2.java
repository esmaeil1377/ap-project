package Model;

public class User2 extends usertotal {
    public static int Score;
    private static int Gills = 30000;
    public static int AfterDayGills=30000;
    private int UserId;
    public City city2=new City();

    public void setAfterDayGills() {
        AfterDayGills = this.Gills;
    }

    public City getCity2() {
        return city2;
    }

    public static int getScore() {
        return Score;
    }

    public static void setScore(int score) {
        Score = score;
    }

    public static int getGills() {
        return Gills;
    }

    public static void setGills(int gills) {
        Gills = gills;
    }
}