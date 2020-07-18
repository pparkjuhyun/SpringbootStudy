package ppjh.springboot.jpa.account;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest  //Slicing Test
//@SpringBootTest //Integrity Test
public class AccountRepositoryTest {
    @Autowired
    DataSource dataSource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    AccountRepository accountRepository;

    @Test
    public void di() throws Exception {
        try(Connection connection = dataSource.getConnection()) {
            DatabaseMetaData metaData = connection.getMetaData();
            System.out.println(metaData.getURL());
            System.out.println(metaData.getDriverName());
            System.out.println(metaData.getUserName());
        }

        Account account = new Account();
        account.setUsername("juhyun");
        account.setPassword("pass");

        Account newAccount = accountRepository.save(account);
        assertThat(newAccount).isNotNull();

//        Account existingAccount = accountRepository.findByUsername(newAccount.getUsername());
//        assertThat(existingAccount).isNotNull();
        Optional<Account> existingAccount = accountRepository.findByUsername(newAccount.getUsername());
        assertThat(existingAccount).isNotEmpty();

//        Account nonExistingAccount = accountRepository.findByUsername("test");
//        assertThat(nonExistingAccount).isNotNull();
        Optional<Account> nonExistingAccount = accountRepository.findByUsername("test");
        assertThat(nonExistingAccount).isEmpty();
    }
}