package ru.bmstu.lab2;

import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class AirportWritableComparable implements WritableComparable {
    private int indicator, airportID;

    @Override
    public int compareTo(Object o) {
        if (airportID != ((AirportWritableComparable) o).airportID)
            return Integer.compare(airportID, ((AirportWritableComparable)o).airportID);
        return Integer.compare(indicator, ((AirportWritableComparable)o).indicator);
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.write();
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {

    }
}
