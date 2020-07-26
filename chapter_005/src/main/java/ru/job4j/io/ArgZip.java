package ru.job4j.io;

/**
 * @author Alexander Chashkov
 * @version 0.0.0.1
 * @project junior
 * @since 26.07.2020
 */
public class ArgZip {
    private final String[] args;
    private boolean valid = false;
    private int idxDirectory = -1;
    private int idxExclude = -1;
    private int idxOutput = -1;

    public ArgZip(String[] args) {
        this.args = args;
        this.init();
    }

    private void init() {
        if (args != null && args.length > 0) {
            for(int i = 0; i < args.length; i++) {
                if (args[i].equals("-d")) {
                    idxDirectory = i + 1;
                }
                if (args[i].equals("-e")) {
                    idxExclude = i + 1;
                }
                if (args[i].equals("-o")) {
                    idxOutput = i + 1;
                }
            }
            valid = idxOutput > -1 && idxOutput < args.length && idxExclude > -1 && idxExclude < args.length && idxOutput > -1 && idxOutput < args.length;
        }
    }

    public boolean valid() {
        return valid;
    }

    public String directory() {
        return args[idxDirectory];
    }

    public String exclude() {
        return args[idxExclude].substring(2);
    }

    public String output() {
        return args[idxOutput];
    }

}
