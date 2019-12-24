package utils.commands;

import lombok.Getter;


public class UploadCommand implements Command {
    @Getter
    private String filePath;

    @Override
    public void operate(String[] input) {
        if (input.length != 1) throw new IllegalArgumentException("invalid path to file on upload command");
        filePath = input[0];
    }
}
