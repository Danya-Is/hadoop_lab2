package ru.bmstu.lab2;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class GroupingComparator extends WritableComparator {
    
    @Override
    public int compare(AirportWritableComparable a, AirportWritableComparable b) {
        return super.compare(a, b);
    }
}
