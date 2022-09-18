package com.cs.commandos;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CsvReader {
    public static void main(String[] args) {

        try (BufferedReader br = Files.newBufferedReader(Paths.get("D:\\Hackathon-2022\\seat-master.csv"))) {

            // CSV file delimiter
            String DELIMITER = ",";


            // read the file line by line
            String line;
            int cnt = 0;
            while ((line = br.readLine()) != null) {
                cnt++;
                StringBuilder sb = new StringBuilder();
                sb.append("INSERT INTO space_master (space_number, space_tracking_number, machine_id, zone, floor, building, phase, city, country, availability_status) VALUES (");

                if(cnt > 1) {
                    // convert line into columns
                    String[] columns = line.split(DELIMITER);
                    for (int i = 1; i < columns.length; i++) {
                        if (i == columns.length - 1)
                            sb.append("'" + columns[i] + "'");
                        else
                            sb.append("'" + columns[i] + "'" + ",");

                    }

                    sb.append(");");
                    System.out.println(sb.toString());
                }

            }

            System.out.println("Total line read:"+cnt);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
