package com.PatternRecognition;

import java.util.ArrayList;
import java.util.List;

public class BruteCollinearPoints {

    private LineSegment[] segments;

    public BruteCollinearPoints(Point[] points){
        checkPoint(points);

        List<LineSegment> foundedSegments = new ArrayList<LineSegment>();

        for (int i = 0; i < points.length - 3 ; i++ ){
            for (int j = i + 1; j < points.length - 2; j ++){
                for (int k = j + 1; k < points.length - 1; k++ ){
                    for (int l = k + 1; l < points.length; l++){
                        if (points[i].slopeTo(points[j]) == points[i].slopeTo(points[k]) &&
                                points[i].slopeTo(points[j]) == points[i].slopeTo(points[l]))
                            foundedSegments.add(new LineSegment(points[i], points[l]));
                    }
                }
            }
        }

        segments = foundedSegments.toArray(new LineSegment[foundedSegments.size()]);
    }
    public int numberOfSegments(){
        return segments.length;
    }

    public LineSegment[] segments(){
        return segments;
    }


    private void checkPoint(Point[] points){
        for (int i = 0; i < points.length; i++){
            for (int j = i + 1; j < points.length; i++ ){
                if( points[i].compareTo(points[j]) == 0) throw new IllegalArgumentException();
            }
        }
    }

}