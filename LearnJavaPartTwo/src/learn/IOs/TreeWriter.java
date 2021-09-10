package learn.IOs;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TreeWriter {
    public void writeTxt(String pathToDirectory) {
        try(FileWriter fileWriter = new FileWriter(pathToDirectory + "/out.txt")) {
            String files = assembleString(new File(pathToDirectory), 0);
            fileWriter.write(files.substring(0, files.length()-1));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String assembleString(File directory, int recursionCount) {
        StringBuilder treeString = new StringBuilder();
        File[] filesInDirectory = directory.listFiles();
        assert filesInDirectory != null;

        treeString.append("*dir*").append(directory.getName()).append("\n");
        recursionCount++;

        for (File file : filesInDirectory) {
            treeString.append(" ".repeat(recursionCount));
            if (file.isDirectory()) {
                treeString.append(assembleString(file, recursionCount));
            } else {
                treeString.append(file.getName()).append("\n");
            }
        }
        return treeString.toString();
    }
}
