package vocabularypractice;

import FileService.CSVPlusFormatter;
import FileService.Delimiters;
import FileService.FileService;
import FileService.ListAndLinkedHashMapConverter;
import FileService.TextFileFormatStrategy;
import FileService.TextFileReadLines;
import FileService.TextFileReadStrategy;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;

/**
 * TermsAndDefinitionsFileInput is the concrete class which obtains data from the 
 * terms and definitions file in the VocabularyPractice Project and returns it to
 * the caller.
 * 
 * @author Mary King, mking@my.wctc.edu
 * @version 1.0
 */
public class TermsAndDefinitionsFileInput implements InputStrategy {
    
    private static final String DOUBLE_BACKSLASH = "\\";
    private static final int NUM_REC_FIELDS = 3;
    private File vocabFile;
//    private String fileName;
    private String fileName = File.separatorChar + "Users"
            + File.separatorChar + "Mary"
            + File.separatorChar + "Documents"
            + File.separatorChar + "NetbeansProjects"
            + File.separatorChar + "VocabularyPractice"
            + File.separatorChar + "src"
            + File.separatorChar + "vocabularypractice"
            + File.separatorChar + "Vocab.txt"; 
    private FileService fileService;
    private ListAndLinkedHashMapConverter converter;
    private TextFileReadStrategy reader;
    private TextFileFormatStrategy formatStrategy;
    private static final String MISSING_FILE_NAME_MSG = "A File Name must be "
            + "provided.";
    private static final String MISSING_FILE_MSG = "A File must be provided.";
    private static final String MISSING_FORMAT_STRATEGY_MSG = "A Text File "
            + "Format Strategy must be provided.";
    private static final String MISSING_READ_STRATEGY_MSG = "A Text File Read "
            + "Strategy must be provided.";
    private static final String EMPTY_FILE_MSG = "Vocabulary Practice file " 
            + " is empty.";
    private static final String UNEXPECTED_DATA_MSG = "Vocabulary Practice file " 
            + " does not contain the correct number of fields.";

    /**
     * Default constructor sets and initializes classes using default values
     */
    public TermsAndDefinitionsFileInput() {
        setDefaults();
    }

    /**
     * Default constructor sets and initializes classes using default values
     */
    public TermsAndDefinitionsFileInput(String filename) {
        if (filename.length() == 0 || filename.isEmpty()) {
            throw new IllegalArgumentException(MISSING_FILE_MSG);            
        } else {
            this.fileName = filename;
        }
        setDefaults();
    }

    /**
     * Constructor instantiates the class setting the reader and format strategy
     * private variables. 
     * 
     * @param writer the text file write strategy to be used for writing the
     * production totals file for the parking garage, not null, not empty
     * @param formatStrategy the text file format strategy to be used for 
     * formatting the production totals file, not null, not empty
     * @throws NullPointerException if the garageInfo parameter is null
     */
    public TermsAndDefinitionsFileInput(TextFileReadStrategy reader, TextFileFormatStrategy formatStrategy) {
        vocabFile = new File(fileName);
        fileService = new FileService();
        //instantiate converter for easier viewing & writing preparation
        converter = new ListAndLinkedHashMapConverter();
        setFormatStrategy(formatStrategy);
        setReader(reader);
    }
    
    /**
     * Reads the terms and definitions file using the FileService which returns
     * the data as a map.
     * This map is then converted into a List and the first row (header)
     * in the List is split into fields using the tab delimiter.
     * A String array of these fields is returned to the caller.
     * @return an array of Strings with data broken into separate fields
     */
    @Override
    public String[] getData() {

            //read the file
            List<LinkedHashMap<String, String>> termsDefMap = 
                    fileService.readAllTextFile(reader, false);
            if (termsDefMap.isEmpty()) {
                throw new IllegalArgumentException(EMPTY_FILE_MSG);
            }
            //convert the returned map to list for easier access
            List<String> termsDef = converter.convertMapToList
                (termsDefMap, Delimiters.TAB, false);
            //get the String representation of the delimiter
            String delimiterStr = DOUBLE_BACKSLASH + Delimiters.TAB.getValue();
            //split up the fields in the first record using the delimiter
            String[] fields = termsDef.get(0).split(delimiterStr);
            if (fields.length != NUM_REC_FIELDS) {
                throw new IllegalArgumentException(UNEXPECTED_DATA_MSG);
            }
            return fields;
    }

    /**
     * Reads the terms and definitions file using the FileService which returns
     * the data as a map.
     * This map is then converted into a List and the last (most current)
     * row in the List is split into fields using the tab delimiter.
     * A String array of these fields is returned to the caller.
     * @return an array of Strings with data broken into separate fields
     */
     @Override
     public List<String> getAllData() {

            //read the file
            List<LinkedHashMap<String, String>> termsDefMap = 
                    fileService.readAllTextFile(reader, false);
            if (termsDefMap.isEmpty()) {
                throw new IllegalArgumentException(EMPTY_FILE_MSG);
            }
            //convert the returned map to list for easier access
            List<String> termsDef = converter.convertMapToList
                (termsDefMap, Delimiters.TAB, false);
            return termsDef;
    }

    private void setDefaults() {
        vocabFile = new File(fileName);
        fileService = new FileService();
        //instantiate converter for easier viewing & writing preparation
        converter = new ListAndLinkedHashMapConverter();
        formatStrategy = new CSVPlusFormatter(Delimiters.TAB);
        reader = new TextFileReadLines(vocabFile, formatStrategy);
    }
    
    /**
     * Returns the value of the private variable for the production totals file 
     * name to be used for reading. 
     * 
     * @return the file name to be used to read the production totals file 
     */
    public final String getFileName() {
        return fileName;
    }

    /**
     * Sets the value of the private variable for the production totals file 
     * name to be used for reading. 
     *
     * @param vocabFile the name of the file to be used for reading the
     * production totals, not null, not empty
     * @throws NullPointerException if the vocabFile parameter is null
     */
    public final void setFileName(String fileName) {
        if (fileName == null) {
            throw new NullPointerException(MISSING_FILE_NAME_MSG);
        }
        this.fileName = fileName;
    }

    /**
     * Returns the value of the private variable for the text file format
     * strategy to be used to aid in reading the production totals file.
     * 
     * @return the text file format strategy to be used to read the production  
     * totals file for the parking garage
     */
    public final TextFileFormatStrategy getFormatStrategy() {
        return formatStrategy;
    }

    /**
     * Sets the value of the private variable for formatStrategy to be used to 
     * aid in reading the production totals file.
     *
     * @param formatStrategy the text file format strategy to be used to 
     * aid in reading the production totals file, not null, not empty
     * @throws NullPointerException if the writer parameter is null
     */
    public final void setFormatStrategy(TextFileFormatStrategy formatStrategy) {
        if (formatStrategy == null) {
            throw new NullPointerException(MISSING_FORMAT_STRATEGY_MSG);
        }
        this.formatStrategy = formatStrategy;
    }

    /**
     * Returns the value of the private variable for the text file read 
     * strategy to be used for reading the production totals file for the garage.
     * 
     * @return the text file read strategy to be used to read the production  
     * totals file for the parking garage
     */
    public TextFileReadStrategy getReader() {
        return reader;
    }

    /**
     * Sets the value of the private variable for text file read strategy to be 
     * used for extracting the data from the production totals file.
     *
     * @param reader the text file read strategy to be used for reading the
     * production totals file for the parking garage, not null, not empty
     * @throws NullPointerException if the reader parameter is null
     */
    public final void setReader(TextFileReadStrategy reader) {
        if (reader == null) {
            throw new NullPointerException(MISSING_READ_STRATEGY_MSG);
        }
        this.reader = reader;
    }

    /**
     * Calculates the hashCode for the class using the fileName, writer,
     * and formatStrategy variables.
     * 
     * @return the hashCode
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.fileName);
        hash = 31 * hash + Objects.hashCode(this.reader);
        hash = 31 * hash + Objects.hashCode(this.formatStrategy);
        return hash;
    }

    /**
     * Determines if two ProdTtlsFileInput objects are equal based on the 
     * fileName, writer, and formatStrategy variables.
     * 
     * @param obj Object of type ProdTtlsFileInput, not null
     * @return true if the objects are equal, false if the objects are unequal
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TermsAndDefinitionsFileInput other = (TermsAndDefinitionsFileInput) obj;
        if (!Objects.equals(this.fileName, other.fileName)) {
            return false;
        }
        if (!Objects.equals(this.reader, other.reader)) {
            return false;
        }
        if (!Objects.equals(this.formatStrategy, other.formatStrategy)) {
            return false;
        }
        return true;
    }

    /**
     * Returns a String object containing the values of fileName, reader, and 
     * formatStrategy variables.
     * 
     * @return a String containing the values of all the primary variables 
     * of the class
     */
    @Override
    public String toString() {
        return "TermsAndDefinitionsFileInput{" + "fileName=" + fileName + ",reader=" + reader + ", formatStrategy=" + formatStrategy + '}';
    }

    public static void main(String[] args) {
        TermsAndDefinitionsFileInput termsDefInput;
        List<String> termsDef;
        
        termsDefInput = new TermsAndDefinitionsFileInput();
        String[] record = termsDefInput.getData();
        for (int i=0; i<3; i++){
            System.out.println(record [i]);
        }
        
        termsDef = new ArrayList<String>();
        termsDef = termsDefInput.getAllData();
        
        //get the String representation of the delimiter
        String delimiterStr = DOUBLE_BACKSLASH + Delimiters.TAB.getValue();
        for (String s : termsDef){
//            lineCount++;
            //split the line into a string array using the specified delimiter
            String[] splitData = s.split(delimiterStr);
            for (int i = 0; i< NUM_REC_FIELDS; i++)
            { 
                System.out.println(splitData[i]);
            }
//            if (hasHeader && (lineCount == FIRST)) {
//                header = splitData; //this is the header row, set header values
            //split up the fields in the last record using the delimiter
//            String[] fields = termsDef.get(1).split(delimiterStr);
//            if (fields.length != NUM_REC_FIELDS) {
//                throw new IllegalArgumentException(UNEXPECTED_DATA_MSG);
//            }
            
        }

    }
}
