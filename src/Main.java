import java.io.*;

/**
 * Author: Juzi
 * Time: 2018/7/14 19:17
 * Blog: http://juzibiji.top
 */
public class Main {

    public static void main(String[] args) throws IOException {
        //BeyondCompare路径
        String filePath = "C:\\Users\\Juzi\\AppData\\Roaming\\BCompare\\BCompare.ini";
        //创建文件对象
        File BCFile = new File(filePath);
        //创建FileReader对象
        FileReader frBCFile = new FileReader(BCFile);
        //创建Buffered对象
        BufferedReader br = new BufferedReader(frBCFile);

        //读取文件内容
        String line = null;
        StringBuilder sb = new StringBuilder();
        while ((line = br.readLine()) != null) {
            if (line.indexOf("InstallTime") != -1) {
                //获取当前时间戳，因为获取到的是13位，而文件内是10位，故分割一下字符串
                String time =String.valueOf(System.currentTimeMillis()).substring(0,9);
                sb.append("InstallTime="+time+"\r\n");
            }else {
                sb.append(line+"\r\n");
            }
        }

        //写入文件
        BufferedWriter bw = new BufferedWriter(new FileWriter(BCFile));
        bw.write(sb.toString());
        System.out.println(sb.toString());
        bw.flush();

        //关闭流
        frBCFile.close();
    }
}
