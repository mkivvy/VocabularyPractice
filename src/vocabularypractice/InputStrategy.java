package vocabularypractice;

import java.util.List;

/**
 * InputStrategy is the interface to obtain data used as input within the 
 * VocabularyPractice Project. 
 * The data is returned as an array of Strings.
 * 
 * @author Mary King, mking@my.wctc.edu
 * @version 1.0
 */
public interface InputStrategy {

    /**
     * Returns an array of String data back to the caller.
     * @return an array of Strings with data from a particular source.
     */
    public abstract String[] getData();
    
    /**
     * Returns an list of String data back to the caller.
     * @return an list of Strings with data from a particular source.
     */
    public abstract List<String> getAllData();
    
}
