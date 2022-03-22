package com.pichincha.mvc.service.impl;

import com.pichincha.mvc.service.MvcService;
import org.springframework.stereotype.Service;

@Service
public class MvcServiceImpl implements MvcService {

  /*
   * Se recomienda usar inyección de dependecias por constructor
   * en vez de @Autowired, en caso de usar Lombok, puede utilizar
   * la anotación @RequiredArgsConstructor
   * */

  @Override
  public boolean isFinancialAndLegalEligible(String clientId) {
    return true;
  }
}
