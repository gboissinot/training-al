package fr.gboissinot.al.account.step10.application.port.in;

public interface SendMoneyUseCase {
    void sendMoney(SendMoneyCommand sendMoneyCommand);
}
