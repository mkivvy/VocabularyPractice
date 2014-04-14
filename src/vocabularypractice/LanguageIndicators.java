package vocabularypractice;

/**
 * LanguageIndicators is the enum class containing acceptable values for use in 
 * the VocabularySet class.
 * The character value of the enum can be retrieved using the method getValue().
 * 
 * @author Mary King, mking@my.wctc.edu
 * @version 1.0
 */
public enum LanguageIndicators {
    ENGLISH('E'),
    FRENCH('F'),
    GERMAN('G');
    
    private char value;

    private LanguageIndicators(char value) {
        this.value = value;
    }
    
    /**
     * Returns the character value of the enum name.
     * 
     * @return the character value assigned to the enum name
     */
    public final char getValue() {
        return value;
    }
}
