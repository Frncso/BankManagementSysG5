package BankManage.AppService;

import BankManage.AccountModels.OneTimeCode;
import BankManage.DataService.OneTimeCodeDataService;
import java.security.SecureRandom;

public class OneTimeCodeService {

    private final OneTimeCodeDataService otcDataService = new OneTimeCodeDataService();
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int CODE_LENGTH = 8;

    // generator ng A-Z, 0-9 (grabe sa permutation yan, combinatorix)
    public String generateAccessCode() {
        SecureRandom random = new SecureRandom();
        StringBuilder code = new StringBuilder(CODE_LENGTH);
        
        for (int i = 0; i < CODE_LENGTH; i++) {
            int index = random.nextInt(CHARACTERS.length());
            code.append(CHARACTERS.charAt(index));
        }
        
        return code.toString();
    }

    // generate tas save
    public String createNewAccessCode() {
        String code = generateAccessCode();
        boolean saved = otcDataService.generateAccessCode(code);
        return saved ? code : null;
    }

    // validation
    public boolean validateAccessCode(String code) {
        return otcDataService.isValidAccessCode(code);
    }

    // mark code as used pag register
    public boolean useAccessCode(String code, String employeeId) {
        return otcDataService.markCodeAsUsed(code, employeeId);
    }
}