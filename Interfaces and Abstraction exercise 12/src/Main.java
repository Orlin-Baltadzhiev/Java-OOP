import military.Interfaces.*;
import military.entities.*;
import military.enums.Corps;

import javax.swing.plaf.nimbus.State;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import static java.lang.Double.parseDouble;

public class Main {
    private static Map<Integer, Soldier> soldiersByIds = new LinkedHashMap<>();
    private static Map<Integer, LieutenantGeneral> lieutenantGeneralByIds = new LinkedHashMap<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String input = scanner.nextLine();
        
        while (!input.equals("End")){

            Soldier  soldier    = createSoldier(input);
            if(soldier != null){

                soldiersByIds.put(soldier.getId(),soldier);
            }

            input = scanner.nextLine();
        }
        for (Soldier value : soldiersByIds.values()) {
            System.out.println(value.toString());

        }
    }

    private static Soldier createSoldier(String input) {
        String[] tokens = input.split("\\s+");

        String type =tokens[0];
        Soldier aPrivate;

        switch (type){
            case "Private":
                aPrivate=new PrivateImpl(Integer.parseInt(tokens[1]),
                        tokens[2],
                        tokens[3],
                        parseDouble(tokens[4]));
                break;
            case "Commando":
                aPrivate = createCommando(tokens);
                break;
            case "LieutenantGeneral":
                aPrivate= createLieutenantGeneral(tokens);
                break;
            case "Spy":
                aPrivate=new SpyImpl(Integer.parseInt(tokens[1]),
                        tokens[2],
                        tokens[3],
                        tokens[4]);
                break;
            case "Engineer":
                aPrivate = createEngineer(tokens);
                break;
            default:
                aPrivate = null;
                break;

        }

        return  aPrivate;
    }

    private static Soldier createCommando(String[] tokens) {
        String corps = tokens[5];
        if (corps.equals("Airforces") || corps.equals("Marines")) {
            CommandoImpl commando = new CommandoImpl(Integer.parseInt(tokens[1]),
                    tokens[2],
                    tokens[3],
                    parseDouble(tokens[4]),
                    Corps.valueOf(corps.toUpperCase()));
            for (int i = 6; i < tokens.length; i += 2) {
                String codeName = tokens[i];
                String state =tokens[i + 1];

                if(!state.equals("inProgress") &&  !state.equals("finished")){
                    continue;
                }

                Mission mission = new MissionImpl(codeName, state.equals("inProgress") ? MissionImpl.Status.IN_PROGRESS:
                        MissionImpl.Status.FINISHED);
              commando.addMission(mission);
            }
            return commando;
        }
        return null;
    }

    private static Soldier createEngineer(String[] tokens) {
        String corps = tokens[5];
        if (corps.equals("Airforces") || corps.equals("Marines")) {
            EngineerImpl engineer = new EngineerImpl(Integer.parseInt(tokens[1]),
                    tokens[2],
                    tokens[3],
                    parseDouble(tokens[4]),
                    Corps.valueOf(corps.toUpperCase()));

            for (int i = 6; i < tokens.length; i += 2) {
                String partName = tokens[i];
                int hoursWorked = Integer.parseInt(tokens[i + 1]);
                Repair repair = new RepairImpl(partName, hoursWorked);
                engineer.addRepair(repair);

            }
            return engineer;
        }
        return null;

    }

    private static Soldier createLieutenantGeneral(String[] tokens) {
        LieutenantGeneral lieutenantGeneral=new LieutenantGeneralImpl(Integer.parseInt(tokens[1]),
                tokens[2],
                tokens[3],
                Double.parseDouble(tokens[4]));
        for (int i = 5; i < tokens.length; i++) {
            lieutenantGeneral.addPrivate(soldiersByIds.get(Integer.parseInt(tokens[i])));
            
        }
        return lieutenantGeneral;

    }
}
