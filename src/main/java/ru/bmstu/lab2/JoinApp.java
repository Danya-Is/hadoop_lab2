package ru.bmstu.lab2;


import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class JoinApp {
    public static void main(String[] args) throws Exception {
        Job job = Job.getInstance();
        job.setJarByClass(JoinApp.class);
        job.setJobName("Join App");
        FileInputFormat.addInputPath(job, new Path(args[0]));
        FileInputFormat.addInputPath(job, new Path(args[1]));
        FileOutputFormat.setOutputPath(job, new Path(args[2]));
    }
}
