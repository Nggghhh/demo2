package learn.IOs;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class JavaTree {
    public static void main(String[] args) {
        JavaTree javaTree = new JavaTree();
        javaTree.findPath(args);
    }

    public void findPath(String[] args) {
        if (args.length == 0) {
            System.out.println("You need to specify a path");
        } else {
            String path = args[0];
            determinePathDestinationAndActAccordingly(path);
        }
    }

    public void determinePathDestinationAndActAccordingly(String path) {
        File file = new File(path);
        if(path.endsWith(".txt")) {
            if(file.exists()) {
                readExistingTxtFile(path);
            } else {
                System.out.println("This file does not exist");
            }
        } else {
            if(file.exists()) {
                createTxtFileWithTreeStructure(path);
            } else {
                System.out.println("This directory does not exist");
            }
        }
    }

    private void createTxtFileWithTreeStructure(String pathToDirectory) {
        System.out.println("Creating new txt file in " + pathToDirectory);
        TreeWriter treeWriter = new TreeWriter();
        treeWriter.writeTxt(pathToDirectory);
    }

    private void readExistingTxtFile(String pathToFile) {
        System.out.println("Reading file " + pathToFile);
        TreeReader treeReader = new TreeReader();
        treeReader.readTxt(pathToFile);
    }
}
