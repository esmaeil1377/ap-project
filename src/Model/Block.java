package Model;

import java.util.ArrayList;

public class Block {
    private static int Level = 1;
    private static int Id;
    static ArrayList<Bazar> BazarArrayList;
    private static ArrayList<Padafand> PadafandArrayList;
    private static ArrayList<House> HouseArrayList;
    private static ArrayList<Army> ArmyArrayList;


    public static void setArmyArrayList(ArrayList<Army> armyArrayList) {
        ArmyArrayList = armyArrayList;
    }

    public static ArrayList<House> getHouseArrayList() {
        return HouseArrayList;
    }

    public static void setHouseArrayList(ArrayList<House> houseArrayList) {
        HouseArrayList = houseArrayList;
    }

    public static ArrayList<Army> getArmyArrayList() {
        return ArmyArrayList;
    }

    public void setBazarArrayList(ArrayList<Bazar> bazarArrayList) {
        BazarArrayList = bazarArrayList;
    }

    public static ArrayList<Bazar> getBazarArrayList() {
        return BazarArrayList;
    }

    public void setPadafandArrayList(ArrayList<Padafand> padafandArrayList) {
        PadafandArrayList = padafandArrayList;
    }

    public  static ArrayList<Padafand> getPadafandArrayList() {
        return PadafandArrayList;
    }

    public static void setLevel(int level) {
        Level = level;
    }

    public static int getId() {
        return Id;
    }

    public static void setId(int id) {
        Id = id;
    }

    public static int getLevel() {
        return Level;
    }

    public static int getPupulation(){
        int Pupulation =0;
        for(House house:Block.getHouseArrayList()){
            for(Floor floor:house.getArrayListFloors()){
                Pupulation +=(floor.ArrayListunits.size()) *5;
                }
            }

        return(Pupulation);
    }



    public static void setScoreForPersons(){

        for(Bazar bazar:Block.getBazarArrayList()){
            int a=0;
            int tedadaemplyedbyBazar=50+(bazar.getLevel()-1)*20;
        for(House house:Block.getHouseArrayList()){
            for(Floor floor:house.getArrayListFloors()){
                for(Unit unit:floor.getArrayListunits()){
                   for(Person person:unit.getPersonArrayList()){
                       if(a<tedadaemplyedbyBazar){
                       if(person.getPersonScore()==1){
                          person.setPersonScore(1+(float)(bazar.getLevel()*(0.2)));
                   }
                   }

        }
    }
            }
        }
        }
    }


    public static int getٍEmployedNum(){
        int employedpeple=0;
        for(Bazar bazar:Block.getBazarArrayList()){
            int lev=bazar.getLevel();
            employedpeple+=50+(lev-1)*20;
        }
        for(Army army:Block.getArmyArrayList()){
            employedpeple+=100+(army.getLevel()-1)*10;
        }
        for(Padafand padafand:Block.getPadafandArrayList()){
            employedpeple+=30;
        }
        return(employedpeple);
    }


}
