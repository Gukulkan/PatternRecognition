import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class BruteCollinearPoints {

    private LineSegment[] segments;

    public BruteCollinearPoints(Point[] points) {
        checkPoint(points);

        List<LineSegment> foundedSegments = new ArrayList<LineSegment>();

        Point[] pointsCopy = Arrays.copyOf(points, points.length);
        Arrays.sort(pointsCopy);

        for (int i = 0; i < pointsCopy.length - 3; i++) {
            for (int j = i + 1; j < pointsCopy.length - 2; j++) {
                for (int k = j + 1; k < pointsCopy.length - 1; k++) {
                    for (int l = k + 1; l < pointsCopy.length; l++) {
                        if (pointsCopy[i].slopeTo(points[j]) == pointsCopy[i].slopeTo(pointsCopy[k]) &&
                                pointsCopy[i].slopeTo(points[j]) == pointsCopy[i].slopeTo(pointsCopy[l]))
                            foundedSegments.add(new LineSegment(pointsCopy[i], pointsCopy[l]));
                    }
                }
            }
        }

        segments = foundedSegments.toArray(new LineSegment[foundedSegments.size()]);
    }
    public int numberOfSegments() {
        return segments.length;
    }

    public LineSegment[] segments() {
        return Arrays.copyOf(segments, numberOfSegments());
    }


    private void checkPoint(Point[] points) {
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                if (points[i].compareTo(points[j]) == 0) throw new IllegalArgumentException();
            }
        }
    }

}