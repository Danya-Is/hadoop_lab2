package ru.bmstu.lab2;

import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class AirportWritableComparable implements WritableComparable {
    private int indicator, airportID;

    @Override
    public int compareTo(Object o) {
        if (o == null || getClass() != o.getClass())
            return false;
        return 0;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {

    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {

    }
}
