package com.fastaccount.util;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by xus on 2017/3/21.
 */

public class CharReplaceProcessUtil {
    public static CharReplaceProcessUtil INSTANCE = new CharReplaceProcessUtil();
    private Map<String, String> map = new HashMap<String, String>();
    public Map<String, String> getReplaceChar()
    {
        map.put("，", ",");
        map.put("。", ".");
        map.put("〈", "<");
        map.put("〉", ">");
        map.put("‖", "|");
        map.put("《", "<");
        map.put("》", ">");
        map.put("〔", "[");
        map.put("〕", "]");
        map.put("﹖", "?");
        map.put("？", "?");
        map.put("“", "\"");
        map.put("”", "\"");
        map.put("：", ":");
        map.put("、", ",");
        map.put("（", "(");
        map.put("）", ")");
        map.put("【", "[");
        map.put("】", "]");
        map.put("—", "-");
        map.put("～", "~");
        map.put("！", "!");
        map.put("‵", "'");
        map.put("①", "1");
        map.put("②", "2");
        map.put("③", "3");
        map.put("④", "4");
        map.put("⑤", "5");
        map.put("⑥", "6");
        map.put("⑦", "7");
        map.put("⑧", "8");
        map.put("⑨", "9");
        return map;
    }
    public  void replaceProcess(String srcFilePath, String descFilePath)
    {
        BufferedReader br  = null;
        BufferedWriter bw = null;
        try
        {
            File srcFile = new File(srcFilePath);
            File descFile = new File(descFilePath);
            br = new BufferedReader(new FileReader(srcFile));
            bw = new BufferedWriter(new FileWriter(descFile));

            String line = null;
            while((line = br.readLine()) != null)
            {
                String replaceLine = this.replace(line);
                bw.write(replaceLine);
                bw.newLine();
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally{
            try
            {
                bw.close();
                br.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }

    }
    public String replace(String line)
    {
        Map<String, String> map = new HashMap<String, String>();
        int length = line.length();
        for (int i = 0; i < length; i++)
        {
            String charat = line.substring(i, i + 1);
            if (map.get(charat) != null)
            {
                line = line.replace(charat, (String) map.get(charat));
            }
        }
        return line;
    }
}
