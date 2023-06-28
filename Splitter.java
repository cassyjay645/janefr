//package sleepchild.jsplitter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.FileOutputStream;

public class Splitter{
    
    public static void main(String[] args){
        new Splitter().split100mb(args[0]);
    }
    
    public void split100mb(String filepath){
        
        if(filepath==null || filepath.isEmpty()){
            return;
        }
         
        File f = new File(filepath);
        if(f.exists()==false){
            return;
        }
        
        String n = f.getName().replace(".","_");
        n = n.replace("%","_");
        String depo = ./out/"; // f.getParent()+"/"+n+"_dep/";
        //depo = newParent(depo);
        new File(depo).mkdirs();
        long size = f.length();
        //long mb1 = 1000000;
        long mb1 = 1024*1024*100;// 100mb
        int br = 0;
        int dw=0;
        
        FileOutputStream o = newStrieam(depo);
        int red =0;
        byte[] buffer = new byte[1024*5];// 5mb buffer
        
        try{
            BufferedInputStream ins = new BufferedInputStream(new FileInputStream(f));
            while( (red = ins.read(buffer)) != -1){
                br += red;
                dw += red;
                //*
                if(br>=mb1){
                    br=0;
                    if(o!=null){
                        o.flush();
                        o.close();
                    }
                    o = newStrieam(depo);
                }
                //*/
                o.write(buffer,0, red);
            }
            o.flush();
            o.close();
            ins.close();
        }
        catch (FileNotFoundException e){}
        catch(IOException ioe){}

    }
    
    String newParent(String path){
        File f = new File(path);
        int c=0;
        while(f.exists()){
           f = new File(path+c);
           c++;
        }
        return f.getAbsolutePath();
    }
    
    FileOutputStream newStrieam(String parent){
        int c=0;
        String p = parent+"/p"+c+"/";
        File f = new File(p);
        while(f.exists()){
            c = c+1;
            p = parent+"/p"+c+"/";
            f = new File(p);
        }
        try{
            return new FileOutputStream(f);
        }
        catch (FileNotFoundException e){}
        return null;
    }
    
    public void join(String path){
        //
    }
    
}
