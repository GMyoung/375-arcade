package com.sxt.leaderboard;


import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;

import java.io.*;
import java.util.*;

public class LeaderBoard {
    private static final String  COMMA_DELIMITER = ",";

    public static String[] getLeaderBoardEntries() {
        List<LeaderBoardEntry> currentBoard = getLeaderBoard();
        List<String> entries = new ArrayList<>();

        for (LeaderBoardEntry entry: currentBoard) {
            entries.add(entry.getName() + ": " + entry.getScore());
        }

        return entries.toArray(new String[entries.size()]);

    }


    //https://www.baeldung.com/java-csv-file-array

    public static List<LeaderBoardEntry> getLeaderBoard() {
        List<List<String>> records = new ArrayList<>();

        File f = new File("leaderboard.csv");
        if (!f.exists()) {
            try {
                f.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        try (CSVReader csvReader = new CSVReader(new FileReader("leaderboard.csv"));) {
            String[] values;
            while ((values = csvReader.readNext()) != null) {
                records.add(Arrays.asList(values));
            }
        } catch (IOException | CsvValidationException e) {
            throw new RuntimeException(e);
        }
        ArrayList<LeaderBoardEntry> leaderBoardEntries = new ArrayList<>();


        for(List<String> record : records) {
            if (!record.get(0).equals("Name")) { //avoid first row.
                leaderBoardEntries.add(new LeaderBoardEntry(Integer.parseInt(record.get(0)), record.get(1)));
            }
        }

        return leaderBoardEntries;
    }

    //<<Score, Name>, <Score, Name>, <Score,Name> ... >
    public static void saveLeaderBoard(List<LeaderBoardEntry> leaderBoardEntries) throws IOException, CsvException {
        CSVWriter writer = new CSVWriter(new FileWriter("leaderboard.csv"));

        writer.writeNext(new String[]{"Name", "Score"});
        for(LeaderBoardEntry record: leaderBoardEntries) {
            String[] temp = new String[] {record.getScore(), record.getName()};
            writer.writeNext(temp);
        }
        writer.close();

    }

    public static void addNewLeaderBoardEntry(Integer score, String name) throws IOException, CsvException {
            //We're going to go ahead and:
            //Process the leader board.
            //Sort The leaderboard by List<String>[0] --> Score.
            //Recreate the leaderboard.
            List<LeaderBoardEntry> leaderboard = getLeaderBoard();
            leaderboard.add(new LeaderBoardEntry(score, name));
            Collections.sort(leaderboard);

            if (leaderboard.size() > 5) {
                leaderboard.remove(leaderboard.size() - 1);
            }
            System.out.println(leaderboard);
            saveLeaderBoard(leaderboard);
    }
}
