package ru.bmstu.lab2;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.Iterator;

public class AirportReducer extends Reducer<AirportWritableComparable, Text, Text, Text> {

    @Override
    protected void reduce(AirportWritableComparable key, Iterable<Text> values, Reducer<AirportWritableComparable, Text, Text, Text>.Context context) throws IOException, InterruptedException {
        Iterator<Text> airportIter = values.iterator();
        Text airportName = new Text(airportIter.next());
        int min = Integer.MAX_VALUE, max = 0;
        while (airportIter.hasNext()) {
            float delay = Float.parseFloat(airportIter.next().toString());
        }
    }
}
