package ru.bmstu.lab2;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class GroupingComparator extends WritableComparator {
    @Override
    public int compare(WritableComparable a, WritableComparable b) {
        return Integer.compare(((AirportWritableComparable) a).getAirportID(), ((AirportWritableComparable) b).getAirportID());
    }
}
