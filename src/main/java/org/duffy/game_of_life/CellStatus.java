package org.duffy.game_of_life;

public enum CellStatus {
    LIVE("1"),
    DEAD("0");

    private String consoleString;
    CellStatus(String consoleString) {
        this.consoleString = consoleString;
    }

    public String getConsoleString() {
        return this.consoleString;
    }
}
