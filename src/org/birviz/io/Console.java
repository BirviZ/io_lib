package org.birviz.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Console implements InOut {

    private String name;

    Console(String name) {
        this.name = name;
    }

    @Override
    public String getData() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        try {
            str = br.readLine();
        } catch (IOException e) {
            IO.writeln(e.toString());
        }
        return str;
    }

    @Override
    public void sendData(String data) {
        String out = "Console:" + " " + name + "\n" + data;
        IO.writeln(out);
    }
}
