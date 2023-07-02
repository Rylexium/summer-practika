package com.practice.app.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class SimplePty
{
    public SimplePty(Process process) throws IOException
    {
        while (process.isAlive())
        {
            sync(process.getErrorStream(), System.err);
            sync(process.getInputStream(), System.out);
            sync(System.in, process.getOutputStream());
        }
    }

    private void sync(InputStream in, OutputStream out) throws IOException
    {
        while (in.available() > 0)
        {
            out.write(in.read());
            out.flush();
        }
    }

    public static void main( String[] args ) throws IOException
    {
        String os = System.getProperty("os.name").toLowerCase();
        String shell = os.contains("Microsoft") ? "cmd" : "bash";
        Process process = new ProcessBuilder(shell).start();
        new SimplePty(process);
    }
}
