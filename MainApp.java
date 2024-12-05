package com.quadtree;

import java.io.*;
import java.util.*;

public class MainApp {
    public static void main(String[] args) {
        // Check if a file path is provided as a command-line argument
        if (args.length != 1) {
            System.out.println("Usage: java MainApp <file-path>");
            return;
        }

        String filePath = args[0];

        // Initialize the quadtree
        Quadtree quadtree = new Quadtree();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            // Read the file line by line
            while ((line = br.readLine()) != null) {
                // Example format: "insert 10 10 5 5" or "delete 10 10"
                String[] parts = line.split(" ");
                String command = parts[0];

                switch (command.toLowerCase()) {
                    case "insert":
                        if (parts.length == 5) {
                            int x = Integer.parseInt(parts[1]);
                            int y = Integer.parseInt(parts[2]);
                            int width = Integer.parseInt(parts[3]);
                            int height = Integer.parseInt(parts[4]);
                            quadtree.insert(new Rectangle(x, y, width, height));
                        } else {
                            System.out.println("Invalid insert command format. Expected: insert x y width height");
                        }
                        break;

                    case "delete":
                        if (parts.length == 3) {
                            int x = Integer.parseInt(parts[1]);
                            int y = Integer.parseInt(parts[2]);
                            quadtree.delete(x, y);
                        } else {
                            System.out.println("Invalid delete command format. Expected: delete x y");
                        }
                        break;

                    case "find":
                        if (parts.length == 3) {
                            int x = Integer.parseInt(parts[1]);
                            int y = Integer.parseInt(parts[2]);
                            System.out.println("Found: " + quadtree.find(x, y));
                        } else {
                            System.out.println("Invalid find command format. Expected: find x y");
                        }
                        break;

                    default:
                        System.out.println("Unknown command: " + command);
                }
            }

            // Dump the tree structure at the end
            quadtree.dump();

        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found - " + filePath);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid number format in input file.");
        }
    }
}
