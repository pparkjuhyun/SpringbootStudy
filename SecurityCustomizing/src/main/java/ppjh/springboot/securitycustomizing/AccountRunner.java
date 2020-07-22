package ppjh.springboot.securitycustomizing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import ppjh.springboot.securitycustomizing.account.Account;
import ppjh.springboot.securitycustomizing.account.AccountService;

@Component
public class AccountRunner implements ApplicationRunner {

    @Autowired
    AccountService accountService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Account juhyun = accountService.createAccount("juhyun", "pass");
        System.out.println(juhyun.getUsername() + " password: " + juhyun.getPasword());
    }
}
