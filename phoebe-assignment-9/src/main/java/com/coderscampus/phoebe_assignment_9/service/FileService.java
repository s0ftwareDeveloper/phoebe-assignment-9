package com.coderscampus.phoebe_assignment_9.service;

import com.coderscampus.phoebe_assignment_9.domain.Recipe;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

@Service
public class FileService {

    public List<Recipe> readFile(String filename) throws IOException {

        List<Recipe> recipes = new ArrayList<>();

        Reader in = new FileReader(filename);

        CSVParser records = new CSVParser(in, CSVFormat.DEFAULT
                .withHeader()
                .withIgnoreSurroundingSpaces()
                .withEscape('\\'));

        for (CSVRecord record : records) {

            recipes.add(new Recipe(Integer.parseInt(record.get("Cooking Minutes")),
                    Boolean.parseBoolean(record.get("Dairy Free")),
                    Boolean.parseBoolean(record.get("Gluten Free")),
                    record.get("Instructions"),
                    Double.parseDouble(record.get("Preparation Minutes")),
                    Double.parseDouble(record.get("Price Per Serving")),
                    Integer.parseInt(record.get("Ready In Minutes")),
                    Integer.parseInt(record.get("Servings")),
                    Double.parseDouble(record.get("Spoonacular Score")),
                    record.get("Title"),
                    Boolean.parseBoolean(record.get("Vegan")),
                    Boolean.parseBoolean(record.get("Vegetarian"))));
        }

        return recipes;
    }
}
