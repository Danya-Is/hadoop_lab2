package ru.bmstu.lab2;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class AirportMapper extends Mapper<LongWritable, Text, AirportWritableComparable, Text> {

    public static final String DELIMETR = "\",\"";
    public static int AIRPORT_ID_POS = 0;
    public static int AIRPORT_NAME_POS = 1;
    public static int INDICATOR = 0;

    @Override
    protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, AirportWritableComparable, Text>.Context context) throws IOException, InterruptedException {
        String[] airportFeatures = value.toString().split(DELIMETR);
        if (key.get() > 0) {
            int airportID = Integer.parseInt(airportFeatures[AIRPORT_ID_POS].replaceAll("\"", ""));
            String airportName = airportFeatures[AIRPORT_NAME_POS].replaceAll("\"", "");
            context.write(new AirportWritableComparable(airportID, INDICATOR), new Text(airportName));
        }
    }
}
