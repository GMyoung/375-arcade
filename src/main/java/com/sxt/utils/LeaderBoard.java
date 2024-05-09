package com.sxt.utils;


import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;

import java.io.*;
import java.util.*;

public class LeaderBoard {
    private static final String  COMMA_DELIMITER = ",";


    //https://www.baeldung.com/java-csv-file-array

    public List<LeaderBoardEntry> getLeaderBoard() {
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

        System.out.println(records);
        records.remove(0);
        for(List<String> record : records) {
            leaderBoardEntries.add(new LeaderBoardEntry(Integer.parseInt(record.get(0)), record.get(1)));
        }

        return leaderBoardEntries;
    }

    //<<Score, Name>, <Score, Name>, <Score,Name> ... >
    public void saveLeaderBoard(List<LeaderBoardEntry> leaderBoardEntries) throws IOException, CsvException {
        CSVWriter writer = new CSVWriter(new FileWriter("leaderboard.csv"));

        writer.writeNext(new String[]{"Name", "Score"});
        for(LeaderBoardEntry record: leaderBoardEntries) {
            String[] temp = new String[] {record.getScore(), record.getName()};
            writer.writeNext(temp);
        }
        writer.close();

    }

    public void addNewLeaderBoardEntry(Integer score, String name) throws IOException, CsvException {
            //We're going to go ahead and:
            //Process the leader board.
            //Sort The leaderboard by List<String>[0] --> Score.
            //Recreate the leaderboard.
            List<LeaderBoardEntry> leaderboard = getLeaderBoard();
            leaderboard.add(new LeaderBoardEntry(score, name));
            Collections.sort(leaderboard);
            if (leaderboard.size() > 10) {
                leaderboard.remove(leaderboard.size() - 1);
            }
            
            saveLeaderBoard(leaderboard);
    }
}
