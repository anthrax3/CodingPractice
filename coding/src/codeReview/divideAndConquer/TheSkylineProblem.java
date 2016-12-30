package codeReview.divideAndConquer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by wangdong on 5/18/16.
 */
public class TheSkylineProblem {
    public static List<int[]> getSkyline(int[][] buildings) {
        if(buildings == null || buildings.length == 0) {
            return getOneSkyLine(new ArrayList<>());
        }

        List<int[]> buildingList = new ArrayList<>();
        for(int[] building : buildings) {
            buildingList.add(building);
        }

        return getOneSkyLine(buildingList);
    }

    private static void insertToSkyline(List<int[]> skyLine, int[] strip) {
        if(skyLine.isEmpty()) {
            skyLine.add(strip);
        }

        int currentLeft = skyLine.get(skyLine.size() - 1)[0];
        int currentHeight = skyLine.get(skyLine.size() - 1)[1];


        if(currentLeft != strip[0] && currentHeight != strip[1]) {
            skyLine.add(strip);
        } else if(currentLeft == strip[0]) {
                skyLine.remove(skyLine.size() - 1);
                skyLine.add(new int[]{currentLeft, Math.max(currentHeight, strip[1])});
                return;
        } else if(strip[1] == currentHeight && currentHeight == 0) {
                //update end
                skyLine.remove(skyLine.size() - 1);
                skyLine.add(strip);
                return;
        }
    }

    public static List<int[]> getOneSkyLine(List<int[]> buildings) {
        List<int[]> strips = new ArrayList<>();

        if(buildings.isEmpty()) {
            return strips;
        }
        if(buildings.size() == 1) {
            int[] building = buildings.get(0);
            int left = building[0];
            int right = building[1];
            int height = building[2];


            strips.add(new int[]{left, height});
            strips.add(new int[] {right, 0});

            return strips;
        }

        int buildingNum = buildings.size();
        List<int[]> firstHalfBuildings = buildings.subList(0, buildingNum/2);
        List<int[]> secondHalfBuildings = buildings.subList(buildingNum/2, buildingNum);

        List<int[]> firstSkyLine = getOneSkyLine(firstHalfBuildings);
        List<int[]> secondSkyLine = getOneSkyLine(secondHalfBuildings);


        while (!firstSkyLine.isEmpty() && !secondSkyLine.isEmpty()) {
            // find the first sky line
            int[] fistPart = firstSkyLine.get(0);
            int[] secondPart = secondSkyLine.get(0);

            if(fistPart[0] < secondPart[0]) {
                insertToSkyline(strips, fistPart);
                firstSkyLine.remove(0);
            } else {
                insertToSkyline(strips, secondPart);
                secondSkyLine.remove(0);
            }
        }

        for (int[] part : firstSkyLine) {
            insertToSkyline(strips, part);
        }
        for(int[] part : secondSkyLine) {
            insertToSkyline(strips, part);
        }

        return strips;
    }
}
