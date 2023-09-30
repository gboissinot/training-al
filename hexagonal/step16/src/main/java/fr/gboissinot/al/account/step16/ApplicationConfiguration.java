package fr.gboissinot.al.account.step16;

import fr.gboissinot.al.account.step16.adapter.out.AccountEntityRepository;
import fr.gboissinot.al.account.step16.adapter.out.AccountPersistenceAdapter;
import fr.gboissinot.al.account.step16.application.services.CreateAccountService;
import fr.gboissinot.al.account.step16.application.services.GetAccountBalanceService;
import fr.gboissinot.al.account.step16.application.services.SendMoneyService;
import fr.gboissinot.al.account.step16.domain.AccountConfiguration;
import fr.gboissinot.al.kernel.KernelConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(KernelConfiguration.class)
public class ApplicationConfiguration {

    @Autowired
    private AccountEntityRepository accountEntityRepository;

    @Bean
    public AccountPersistenceAdapter persistenceAdapter() {
        return new AccountPersistenceAdapter(accountEntityRepository);
    }

    @Bean
    public CreateAccountService createAccountService() {
        return new CreateAccountService(persistenceAdapter());
    }

    @Bean
    public SendMoneyService sendMoneyService() {
        return new SendMoneyService(
                new AccountConfiguration(500), persistenceAdapter(), persistenceAdapter());
    }

    @Bean
    public GetAccountBalanceService accountBalanceService() {
        return new GetAccountBalanceService(persistenceAdapter());
    }
}
