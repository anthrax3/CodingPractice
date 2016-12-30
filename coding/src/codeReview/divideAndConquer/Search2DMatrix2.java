package codeReview.divideAndConquer;

/**
 * Created by wangdong on 5/22/16.
 */
public class Search2DMatrix2 {
    //O(n + m)
    public boolean searchMatrix1(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0) {
            return false;
        }

        for(int i = 0; i < matrix.length; i++) {
            for(int ele : matrix[i]) {
                if(ele == target) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean binarySearch(int[] row, int start, int end, int target) {
        if(row == null || row.length == 0 || start > end ) {
            return false;
        }

        int middleIdx = start + (end - start)/2;

        if(row[middleIdx] == target) {
            return true;
        } else if (row[middleIdx] < target) {
            return binarySearch(row, middleIdx + 1, end, target);
        } else {
            return binarySearch(row, start, middleIdx - 1, target);
        }

    }

    //O(m * longn)
    public boolean searchMatrix2(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0) {
            return false;
        }

        for(int[] row : matrix) {
            if(binarySearch(row, 0, row.length - 1, target)) {
                return true;
            }
        }

        return false;
    }

    //divide and conquer T(n) = 3*T(n/2) + O(m)
    public static boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0) {
            return false;
        }

        return searchInMatrix(matrix, 0, matrix.length - 1, 0, matrix[0].length - 1, target);


    }

    private static boolean searchInMatrix(int[][] matrix, int xStart, int xEnd, int yStart, int yEnd, int target) {
        if(xStart > xEnd || yStart > yEnd) {
            return false;
        }

        int midX = xStart + (xEnd - xStart)/2;
        int midY = yStart + (yEnd - yStart)/2;

        if(matrix[midX][midY] == target) {
            return true;
        } else if (matrix[midX][midY] > target) {
            //2 section, 1, 3
            return searchInMatrix(matrix, xStart, midX-1, yStart, midY, target) ||
                    searchInMatrix(matrix, midX, xEnd, yStart, midY - 1, target) ||
                    searchInMatrix(matrix, xStart, midX-1, midY, yEnd, target);
        } else {
            return searchInMatrix(matrix, midX+1, xEnd, yStart, midY - 1, target) ||
                    searchInMatrix(matrix, midX + 1, xEnd, midY, yEnd, target) ||
                    searchInMatrix(matrix, xStart, midX, midY + 1, yEnd, target);
        }
    }
}
