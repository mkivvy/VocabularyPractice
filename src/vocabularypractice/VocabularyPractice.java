package vocabularypractice;

import FileService.Delimiters;
import FileService.TextFileReadWriteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * VocabularyPractice simulates a ticket generated when a car enters a parking 
 * garage within the Vocabulary Practice Project.
 * The ticket contains a keyId and the date-time the car entered the garage.
 * 
 * @author Mary King, mking@my.wctc.edu
 * @version 1.0
 */

/**
 *
 * @author Mary
 */
public class VocabularyPractice {

    private InputStrategy fileInputStrategy;
    private List<VocabularySet> vsList;
    private static final String DOUBLE_BACKSLASH = "\\";
    private static final int TERM_IDX = 1;
    private static final int DEF_IDX = 2;
    private static final int NUM_REC_FIELDS = 3;
    private static final String UNEXPECTED_DATA_MSG = "Vocabulary Practice file " 
            + " does not contain the correct number of fields.";
    private static final String NO_DATA_MSG = "Vocabulary Practice file " 
            + " contains no data.";

    /**
     * Constructor instantiates the class 
    */
    public VocabularyPractice() {
        fileInputStrategy = new  TermsAndDefinitionsFileInput();
    }
    
    public final void fillVocabularySetList() {
        vsList = new ArrayList<VocabularySet>();
        List<String> termsDef = new ArrayList<String>();
        termsDef = fileInputStrategy.getAllData();
        
        // Now we have a list of strings from the file with each string
        // equating to a "record" of type VocabularySet.  Next we need to
        // populate the list of VocabularySets by splitting each string into
        // "fields" and copying the data to the appropriate VocabualrySet spot.
        
        //get the String representation of the delimiter
        String delimiterStr = DOUBLE_BACKSLASH + Delimiters.TAB.getValue();
        for (String s : termsDef){
            //split the line into a string array using the specified delimiter
            String[] splitData = s.split(delimiterStr);
            VocabularySet vocab = 
                    new VocabularySet(splitData[TERM_IDX], splitData[DEF_IDX]);
            vsList.add(vocab);
            if (splitData.length != NUM_REC_FIELDS) {
                throw new IllegalArgumentException(UNEXPECTED_DATA_MSG);
            }            
        }
        if (vsList.isEmpty()) {    
            throw new IllegalArgumentException(NO_DATA_MSG);
        }        
        //Move following code later.
        // Now vsList is populated.  Check to see contents. 
        for (VocabularySet v : vsList){
            System.out.println("term: " + v.getTerm());
            System.out.println("def: " + v.getDefinition());
        }
        System.out.println("-------------------------------------------");
        int listMax = vsList.size(); 
        System.out.println(" max = " + listMax);
        Random rand = new Random(System.currentTimeMillis());
        int rNum;
        for (int j = 0; (j<10) && (listMax > 0); j++)
        {
            //returns int in range 0 to max-1; since List members are numbered
            //0 to (max-1), no adjustments are necessary
            rNum = rand.nextInt(listMax);
            System.out.println("turn = " + j + " max = " + listMax + " pick = " + rNum);
            System.out.println("term: " + vsList.get(rNum).getTerm() + "\t" + 
                    "def: " + vsList.get(rNum).getDefinition());
            vsList.remove(rNum);
            listMax--;
        }
 } 
             
     public static void main(String[] args) {
         VocabularyPractice vp = new VocabularyPractice();
         vp.fillVocabularySetList();
     }
}
