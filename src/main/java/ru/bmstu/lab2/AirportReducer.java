package ru.bmstu.lab2;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.Iterator;

public class AirportReducer extends Reducer<AirportWritableComparable, Text, Text, Text> {

    @Override
    protected void reduce(AirportWritableComparable key, Iterable<Text> values, Reducer<AirportWritableComparable, Text, Text, Text>.Context context) throws IOException, InterruptedException {
        Iterator<Text> airportIter = values.iterator();
        if (airportIter.hasNext()) {
            Text airportName = new Text(airportIter.next());
            float minDelay = Integer.MAX_VALUE, maxDelay = 0, sum = 0;
            int count = 0;
            while (airportIter.hasNext()) {
                float delay = Float.parseFloat(airportIter.next().toString());
                sum += delay;
                count++;
                if (delay < minDelay)
                    minDelay = delay;
                if (delay > maxDelay)
                    maxDelay = delay;
            }
            float averageDelay = sum / count;
            if (count > 0)
                context.write(airportName, new Text("Average delay is " + averageDelay + " minutes\n" +
                        "Minimum delay is " + minDelay + " minutes\n" +
                        "Maximum delay is " + maxDelay + " minutes\n"));
        }

    }
}
