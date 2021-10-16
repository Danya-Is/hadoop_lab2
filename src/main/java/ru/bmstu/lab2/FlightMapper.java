package ru.bmstu.lab2;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class FlightMapper extends Mapper<LongWritable, Text, AirportWritableComparable, Text> {
    public static final String DELIMETER = ",";
    public static int AIRPORT_ID_POS = 14;
    public static int AIRPORT_DELAY_POS = 18;
    public static int INDICATOR = 1;

    @Override
    protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, AirportWritableComparable, Text>.Context context) throws IOException, InterruptedException {
        String[] airportFeatures = value.toString().split(DELIMETER);
        if (key.get() > 0) {
            int airportID = Integer.parseInt(airportFeatures[AIRPORT_ID_POS]);
            String airportDelay = airportFeatures[AIRPORT_DELAY_POS];
            if (!airportDelay.isEmpty() && Float.parseFloat(airportDelay) > 0f)
                context.write(new AirportWritableComparable(airportID, INDICATOR), new Text(airportDelay));
        }
    }
}
