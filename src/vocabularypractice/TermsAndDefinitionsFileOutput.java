package vocabularypractice;

import FileService.CSVPlusFormatter;
import FileService.Delimiters;
import FileService.FileService;
import FileService.ListAndLinkedHashMapConverter;
import FileService.TextFileFormatStrategy;
import FileService.TextFileWriteLines;
import FileService.TextFileWriteStrategy;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;

/**
 * TermsAndDefinitionsFileOutput is a concrete class which outputs the input String 
 * ArrayList to the production totals file within the MKK-ParkingGaragePOS 
 * Project.
 * 
 * @author Mary King, mking@my.wctc.edu
 * @version 1.0
 */
public class TermsAndDefinitionsFileOutput implements OutputStrategy {

    private File ttlsFile;
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
    private TextFileWriteStrategy writer;
    private TextFileFormatStrategy formatStrategy;
    private static final int ZERO = 0;
    private static final String MISSING_DETAIL_MSG = "The ArrayList of Detail "
            + "Lines must contain at least 1 line.";
    private static final String MISSING_FILE_NAME_MSG = "A File Name must be "
            + "provided.";
    private static final String MISSING_FILE_MSG = "A File must be provided.";
    private static final String MISSING_FORMAT_STRATEGY_MSG = "A Text File "
            + "Format Strategy must be provided.";
    private static final String MISSING_WRITE_STRATEGY_MSG = "A Text File Write "
            + "Strategy must be provided.";
    private static final String RECORDS_MISMATCH_MSG = "Number of records "
            + "written to file does not match number of records passed in.";

    /**
     * Default constructor sets and initializes classes using default values
     */
    public TermsAndDefinitionsFileOutput() {
        setDefaults();
    }

    /**
     * Constructor instantiates the class setting the writer and format strategy
     * private variables. 
     * 
     * @param writer the text file write strategy to be used for writing the
     * production totals file for the parking garage, not null, not empty
     * @param formatStrategy the text file format strategy to be used for 
     * formatting the production totals file, not null, not empty
     * @throws NullPointerException if the garageInfo parameter is null
     */
    public TermsAndDefinitionsFileOutput(TextFileWriteStrategy writer, 
            TextFileFormatStrategy formatStrategy) {
        ttlsFile = new File(fileName);
        fileService = new FileService();
        //instantiate converter for easier viewing & writing preparation
        converter = new ListAndLinkedHashMapConverter();
        setFormatStrategy(formatStrategy);
        setWriter(writer);
    }

    /**
     * For writing to the production totals file, there is no special 
     * handling for writing header information, so this method does nothing.
     * 
     * @param headerLines an ArrayList of Strings with header data to display
     */
    @Override
    public final void outputHeader(ArrayList<String> headerLines) 
            throws NullPointerException, IllegalArgumentException {
        //Only outputBody is used since the header is written as part of the body
    }

    /**
     * The ArrayList of String detailLines is converted to a LinkedHashMap.
     * The contents of this map is then written to the production totals file 
     * using the FileService.
     * 
     * @param detailLines an ArrayList of Strings with detail data to be written 
     * to the production totals file for the parking garage.
     * @throws NullPointerException if the detailLines parameter is null
     * @throws IllegalArgumentException if the detailLines parameter is empty
     * or if the number of records written does not match the number sent
     */
    @Override
    public final void outputBody(ArrayList<String> detailLines) 
            throws NullPointerException, IllegalArgumentException {
        if (detailLines == null) {
            throw new NullPointerException (MISSING_DETAIL_MSG);
        } else if (detailLines.size() == ZERO) {
            throw new IllegalArgumentException (MISSING_DETAIL_MSG);
        }
        
        int numRecords = detailLines.size();
        List<LinkedHashMap<String, String>> totalsMap = 
                converter.convertListToMap(detailLines, Delimiters.TAB, false);
        int recWritten = fileService.writeTextFile(writer, totalsMap, false);
        if (recWritten < numRecords) {
            throw new IllegalArgumentException(RECORDS_MISMATCH_MSG);
        }
    }

    private void setDefaults() {
        ttlsFile = new File(fileName);
        fileService = new FileService();
        //instantiate converter for easier viewing & writing preparation
        converter = new ListAndLinkedHashMapConverter();
        formatStrategy = new CSVPlusFormatter(Delimiters.TAB);
        writer = new TextFileWriteLines(ttlsFile, formatStrategy);
    }
    
    /**
     * Returns the value of the private variable for the production totals file 
     * name to be used for writing. 
     * 
     * @return the file name to be used to write the production totals file 
     */
    public final String getFileName() {
        return fileName;
    }

    /**
     * Sets the value of the private variable for the production totals file 
     * name to be used for writing. 
     *
     * @param ttlsFile the name of the file to be used for writing out the
     * production totals, not null, not empty
     * @throws NullPointerException if the ttlsFile parameter is null
     */
    public final void setFileName(String fileName) {
        if (fileName == null) {
            throw new NullPointerException(MISSING_FILE_NAME_MSG);
        }
        this.fileName = fileName;
    }

    /**
     * Returns the value of the private variable for the text file format
     * strategy to be used for formatting the production totals file.
     * 
     * @return the text file format strategy to be used to format the production  
     * totals file for the parking garage
     */
    public final TextFileFormatStrategy getFormatStrategy() {
        return formatStrategy;
    }

    /**
     * Sets the value of the private variable for formatStrategy to be used for 
     * formatting the production totals file.
     *
     * @param formatStrategy the text file format strategy to be used for 
     * formatting the production totals file, not null, not empty
     * @throws NullPointerException if the writer parameter is null
     */
    public final void setFormatStrategy(TextFileFormatStrategy formatStrategy) {
        if (formatStrategy == null) {
            throw new NullPointerException(MISSING_FORMAT_STRATEGY_MSG);
        }
        this.formatStrategy = formatStrategy;
    }

    /**
     * Returns the value of the private variable for the text file write 
     * strategy to be used for writing the production totals file for the garage.
     * 
     * @return the text file write strategy to be used to write the production  
     * totals file for the parking garage
     */
    public final TextFileWriteStrategy getWriter() {
        return writer;
    }

    /**
     * Sets the value of the private variable for writer to be used for writing
     * the production totals file.
     *
     * @param writer the text file write strategy to be used for writing the
     * production totals file for the parking garage, not null, not empty
     * @throws NullPointerException if the writer parameter is null
     */
    public final void setWriter(TextFileWriteStrategy writer) {
        if (writer == null) {
            throw new NullPointerException(MISSING_WRITE_STRATEGY_MSG);
        }
        this.writer = writer;
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
        hash = 29 * hash + Objects.hashCode(this.fileName);
        hash = 29 * hash + Objects.hashCode(this.writer);
        hash = 29 * hash + Objects.hashCode(this.formatStrategy);
        return hash;
    }

    /**
     * Determines if two ProdTtlsFileOutput objects are equal based on the 
     * fileName, writer, and formatStrategy variables.
     * 
     * @param obj Object of type ProdTtlsFileOutput, not null
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
        final TermsAndDefinitionsFileOutput other = (TermsAndDefinitionsFileOutput) obj;
        if (!Objects.equals(this.fileName, other.fileName)) {
            return false;
        }
        if (!Objects.equals(this.writer, other.writer)) {
            return false;
        }
        if (!Objects.equals(this.formatStrategy, other.formatStrategy)) {
            return false;
        }
        return true;
    }
    /**
     * Returns a String object containing the values of fileName, writer, and 
     * formatStrategy variables.
     * 
     * @return a String containing the values of all the primary variables 
     * of the class
     */
    @Override
    public String toString() {
        return "ProdTtlsFileOutput{" + "fileName=" + fileName + ", writer=" + writer + ", formatStrategy=" + formatStrategy + '}';
    }

}
