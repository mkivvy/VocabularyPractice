package vocabularypractice;
import vocabularypractice.LanguageIndicators;

/**
 * VocabularySet is a concrete class containing terms an definitions data 
 * and their access and edit methods for Vocabulary Practice Project.
 * 
 * @author Mary King, mking@my.wctc.edu
 * @version 1.0
 */
public class VocabularySet {
    
    private static final String EMPTY_STR = "";
    private LanguageIndicators langInd;
    private String term;
    private String definition;
    private static final int ZERO_LEN = 0;
    private static final String INVALID_TERM_MSG = "Term must contain a "
            + "vaild value.";
    private static final String INVALID_DEFINITION_MSG = "Definition must "
            + "contain a vaild value.";
    private static final String INVALID_LANG_IND_MSG = "Language Indicator must "
            + "contain a vaild value.";

    public VocabularySet() {
        this.term = EMPTY_STR;
        this.definition = EMPTY_STR;
        setLangInd(LanguageIndicators.ENGLISH);
    }

    public VocabularySet(String term, String definition) {
        setTerm(term);
        setDefinition(definition);
        setLangInd(LanguageIndicators.ENGLISH);
    }

    public VocabularySet(String term, String definition, LanguageIndicators langInd) {
        setTerm(term);
        setDefinition(definition);
        setLangInd(langInd);
    }

    public String getTerm() {
        return term;
    }

    public String getDefinition() {
        return definition;
    }

    public char getLangInd() {
        return langInd.getValue();
    }
    
    /**
     * Sets the value of the private variable for the term. 
     * 
     * @param term the term being defined, not null, not empty
     * @throws  NullPointerException if the definition parameter is null
     * @throws  IllegalArgumentException if the definition parameter is empty
     */
    public final void setTerm(String term) 
            throws NullPointerException, IllegalArgumentException {
        if (term == null) {
            throw new NullPointerException(INVALID_TERM_MSG);
        } else if (term.length() == ZERO_LEN) {
            throw new IllegalArgumentException(INVALID_TERM_MSG);
        }
        this.term = term;
    }

    /**
     * Sets the value of the private variable for the definition. 
     * 
     * @param definition the definition corresponding to the term,
     *             not null, not empty
     * @throws  NullPointerException if the definition parameter is null
     * @throws  IllegalArgumentException if the definition parameter is empty
     */
    public final void setDefinition(String definition) 
            throws NullPointerException, IllegalArgumentException {
        if (definition == null) {
            throw new NullPointerException(INVALID_DEFINITION_MSG);
        } else if (definition.length() == ZERO_LEN) {
            throw new IllegalArgumentException(INVALID_DEFINITION_MSG);
        }
        this.definition = definition;
    }

    /**
     * Sets the value of the private variable for the term. 
     * 
     * @param term the term being defined, not null, not empty
     * @throws  NullPointerException if the definition parameter is null
     * @throws  IllegalArgumentException if the definition parameter is empty
     */
    public final void setLangInd(LanguageIndicators langInd) 
            throws NullPointerException {
        if (langInd == null) {
            throw new NullPointerException(INVALID_LANG_IND_MSG);
        }
        this.langInd = langInd;
    }

    @Override
    public String toString() {
        return "VocabularySet{" + "term=" + term + ", definition=" + definition + ", langInd=" + langInd + '}';
    }
    
    public static void main(String[] args) {
        VocabularySet vs;
        
//        vs = new VocabularySet();
//        vs.setTerm("decrescendo");
//        vs.setDefinition("a gradual decrease in volume of a musical passage");
//        vs.setLangInd(LanguageIndicators.ENGLISH);
//        System.out.println(vs.toString());
        
//        vs = new VocabularySet("decrescendo","a gradual decrease in volume of a musical passage");
//        System.out.println(vs.toString());
        
        vs = new VocabularySet("decrescendo","a gradual decrease in volume of a "
                + "musical passage",LanguageIndicators.ENGLISH);
        System.out.println(vs.toString());
        
        System.out.println("term: " + vs.getTerm());
        System.out.println("definition: " + vs.getDefinition());
        System.out.println("language: " + vs.getLangInd());
    }
}
