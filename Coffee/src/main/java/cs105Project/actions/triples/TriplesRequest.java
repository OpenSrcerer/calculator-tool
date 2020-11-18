package cs105Project.actions.triples;

import cs105Project.actions.Request;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static cs105Project.actions.Functions.multiplyListBy;

public class TriplesRequest implements Request {

    private static final ArrayList<List<Integer>> primitiveRatios = new ArrayList<>();
    private static final ArrayList<List<Integer>> scaledRatios = new ArrayList<>();

    @Override
    public void run() {
        primitiveRatios.clear();
        scaledRatios.clear();

        int a, b, c;
        int m = 2;

        while (m < 100) {
            int n = 1;
            while (n < m) {

                a = (m * m) - (n * n);
                b = 2 * m * n;
                c = (m * m) + (n * n);

                if (c >= 100)
                    break;

                if ((a * a) + (b * b) == (c * c)) {
                    List<Integer> ratio = Arrays.asList(a, b, c);
                    ratio.sort(Comparator.naturalOrder());

                    if (!isRatioScaled(ratio)) {
                        primitiveRatios.add(ratio);
                    }
                }
                ++n;
            }
            ++m;
        }

        for (List<Integer> ratio : primitiveRatios) {
            int index = 2;
            while (ratio.get(2) * index <= 100) {
                scaledRatios.add(multiplyListBy(ratio, index));
                ++index;
            }
        }

        System.out.println("------ Primitive Ratios -------");
        for (List<Integer> ratio : primitiveRatios) {
            System.out.println(ratio);
        }

        System.out.println("------ Scaled Ratios -------");
        for (List<Integer> ratio : scaledRatios) {
            System.out.println("[" + ratio + "]");
        }
    }

    private static boolean isRatioScaled(List<Integer> ratio) {
        for (List<Integer> primitiveRatio : primitiveRatios) {
            double div1 = (double) ratio.get(0) / primitiveRatio.get(0);
            double div2 = (double) ratio.get(1) / primitiveRatio.get(1);
            double div3 = (double) ratio.get(2) / primitiveRatio.get(2);

            double diva = (div1 + div2 + div3) / 3;

            if (diva == div1) {
                return true;
            }
        }
        return false;
    }
}
