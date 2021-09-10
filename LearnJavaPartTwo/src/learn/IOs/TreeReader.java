package learn.IOs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TreeReader {
    public void readTxt(String pathToFile) {
        try(FileReader fileReader = new FileReader(pathToFile); BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            ArrayList<String> lines = new ArrayList<>();
            bufferedReader.lines().forEach(lines::add);
            List<String> linesTrimmed = removeStylization(lines);

            int amountOfDirectories = calculateAmountOfDirectories(linesTrimmed);
            int amountOfFiles = linesTrimmed.size()-amountOfDirectories;
            int averageFileNameLength = calculateAverageLengthOfFileName(linesTrimmed);
            int averageFileAmount = calculateAverageAmountOfFilesInDirectory(linesTrimmed);

            System.out.println("Amount of directories is " + amountOfDirectories);
            System.out.println("Amount of files is " + amountOfFiles);
            System.out.println("Average file name length is " + averageFileNameLength);
            System.out.println("Average amount of files in a directory is " + averageFileAmount);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private ArrayList<String> removeStylization(ArrayList<String> lines) {
        lines.replaceAll(String::trim);
        return lines;
    }

    private int calculateAmountOfDirectories(List<String> files) {
        int amountOfDirectories = 0;
        for(String file : files) {
            if(file.startsWith("*dir*")) {
                amountOfDirectories++;
            }
        }
        return amountOfDirectories;
    }

    private int calculateAverageLengthOfFileName(List<String> files) {
        try {
            int averageLength = 0;
            int amountOfFiles = 0;
            for (String file : files) {
                if (!file.startsWith("*dir*")) {
                    averageLength += file.length();
                    amountOfFiles++;
                }
            }
            return averageLength / amountOfFiles;
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }
        return 0;
    }

    private int calculateAverageAmountOfFilesInDirectory(List<String> files) {
        try {
            int amountOfFiles = 0;
            int amountOfDirs = 0;
            for (String file : files) {
                if (file.startsWith("*dir*")) {
                    amountOfDirs++;
                } else {
                    amountOfFiles++;
                }
            }
            return amountOfFiles / amountOfDirs;
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
