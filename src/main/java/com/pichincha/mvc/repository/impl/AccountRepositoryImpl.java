package com.pichincha.mvc.repository.impl;

import com.pichincha.mvc.repository.AccountRepository;
import org.springframework.stereotype.Repository;

@Repository
public class AccountRepositoryImpl implements AccountRepository {

  /*
   * Se recomienda usar inyección de dependecias por constructor
   * en vez de @Autowired, en caso de usar Lombok, puede utilizar
   * la anotación @RequiredArgsConstructor
   * */
  private final com.pichincha.mvc.configuration.ApplicationProperties applicationProperties;

  public AccountRepositoryImpl(
      com.pichincha.mvc.configuration.ApplicationProperties applicationProperties) {
    this.applicationProperties = applicationProperties;
  }

  public String consultAccounts(String clientId) {
    return null;
  }
}
