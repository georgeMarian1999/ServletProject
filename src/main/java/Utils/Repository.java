package Utils;

import Model.TenisPlayer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Repository {
    public Repository() { }

    public List<TenisPlayer> readPlayers() throws IOException {
        List<TenisPlayer> result = new ArrayList<>();
        FileReader fileReader = new FileReader("tenisplayers.txt");
//        Scanner scanner = new Scanner(fileReader);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        while (bufferedReader.readLine() != null) {
            String[] tokens = bufferedReader.readLine().split(";");
            TenisPlayer tenisPlayer = new TenisPlayer(Integer.parseInt(tokens[0]), tokens[1], tokens[2], Integer.parseInt(tokens[3]), Integer.parseInt(tokens[4]), Integer.parseInt(tokens[5]));
            result.add(tenisPlayer);
        }
        return result;
    }

    public int savePlayer(TenisPlayer tenisPlayer) throws Exception {
        List<TenisPlayer> players = readPlayers();
        try{
            FileWriter fileWriter = new FileWriter("tenisplayers");
            tenisPlayer.setId(players.size() + 1);
            String newPlayer = tenisPlayer.toString();
            fileWriter.write(newPlayer);
            fileWriter.close();
            return 0;
        }
        catch (IOException e){
            return 1;
        }
    }

    public int saveAllPlayers(List<TenisPlayer> tenisPlayers) throws Exception {
        int status = 0;
        for (TenisPlayer player : tenisPlayers) {
            status = savePlayer(player);
        }
        return status;
    }

    public int updatePlayer(TenisPlayer tenisPlayer) throws Exception {
        try {
            List<TenisPlayer> players = readPlayers();
            for (TenisPlayer tp : players) {
                if (tp.equals(tenisPlayer)) {
                    tp.setName(tenisPlayer.getName());
                    tp.setCountry(tenisPlayer.getCountry());
                    tp.setAge(tenisPlayer.getAge());
                    tp.setTotalTitles(tenisPlayer.getTotalTitles());
                    tp.setGrandSlamTitles(tenisPlayer.getGrandSlamTitles());
                    int status = saveAllPlayers(players);
                    return 0;
                }
            }
        }
        catch (Exception e){
                e.printStackTrace();
                return 1;
            }
        return 0;
    }

    public int deletePlayer(TenisPlayer tenisPlayer) throws Exception {
        List<TenisPlayer> players = readPlayers();
        try{
            for (TenisPlayer tp : players) {
                if (tp.equals(tenisPlayer)){
                    players.remove(tp);
                    int status = saveAllPlayers(players);
                    return status;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }



}

