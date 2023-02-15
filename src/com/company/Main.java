package com.company;
import java.io.*;
import java.util.LinkedList;
import java.util.List;

import static java.lang.Math.sqrt;

        public class Main {

            public static int[][] matrix;

            public static int[][] Read_str(String str) {
                String str_help = str;
                List list = new LinkedList<>();
                String line = "";
                int iterator = 0;

                for (int i = 0; i < str_help.length(); i++) {
                    if ((str_help.charAt(i) >= 48 && str_help.charAt(i) <= 57)) {
                        line += String.valueOf(str_help.charAt(i));
                    } else if (str_help.charAt(i) == 32) {
                        int b = Integer.parseInt(line);
                        list.add(iterator, b);
                        iterator++;
                        line = "";
                    }
                }
                //System.out.println(list);
                iterator = 0;
                int x = (int) sqrt(list.size());
                //System.out.println("x = "+x);
                int[][] matrix = new int[x][x];

                for (int i = 0; i < x; i++) {
                    for (int j = 0; j < x; j++) {
                        matrix[i][j] = (int) list.get(iterator);
                        iterator++;
                    }
                }

                return matrix;

            }

            public static void Read_matrix(int[][] matrix) {
                for (int i = 0; i < matrix.length; i++) {
                    for (int j = 0; j < matrix[0].length; j++) {
                        System.out.print(matrix[i][j] + " ");
                    }
                    System.out.println();
                }
            }


            public static int[][] Work_matrix(int[][] matrix) {
                int[][] help_matrix = matrix;
                for (int i = 1; i < help_matrix.length; i++) {
                    for (int j = 0; j < i; j++) {

                        help_matrix[i][j] = 0;
                    }
                }
                return help_matrix;
            }


            public static void main(String[] args) {
                BufferedReader br = null;   // объект класса
                try {   //исключение
                    File file = new File("newFile.txt");
                    if (file.exists())       // условие для проверки: если файл не сущ, то создаем файл.
                        file.createNewFile();

                    PrintWriter writer = new PrintWriter(file);
                    writer.println("1 8 3 7 \n" +
                            "4 1 4 9 \n" +
                            "9 2 7 2 \n" +
                            "3 4 8 9 ");
                    writer.close();


                    br = new BufferedReader(new FileReader("newFile.txt"));
                    String str1, str2 = "";
                    while ((str1 = br.readLine()) != null) {
                        System.out.println(str1);
                        str2 += str1;
                    }
                    System.out.println("-----------");
                    Read_matrix(Read_str(str2));
                    System.out.println("-----------");
                    Read_matrix(Work_matrix(Read_str(str2)));

                    FileWriter writer1 = new FileWriter(file, true);


                    writer1.write("Верхнедиагональная матрица:\n");
                    for (int i = 0; i < Work_matrix(Read_str(str2)).length; i++) {
                        for (int j = 0; j < Work_matrix(Read_str(str2))[0].length; j++) {
                            writer1.write(Work_matrix(Read_str(str2))[i][j] + " ");
                        }
                        writer1.write("\n");
                    }
                    writer1.close();

                } catch (IOException e) { // если не удастся создать файл, то будет выдаваться исключчение
                    System.out.println("Error: " + e);
                } finally { // блок для br
                    try {
                        br.close();
                    } catch (IOException e) {
                        System.out.println("Error: " + e);
                    }
                }
            }

        }
