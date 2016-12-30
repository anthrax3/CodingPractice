package codeReview;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangdong on 4/7/16.
 */
public class MergeSorter {
    public static List<Integer> sort(List<Integer> records) {
        if(records == null || records.size() < 2) {
            return new ArrayList<>(records);
        }

        int size = records.size();
        List<Integer> sortedLeftSide = sort(records.subList(0, size/2));
        List<Integer> sortedRightSide = sort(records.subList(size/2 + 1, size));

        List<Integer> sortedFullSize = new ArrayList<>(size);
        while(sortedLeftSide.size() > 0 || sortedRightSide.size() > 0) {
            if(sortedLeftSide.get(0) < sortedRightSide.get(0)) {
                sortedFullSize.add(sortedLeftSide.remove(0));
            } else {
                sortedFullSize.add(sortedRightSide.remove(0));
            }
        }

        return sortedFullSize;
    }
}
