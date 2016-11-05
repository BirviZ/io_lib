package org.birviz.io;

/**
 * Simple In-Out library for exercises
 * @author birviz
 * @version 1.0
 *
 */

public class IO {

    /**
     * Example variable int a.
     * <br>
     * a = 2
     */
    public static int a = 2;

    /**
     * Example variable int b.
     * <br>
     * b = 3
     */
    public static int b = 3;

    /**
     * Example const String HW.
     * <br>
     * HW = "Hello, world!"
     */
    public final static String HW = "Hello, World!";

    private final String name;
    private InOut io;

    /**
     * Write on console
     * @param content data to out
     */
    public static void write(Object content) {
        System.out.print(content);
    }

    /**
     * Write on console with line break
     * @param content data to out
     */
    public static void writeln(Object content) {
        write(content);
        write(System.lineSeparator());
    }

    /**
     * Create In-Out object
     * @param file true - file, false - console
     * @param name file name (in console variant - console name)
     */
    public IO(boolean file, String name) {
        this.name = name;

        if (file) {
            io = new File(name);
        } else {
            io = new Console(name);
        }
    }

    /**
     * Get object name(file name in file variant or console name in console)
     * @return object name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Send date to file or console
     * @param data data to send
     */
    public void send(String data) {
        String current;

        if (data.contains("\n")) {
            current = "\n";
        } else if (data.contains("\r")) {
            current = "\r";
        } else current = "\r\n";

        io.sendData(data.replaceAll(current, System.lineSeparator()));
    }

    /**
     * Get gata from file or keyboard
     * @return string from file or keyboard
     */
    public String get() {
        return io.getData();
    }
}
