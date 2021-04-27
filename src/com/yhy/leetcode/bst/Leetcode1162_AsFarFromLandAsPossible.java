package com.yhy.leetcode.bst;

import java.util.LinkedList;
import java.util.Queue;

public class Leetcode1162_AsFarFromLandAsPossible {


    public static void main(String[] args) {
        int[][] grid = new int[][]{{1, 0, 1}, {0, 0, 0}, {1, 0, 1}};
        int res = maxDistance(grid);
        System.out.println(res);
    }


    static int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};//上下左右

    public static int maxDistance(int[][] grid) {

        int n = grid.length;
        if (n == 1)
            return -1;

        int res = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    res = Math.max(res, bfs(i, j, grid));
                }
            }
        }
        return res;
    }

    private static int bfs(int x, int y, int[][] grid) {
        boolean[][] seen = new boolean[grid.length][grid.length];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y, 0});//第三个参数代表当前是海洋起点，初始化距离为0
        seen[x][y] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            for (int i = 0; i < 4; i++) {
                int dx = curr[0] + direction[i][0];
                int dy = curr[1] + direction[i][1];
                if (!(dx >= 0 && dx < grid.length && dy >= 0 && dy < grid.length)) {
                    continue;
                }
                if (!seen[dx][dy]) {
                    queue.offer(new int[]{dx, dy, curr[2] + 1});
                    seen[dx][dy] = true;
                    if (grid[dx][dy] == 1) {
                        return curr[2] + 1;
                    }
                }

            }
        }
        return -1;
    }
}
