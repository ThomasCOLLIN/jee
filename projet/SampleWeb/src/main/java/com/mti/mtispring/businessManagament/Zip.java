package com.mti.mtispring.businessManagament;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {

    public static ByteArrayOutputStream getZip(Map<String, String> filePaths) throws Exception {
        try {
            ByteArrayOutputStream fOut = new ByteArrayOutputStream();
            ZipOutputStream zOut = new ZipOutputStream(fOut);
            byte[] buffer = new byte[1024];

            for (Map.Entry<String, String> entry : filePaths.entrySet()) {
                String fileName = entry.getKey();
                String path = entry.getValue();

                InputStream fIn;
                /* If this is an URL */
                if (path.startsWith("http://")) {
                    fIn = new BufferedInputStream(new URL(path).openStream());
                } else {
                    File file = new File(path);
                    fIn = new FileInputStream(file);
                }
                /* Create a new entry with a name for the file. */
                zOut.putNextEntry(new ZipEntry(fileName + ".zip"));
                int length;
                while ((length = fIn.read(buffer)) > 0) {
                    zOut.write(buffer, 0, length);
                }

                zOut.closeEntry();
                fIn.close();

            }
            zOut.close();
            fOut.close();

            return fOut;

        } catch (FileNotFoundException e) {
            System.out.println("File Not Found.");
            System.out.println(e.getMessage());
            return null;
        } catch (IOException e1) {
            System.out.println("Error Writing The Stream.");
            System.out.println(e1.getMessage());
            return null;
        } catch (Exception e2) {
            System.out.println(e2.getMessage());
            return null;
        }
    }

    public static File getZip(String path) {
        try {
            File file = new File(path);

            return file;

        } catch (NullPointerException e) {
            System.out.println("The path is null.");
            System.out.println(e.getMessage());
            return null;
        } catch (Exception e2) {
            System.out.println(e2.getMessage());
            return null;
        }
    }
}