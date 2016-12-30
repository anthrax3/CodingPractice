package codeReview;

import codeReview.Design.MedianFinder;

public class Main {

    public static void main(String[] args) {
	// write your code here
        //System.out.printf("hello");


/*
        //List<Integer> test1 = Arrays.asList(3, 2, 7, 9);
        //MergeSorter.sort(test1).stream().forEach(element -> System.out.println(element));
        int[][] a = {{5,8},{3,5},{1,9},{4,5},{0,2},{1,9},{7,8},{4,9}};
        //CourseSchedule2.findOrder(10, a);

        int[][] b = {{0,1}, {1,0}};
        //CourseSchedule.canFinish(2, b);

        int r = Calculator2.calculate("1*2+4*4  ");
        //System.out.println(String.format("%d", r));

        //Shortestpalindrome.shortestPalindrome("ab");

        //CompareVersionNum.compareVersion("1", "0");

        //ReverseWordsinAString.reverseWords(" 1");

        //System.out.println(PatternSearch1.searchPattern("0", "uu") == true ? "found" : "not found");

        Set<String> words = new HashSet<>(Arrays.asList("a","c"));
        //List<List<String>> rel = WordLadder2.findLadders("a", "c", words);

        //rel.size();
        int[] arryA = {1, 2, 5};
        int[] arryB = {4, 6};
        //double res = MedianOfTwoSortedArrays.findMedianSortedArrays(arryA, arryB);
        //System.out.printf(String.format("%d", res));

        //MinArrayPatch.minPatches(arryA, 7);

        int[][] buildings =  {{2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8} };
        int[][] buildings3 = {{2,13,10},{10,17,25},{12,20,14}};
        int[][] buildings2 ={{0,2,3},{2,5,3}};
        //TheSkylineProblem.getSkyline(buildings3);

        int[][] m = {{1,1}};
        //Search2DMatrix2.searchMatrix(m, 2);

        //ExpressionAddOperators.addOperators("123456789", 45);

        //BurstBalloons.maxCoins(new int[] {3,1,5,8});
        //CountOfSmallerNumbersAfterSelf.countSmaller(new int[] {5, 2, 6, 1});


        //CountOfSmallerNumbersAfterSelf.countSmaller(new int[] {5, 2, 6, 1});
        //CountOfRangeSum countOfRangeSum = new CountOfRangeSum();
        //countOfRangeSum.countRangeSum(new int[] {-2, 5, -1}, -2, 2);
        //SkyLine skyLine = new SkyLine();
        //skyLine.getSkyline(buildings);
        RangeSumQuery numArray = new RangeSumQuery(new int[] {7,2,7,2,0});
        numArray.update(4, 6);
        numArray.update(0, 2);
        numArray.update(0, 9);
        numArray.update(3, 8);
        numArray.sumRange(0, 4);

        HIndexTwo hIndexTwo = new HIndexTwo();
        hIndexTwo.hIndex(new int[] {1,2,2,6,7,8});
        LongestIncreasingSubsequence lSI = new LongestIncreasingSubsequence();
        int[] seq = {10, 9, 2, 5, 3, 7, 101, 18};
        //lSI.lengthOfLIS(seq);
      MaxSumOfRectangleNoLargerThanK maxRectangle = new MaxSumOfRectangleNoLargerThanK();
      int[][] matrix = {{2, 2, -1}};
      maxRectangle.maxSumSubmatrix(matrix, 0);

      NumberOfIslands numberOfIslands = new NumberOfIslands();
      char[][] islands = {{1,1,1,1,0}, {1,1,0,1,0}, {1,1,0,0,0},{0,0,0,0,0}};
      numberOfIslands.numIslands(islands);
      String[] lands = {"OXXOX","XOOXO","XOXOX","OXOOO","XXOXO"};
      char[][] clands = new char[lands.length][];
      int i = 0;
      for(String land : lands) {
        clands[i++] = land.toCharArray();
      }
      SurroundedRegions surroundedRegions = new SurroundedRegions();
      surroundedRegions.solve(clands);

      GameOfLife gm = new GameOfLife();
      gm.gameOfLife(new int[][] {{1,1}, {1,0}});
      */
      MedianFinder mf = new MedianFinder();
      mf.addNum(2);
      mf.addNum(3);
      mf.findMedian();


    }


}
