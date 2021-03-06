package ru.bmstu.lab2;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class AirportMapper extends Mapper<LongWritable, Text, AirportWritableComparable, Text> {

    public static final String DELIMITER = "\",\"";
    public static int AIRPORT_ID_POS = 0;
    public static int AIRPORT_NAME_POS = 1;
    public static int INDICATOR = 0;

    public String removeQuote(String s) {
        return s.replaceAll("\"", "");
    }

    @Override
    protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, AirportWritableComparable, Text>.Context context) throws IOException, InterruptedException {
        String[] airportFeatures = value.toString().split(DELIMITER);
        if (key.get() > 0) {
            int airportID = Integer.parseInt(removeQuote(airportFeatures[AIRPORT_ID_POS]));
            String airportName = removeQuote(airportFeatures[AIRPORT_NAME_POS]);
            context.write(new AirportWritableComparable(airportID, INDICATOR), new Text(airportName));
        }
    }
}
