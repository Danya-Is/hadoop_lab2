package ru.bmstu.lab2;


import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;

public class JoinApp {
    public static void main(String[] args) throws Exception {
        Job job = Job.getInstance();
        job.setJarByClass(JoinApp.class);
        job.setJobName("Join App");
        FileInputFormat.addInputPath(job, new Path());
    }
}
