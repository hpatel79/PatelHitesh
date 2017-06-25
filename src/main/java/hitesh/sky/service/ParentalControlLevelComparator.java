package hitesh.sky.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Hitesh on 25/06/2017.
 */
public class ParentalControlLevelComparator implements Comparator<String> {

    private List<String> levels;

    public ParentalControlLevelComparator(List<String> levels) {
        this.levels = new ArrayList<>(levels);
    }

    @Override
    public int compare(String level1, String level2) {
        return levels.indexOf(level1) - levels.indexOf(level2);
    }
}
