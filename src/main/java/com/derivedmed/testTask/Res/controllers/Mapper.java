package com.derivedmed.testTask.Res.controllers;

import com.derivedmed.testTask.Res.shop.Position;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Singleton. Csv reader and writer. It uses opencsv lib.
 */
public class Mapper {
    private CSVReader csvReader;
    private List<String[]> lineArrs = new ArrayList<String[]>();
    private List<Position> positions = new ArrayList<Position>();
    private static Mapper instance;

    /**
     * On instance creation it creates our catalouge {@link Mapper#positions}
     * @param path
     * @throws IOException
     */
    private Mapper(String path) throws IOException {
        csvReader = new CSVReader(new FileReader(path));
        arrayFiller();
        listFiller();
        csvReader.close();
    }

    public static Mapper getInstance(String path){
        if (instance == null){
            try {
                instance = new Mapper(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return instance;
    }

    /**
     * Filling array of Strings. Every String is String from csv file.
     * @throws IOException
     */
    private void arrayFiller()  {
        String[] nextline;
        try {
            while ((nextline = csvReader.readNext()) != null) {
                lineArrs.add(nextline);
            }
        } catch (IOException e) {
            System.out.println("Cant read file");
        }
    }

    /**
     * Catalouge {@link Mapper#positions} filler.
     */
    private void listFiller() {
        for (String[] linearr : lineArrs) {
            Position position1 = new Position();
            position1.setName(linearr[0]);
            position1.setPrice(Double.parseDouble(linearr[1].replaceAll(" ", "")));
            position1.setType(linearr[2]);
            position1.setAmount(Double.parseDouble(linearr[3].replaceAll(" ", "")));
            position1.setOptional(linearr[4]);
            position1.setCount(Integer.parseInt(linearr[5].replaceAll(" ", "")));
            positions.add(position1);
        }
    }

    public List<Position> getPositions() {
        return positions;
    }

    /**
     * Gets data List, creates csv file.
     * @param data
     */
    public static void writeData(List<Position> data){
        try {
            CSVWriter csvWriter = new CSVWriter(Files.newBufferedWriter(Paths.get("./src/main/resources/result.csv")),CSVWriter.DEFAULT_SEPARATOR,
                    CSVWriter.NO_QUOTE_CHARACTER,
                    CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                    CSVWriter.DEFAULT_LINE_END);
            List<String[]> finaldata = dataCreation(data);
            for (String [] finaldatas : finaldata ) {
                csvWriter.writeNext(finaldatas);
            }
            csvWriter.close();
        } catch (IOException e) {
            System.out.println("Cant create file");
        }
    }

    /**
     * Generating data List of Strings from {@link Position} `s List.
     * @param data
     * @return
     */
    private static List<String[]> dataCreation(List<Position>data){
        List<String[]> datas = new ArrayList<String[]>();
        for (Position datum : data) {
            String[] currentData = new String[datum.getFieldscount()];
            currentData[0] =  datum.getName();
            currentData[1] = " "+String.valueOf(datum.getPrice());
            currentData[2] = datum.getType();
            currentData[3] = " "+String.valueOf(datum.getAmount());
            currentData[4] = datum.getOptional();
            currentData[5] = " "+String.valueOf(datum.getCount());
            datas.add(currentData);
        }
        return datas;
    }
}
