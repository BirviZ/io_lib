package org.birviz.io;


import java.io.*;

class File implements InOut {

    private java.io.File file;


    File(String name) {
        file = new java.io.File(name);
    }

    @Override
    public String getData() {
        String result = "";

        FileReader fr = null;
        try {
            fr = new FileReader(file);
        } catch (FileNotFoundException e) {
            IO.writeln("File not found");
        }
        assert fr != null;
        BufferedReader br = new BufferedReader(fr);

        String temp;

        try {
            while ((temp = br.readLine()) != null) {
                result += temp + "\n";
            }
            br.close();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        IO.writeln("File: " + file.getName() + " read success!");

        return result;
    }

    @Override
    public void sendData(String data) {
        FileWriter fw = null;
        try {
            fw = new FileWriter(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            assert fw != null;
            fw.append(data);
            fw.flush();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        IO.writeln("File: " + file.getName() + " write success!");
    }
}
