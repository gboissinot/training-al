package fr.gboissinot.al.account.step13;

import fr.gboissinot.al.account.step13.adapter.out.AccountPersistenceAdapter;
import fr.gboissinot.al.account.step13.application.port.in.CreateAccountUseCase;
import fr.gboissinot.al.account.step13.application.port.in.GetAccountBalanceUseCase;
import fr.gboissinot.al.account.step13.application.port.in.SendMoneyUseCase;
import fr.gboissinot.al.account.step13.application.services.CreateAccountService;
import fr.gboissinot.al.account.step13.application.services.GetAccountBalanceService;
import fr.gboissinot.al.account.step13.application.services.SendMoneyService;
import fr.gboissinot.al.account.step13.domain.AccountConfiguration;
import fr.gboissinot.al.kernel.KernelConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(KernelConfiguration.class)
@SuppressWarnings("all")
public class ApplicationConfiguration {

    @Bean
    public AccountPersistenceAdapter persistenceAdapter() {
        return new AccountPersistenceAdapter();
    }

    @Bean
    public CreateAccountUseCase createAccountUseCase() {
        return new CreateAccountService(persistenceAdapter());
    }

    @Bean
    public SendMoneyUseCase sendMoneyUseCase() {
        return new SendMoneyService(
                new AccountConfiguration(500), persistenceAdapter(), persistenceAdapter());
    }

    @Bean
    public GetAccountBalanceUseCase accountBalanceUseCase() {
        return new GetAccountBalanceService(persistenceAdapter());
    }
}
