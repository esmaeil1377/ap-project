package Controller;

import Model.AddDefense;
import Model.Requests;

import static Controller.RequestAnalyzer.getRequest;
import static View.View.getCommand;

public class CityController {


    public static void lookingForCommand(){

        while(true){
            Requests request=getRequest(getCommand());
            System.out.println(getCommand());
            if((getCommand().matches("[Y|y][I|i][E|e][L|l][D|d]"))){
                System.out.println("father");
                break;
            }

        }
    }

}
