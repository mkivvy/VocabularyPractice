package vocabularypractice;

import java.util.ArrayList;

/**
 * OutputStrategy is the interface to output the input String ArrayList within 
 * the Vocabulary Practice Project.
 * 
 * @author Mary King, mking@my.wctc.edu
 * @version 1.0
 */
public interface OutputStrategy {
    /**
     * For each String in the input ArrayList headerLines, a line is output. 
     * This separate method allows for different handling of header Strings
     * from the detail Strings.
     * 
     * @param headerLines an ArrayList of Strings with header data to display
     * @throws NullPointerException if the headerLines parameter is null
     * @throws IllegalArgumentException if the headerLines parameter is empty
     */
    public abstract void outputHeader(ArrayList<String> headerLines)
            throws NullPointerException, IllegalArgumentException;

    /**
     * For each String in the input ArrayList detailLines, a line is output. 
     * 
     * @param detailLines an ArrayList of Strings with detail data to display
     * @throws NullPointerException if the detailLines parameter is null
     * @throws IllegalArgumentException if the detailLines parameter is empty
     */
    public abstract void outputBody(ArrayList<String> detailLines)
            throws NullPointerException, IllegalArgumentException;
}
