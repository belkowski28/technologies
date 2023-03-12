package com.example.technologies.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CsvReader {

    private static CsvReader instance = null;
    private BufferedReader reader = null;
    private String line = "";
    private ArrayList<Punch> punches = new ArrayList<>();

    private String file = "src/main/resources/csv/wykrojniki.csv";

    private CsvReader() {

        try {
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(";");
                punches.add(new Punch(Double.valueOf(row[0]), Double.valueOf(row[1]), Double.valueOf(row[2])));
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static CsvReader getInstance() {
        if (instance == null) {
            instance = new CsvReader();
        }
        return instance;
    }

    public ArrayList<Punch> getPunches () {
        return punches;
    }
}
