import java.io.File;
import java.util.ArrayList;
import java.lang.StringBuilder;
import java.io.*;

public class myGrep {
	public static void main(String[] args) {
        ArrayList<String> validFiles = new ArrayList<>();

        String filePathString = args[0];

         File folder = new File("C:/code/Qualia/stories/");
        File[] listOfFiles = folder.listFiles();

        GrepTool grepTool = new GrepTool();

        validFiles = grepTool.recursiveFileDive(listOfFiles, filePathString);
        if(!(validFiles.isEmpty())){
            for(String result : validFiles){
                System.out.println(result);
            }
        } else {
            System.out.println("No results found!");
        }


    }

}

class GrepTool {

    ArrayList<String> validFiles = new ArrayList<>();

    public ArrayList<String> recursiveFileDive(File [] listOfFiles, String input){
        for (File file : listOfFiles) {
                if(file.isDirectory()){
                    recursiveFileDive(file.listFiles(), input);
                }
                findContent(file, input);
        }
        return validFiles;
    }

    private void findContent(File file, String input){
        StringBuilder sb = new StringBuilder();
        try{
            BufferedReader br = new BufferedReader(new FileReader(file)); 
        } catch (FileNotFoundException err){
             System.out.println("File is not a file???");
        }
        int lineNum = 1;
        String st; 

        while ((st = br.readLine()) != null){
            if(st.contains(input)){
                sb.append(file.getPath() + " : " + lineNum + " - " + st);
                validFiles.add(sb.toString());
            }
            lineNum++;
        } 

          }
    }
    
   