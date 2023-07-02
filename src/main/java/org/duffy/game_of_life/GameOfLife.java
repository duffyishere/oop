package org.duffy.game_of_life;

import java.util.List;

public class GameOfLife {
    private static final int ROW = 11;
    private static final int COL = 11;
    private static CellStatus[][] grid = new CellStatus[COL][ROW];
    private static CellStatus[][] future = new CellStatus[COL][ROW];
    private static int[] yDirections = {1, 1, 0, -1, -1, -1, 0, 1};
    private static int[] xDirections = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void start(List<Pair> starts) {
        initCells(starts);
        print(grid);

        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                nextGenerationCell(j, i);
            }
        }
        grid = future;
        print(grid);
    }

    private static void initCells(List<Pair> starts) {
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                grid[i][j] = CellStatus.DEAD;
            }
        }

        for (Pair start: starts) {
            grid[start.getY()][start.getX()] = CellStatus.LIVE;
        }
    }

    private static void nextGenerationCell(int x, int y) {
        Pair now = new Pair(x, y);
        CellStatus cell = getCell(now);
        int aliveNeighboursCount = getAliveNeighboursCount(now);
        if (cell.equals(CellStatus.LIVE)) {
            if (aliveNeighboursCount < 2 || 3 < aliveNeighboursCount) {
                setCellDead(now);
            }
        }
        else if (cell.equals(CellStatus.DEAD)) {
            if (aliveNeighboursCount == 3)  {
                setCellLive(now);
            }
        }
        else
            remainsSame(now);
    }

    private static CellStatus getCell(Pair pair) {
        return grid[pair.getY()][pair.getX()];
    }

    private static int getAliveNeighboursCount(Pair now) {
        int count = 0;
        for (int i = 0; i < 8; i++) {
            Pair next = now.getNewMovedPair(xDirections[i], yDirections[i]);
            if (next.isValid(COL, ROW)) {
                if (getCell(next).equals(CellStatus.LIVE))
                    count++;
            }
        }
        return count;
    }

    private static void setCellLive(Pair pair) {
        future[pair.getY()][pair.getX()] = CellStatus.LIVE;
    }
    private static void setCellDead(Pair pair) {
        future[pair.getY()][pair.getX()] = CellStatus.DEAD;
    }
    private static void remainsSame(Pair pair) {
        future[pair.getY()][pair.getX()] = grid[pair.getY()][pair.getX()];
    }

    private static void print(CellStatus[][] grid) {
        StringBuilder sb = new StringBuilder();
        sb.append("=========== NOW ==========\n");
        for (int i = 0; i < COL; i++) {
            for (int j = 0; j < ROW; j++) {
                if (grid[i][j] == CellStatus.LIVE)
                    sb.append(CellStatus.LIVE.getConsoleString() + " ");
                else
                    sb.append(CellStatus.DEAD.getConsoleString() + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
