/**
 * The ArrayManager class can help with 2D array-filling and management
 * strings should have columns separated by commas 
 * and rows should be separated by ;
 * 
 * @author Nathan Rowbottom 
 * @version Nov 3 2023
 */
public class ArrayManager  
{
    public final boolean DEBUG = false;
    
    /**
     * fillArrayWithData
     * data file should be in the format of hello, world;
     * @param   fm   a constructed FileManager object
     * @param   fileName    a string of the file to load the data from
     * @return  an 2D int array of the data 
     *
     */
    public int[][] fillArrayWithData(FileManager fm, String fileName){
        fm = new FileManager();
        //load map file
        String input = fm.read(fileName);
        //System.out.println(input);
        String[] lines = input.split(";");
        int rows = lines.length;
        String[] temp = lines[0].split(",");
        int cols = temp.length;
        int[][] arr = new int[rows][cols];

        for(int r = 0; r < lines.length;r++){

            String[] tempArr = lines[r].split(",");

            for(int c = 0; c < tempArr.length; c++){
                arr[r][c] = Integer.parseInt(tempArr[c]);
                say(""+arr[r][c]);
            }    

        }   
        return arr;
    }

    /**
     * fillArrayWithData
     * data file should be in the format of hello, world;
     * @param   data a string representation of a 2D array
     * @return  an 2D int array of the data 
     *
     */

    public int[][] fillArrayWithData(String data){

        //load map file
        String input = data;
        //System.out.println(input);
        String[] lines = input.split(";");
        int rows = lines.length;
        
        String[] temp = lines[0].split(",");
        int cols = temp.length;
        int[][] arr = new int[rows][cols];
        sayln("ROWS"+rows+", COLS"+cols);
        for(int r = 0; r < rows;r++){

            String[] tempArr = lines[r].split(",");

            for(int c = 0; c < cols; c++){
                arr[r][c] = Integer.parseInt(tempArr[c]);
                say(""+arr[r][c]);
            }    
            sayln("");
        }   
        sayln("");
        return arr;
    }

    /**
     * fillArrayWithZeroes
     * Fills a 2D int array with zeros
     * @param   rows is the number of rows
     * @param  cols is th enumber of columns for the array
     * @return  an 2D int array filled with zeroes of of the data 
     *
     */
    public int[][] fillArrayWithZeroes(int rows, int cols){
        int [][] arr = new int[rows][cols];
        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                arr[r][c] = 0;
            }
        }
        return arr;
    }

    /**
     * arrayToString
     * Fills a 2D int array with zeros
     * @param  arr is the 2D int array to turn to a string
     * @return  string representation of the 2D int array
     *
     */
    String arrayToString(int[][] arr){
        String output = "";
        for (int r = 0; r < arr.length; r++){
            for(int c = 0; c < arr[0].length-1; c++){
                output+=""+arr[r][c]+",";
            }
            output += arr[r][arr[0].length-1]+";";
        }
        return output;
    }

    /**
     * printArray 
     * Printss a 2D int array with zeros
     * @param  2D int arr to display
     * @return  string representation of the 2D int array
     *
     */
    void printArray(int[][] arr){
        for(int[] i : arr){
            for(int j = 0; j < i.length-1; j++){
                System.out.print(i[j]+",");
            }
            System.out.println(i[i.length-1]+";");
        }
    }
    
    public void sayln(String msg){
        if(DEBUG){
            System.out.println(msg);
        }
    }
    public void say(String msg){
        if(DEBUG){
            System.out.print(msg);
        }
    }
}