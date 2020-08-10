package com.dmlab;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import com.dmlab.bst.BookSearch;
import com.dmlab.bst.TreePrinter;

public class Main {
    private static final int ADD = 0;
    private static final int REMOVE = 1;
    private static final int GET = 2;
    private static final int SIZE = 3;
    private static final int PRINT_ALL = 4;
    private static final int ORDER_SEARCH = 5;
    private static final int PRINT_TREE = 6;
    private static final int ERROR = 7;

    public static void main(String[] args) throws Exception {
        BookSearch bookSearch = new BookSearch();
        TreePrinter<String, String> tp = new TreePrinter<String, String>();

        FileInputStream fis = new FileInputStream("sample_input.txt");
        BufferedReader reader = new BufferedReader(new InputStreamReader(fis));

        for (String line = reader.readLine(); line != null; line = reader.readLine()) {
            String[] line_split = line.split(" ");
            String cmd = line_split[0];
            String name = null;
            String position = null;
            String query = null;

            switch (getCommandNum(cmd)) {
                case ADD:
                    name = line_split[1];
                    position = line_split[2];
                    bookSearch.add(name, position);
                    System.out.println("ADD:\t" + name + " " + position);
                    break;
                case REMOVE:
                    name = line_split[1];
                    position = bookSearch.remove(name);
                    if (name == null || position == null)
                        System.out.println("BookSearch cannot find the book");
                    else {
                        System.out.println("REMOVE:\t" + name + " " + position);
                    }
                    break;
                case GET:
                    name = line_split[1];
                    position = bookSearch.get(name);
                    if (position == null)
                        System.out.println("BookSearch cannot find the book");
                    else
                        System.out.println("GET:\t" + name + " " + position);
                    break;
                case SIZE:
                    System.out.println("SIZE:\t" + bookSearch.size());
                    break;
                case PRINT_ALL:
                    bookSearch.printBookList();
                    break;
                case ORDER_SEARCH:
                    query = line_split[1];
                    if (isNumeric(query)) {
                        int order = Integer.parseInt(query);
                        String result = bookSearch.orderSearch(order);
                        if (result == null)
                            System.out.println("BookSearch cannot find the book");
                        else
                            System.out.println("ORDER:\t" + result);
                    } else {
                        int order = bookSearch.orderSearch(query);
                        if (order == 0)
                            System.out.println("BookSearch cannot find the book");
                        else
                            System.out.println("ORDER:\t" + order);
                    }
                    break;
                case PRINT_TREE:
                    System.out.println("PRINT_TREE:\t");
                    tp.printNode(bookSearch.getRoot());
                    break;
                case ERROR:
                    break;
            }
        }
    }

    private static int getCommandNum(String cmd) {
        if (cmd.equals("add"))
            return ADD;
        else if (cmd.equals("remove"))
            return REMOVE;
        else if (cmd.equals("get"))
            return GET;
        else if (cmd.equals("size"))
            return SIZE;
        else if (cmd.equals("print_all"))
            return PRINT_ALL;
        else if (cmd.equals("order_search"))
            return ORDER_SEARCH;
        else if (cmd.equals("print_tree"))
            return PRINT_TREE;
        return ERROR;
    }

    private static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
