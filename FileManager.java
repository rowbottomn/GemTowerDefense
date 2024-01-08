import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
//import java.nio.file.Path;
//import java.nio.file.Paths;
/**
 * FileManager is designed to handle saving and loading txt files in one go.
 * Use with Array Manager to handle processing the text you receive.
 *
 * @author Nathan Rowbottom
 * @version Nov 3 2023
 */
public class FileManager
{

    private File input;
    private File output;
    private FileWriter writer;
    private FileReader reader;
    private String fileName;
    /**
     * Default constructor for objects of class FileManager
     * sets filename to "temp.txt"
     * 
     */
    public FileManager()
    {
        fileName = "temp.txt";
    }

    /**
     * Constructor for objects of class FileManager
     * @params : String fileName
     */
    public FileManager(String fileName)
    {
        this.fileName = fileName;
    }

    /**
     * getPath
     * @return the string of where the Java VM considers the active directory for file loading and saving
     * Used more for testing.
     */
    public String getPath(){
        //get a reference for the current directory
        try{
            File tempFile = new File(fileName);
            String tempPath = tempFile.getAbsolutePath();//gets the full path
            return tempPath.split(fileName)[0];//get a string ofthe file locations on the drive
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * writeOver
     * 
     * @param  fileName a string with the file to be written over
     * @param  msg a string of the data to be written into the file
     *
     */
    public void writeOver(String fileName, String msg){
        try{
            //open the file 
            output = new File(fileName);
            //write the info
            writer = new FileWriter(output, false);
            writer.write(msg);
            //close the file
            writer.close();
        }
        //catch the exception
        catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * write
     * @param  fileName a string with the file to be appended to
     * @param  msg a string of the data to be written into the file with a return character added on
     *
     */
    void write(String fileName, String msg){
        writeAll(fileName, msg+"\n");
    }

    /**
     * write
     * @param  fileName a string with the file to be appended to
     * @param  msg a string of the data to be written into the file WITHOUT a return character added on
     *
     */
    void writeAll(String fileName, String msg){
        //in a try catch 
        try{
            //open the file 
            output = new File(fileName);
            //write the info
            writer = new FileWriter(output, true);
            writer.write(msg);
            //close the file
            writer.close();
        }
        //catch the exception
        catch(Exception e){
            e.printStackTrace();
        }

    }

    /**
     * read
     * used the set fileName to read a file
     * @return  a string of the data in the file
     *
     */
    String read(){
        return read(this.fileName);
    }

    /**
     * read
     * @param  fName a string with the file to be read from
     * @return  a string of the data in the file
     *
     */
    String read(String fName){

        String lines = "";
        try{
            input = new File(fName);
            reader = new FileReader(input);
            BufferedReader br = new BufferedReader(reader);
            String line;
            while ((line = br.readLine()) != null) {
                lines += line;
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return lines;
    }

    /**
     * read
     * Returns a string of the line number by reading all the preceeding lines
     * and then returning the next line
     * If the file does not contain enough lines, then returns null
     * @param  fileName a string with the file to be read from
     * @param  lineNume an int of the line to be returned
     * @return  a string of the data in the file
     *
     */
    String read(String fileName, int lineNum){
        String line = "";
        try{
            input = new File(fileName);
            reader = new FileReader(input);
            BufferedReader br = new BufferedReader(reader);

            for  (int i = 0; i < lineNum; i++) {

                if (line == null){
                    return null; 
                }
            }
            line = br.readLine();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return line;
    }

    /**
     * readAsArray Returns a string array of the entire text file
     * To get individual lines do a read method with string and int
     * @param  fileName a string with the file to be read from
     * @return  a string[] of the data in the file where each line is an
     * an element of the array.
     */
    String[] readAsArray(String fileName){
        String lines = "";
        String [] linesArr = "Not initialized".split("");
        try{
            input = new File(fileName);
            reader = new FileReader(input);
            BufferedReader br = new BufferedReader(reader);
            String line;
            while ((line = br.readLine()) != null) {
                lines += line;
            }

            linesArr = lines.split("\n");
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return linesArr;
    }

}