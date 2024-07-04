package com.coderscampus.phoebe_assignment_9.web;

import com.coderscampus.phoebe_assignment_9.domain.Recipe;
import com.coderscampus.phoebe_assignment_9.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class FileController {

    final String fileName = "phoebe-assignment-9/recipes.txt";

    @Autowired
    private FileService fileService;

    @GetMapping("/all-recipes")
    public List<Recipe> readAllRecipes() throws IOException {
        return fileService.readFile(fileName);
    }

    @GetMapping("/gluten-free")
    public List<Recipe> readGlutenFreeRecipes() throws IOException {
        return fileService.readFile(fileName)
                          .stream()
                          .filter(Recipe::getGlutenFree)
                          .collect(Collectors.toList());
    }

    @GetMapping("/vegan")
    public List<Recipe> readVeganRecipes() throws IOException {
        return fileService.readFile(fileName)
                          .stream()
                          .filter(Recipe::getVegan)
                          .collect(Collectors.toList());
    }

    @GetMapping("/vegan-and-gluten-free")
    public List<Recipe> readVeganAndGlutenFreeRecipes() throws IOException {
        return fileService.readFile(fileName)
                          .stream()
                          .filter(Recipe::getVegan)
                          .filter(Recipe::getGlutenFree)
                          .collect(Collectors.toList());
    }

    @GetMapping("/vegetarian")
    public List<Recipe> readVegetarianRecipes() throws IOException {
        return fileService.readFile(fileName)
                          .stream()
                          .filter(Recipe::getVegetarian)
                          .collect(Collectors.toList());
    }
}
