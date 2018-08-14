package password.keeper.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PasswordGenerator {

    private static final String LOWER = "abcdefghijklmnoprstuwxyz";
    private static final String UPPER = "ABCDEFGHIJKLMNOPRSTUWXYZ";
    private static final String NUMBERS = "0123456789";
    private static final String PUNCTUATION = "!@#$%&*()_+-=[]|,./?><";
    private boolean useLower;
    private boolean useUpper;
    private boolean useNumbers;
    private boolean usePunctuation;


    public PasswordGenerator(boolean useLower, boolean useUpper, boolean useNumbers, boolean usePunctuation){
        this.useLower = useLower;
        this.useUpper = useUpper;
        this.useNumbers = useNumbers;
        this.usePunctuation = usePunctuation;
    }

    public String generatePassword(int passwordLength){

        StringBuilder password = new StringBuilder(passwordLength);
        Random random = new Random();

        List<String> charsToUse = new ArrayList<>(4);

        if (useLower){
            charsToUse.add(LOWER);
        }
        if (useUpper){
            charsToUse.add(UPPER);
        }
        if (useNumbers){
            charsToUse.add(NUMBERS);
        }
        if (usePunctuation){
            charsToUse.add(PUNCTUATION);
        }

        for (int i = 1; i <= passwordLength; i++){
            String usedChars = charsToUse.get(random.nextInt(charsToUse.size()));
            int position = random.nextInt(usedChars.length());
            password.append(usedChars.charAt(position));
        }

        return new String(password);
    }
}
