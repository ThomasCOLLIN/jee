package com.mti.mtispring.businessManagament;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {

    public static File getZip(List<String> filePaths) {
        try {
            File file = new File("c:/tmp.zip");
            FileOutputStream fileStream = new FileOutputStream(file);
            ZipOutputStream out = new ZipOutputStream(fileStream);
            for (String path : filePaths) {
                byte[] b = fileToByte(path);
                
                Pattern p;
                String reg = "[^/].*zip$";
                p = Pattern.compile(reg);
                Matcher m = p.matcher(path);
                ZipEntry e = new ZipEntry(m.group(1));
                out.putNextEntry(e);
                out.write(b);
                out.closeEntry();
            }
            out.close();
            fileStream.close();
            return file;
            
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found.");
            System.out.println(e.getMessage());
            return null;
        }
        catch (IOException e1) {
            System.out.println("Error Writing The Stream.");
            System.out.println(e1.getMessage());
            return null;
        }
        catch (Exception e2) {
            System.out.println(e2.getMessage());
            return null;
        }
    }
    
    public static File getZip(String path)
    {
        try {
            File file = new File(path);
            
            return file;
            
        } catch (NullPointerException e) {
            System.out.println("The path is null.");
            System.out.println(e.getMessage());
            return null;
        }
        catch (Exception e2) {
            System.out.println(e2.getMessage());
            return null;
        }
    }

    private static byte[] fileToByte(String path) {
        File file = new File(path);

        byte[] b = new byte[(int) file.length()];
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            fileInputStream.read(b);

            return b;
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found.");
            System.out.println(e.getMessage());
            return null;
        } catch (IOException e1) {
            System.out.println("Error Reading The File.");
            System.out.println(e1.getMessage());
            return null;
        }
    }
}