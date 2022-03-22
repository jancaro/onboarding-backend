package com.pichincha.mvc.util;

import com.ibm.icu.text.RuleBasedNumberFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class Util {

  public static final Locale LOCALE = Locale.forLanguageTag("es-EC");
  private static NumberFormat numberFormat = NumberFormat.getNumberInstance(
      Locale.forLanguageTag("en-US"));
  private static RuleBasedNumberFormat formatter = new RuleBasedNumberFormat(LOCALE,
      RuleBasedNumberFormat.SPELLOUT);

  private Util() {
  }

  public static String spellNumber(Double number) {
    StringBuilder numberString = new StringBuilder(formatter.format(number).toLowerCase());
    int index = numberString.indexOf(" coma ");
    if (index >= 0) {
      numberString.delete(index, numberString.length());
    }
    numberString.append(String.format(" con %s/100",
        numberFormat.format(number).substring(numberFormat.format(number).lastIndexOf(".") + 1)));
    return numberString.toString().toUpperCase();
  }

  public static SimpleDateFormat getDateLongFormat() {
    return new SimpleDateFormat("dd 'días del mes de' MMMM 'del año' yyyy", Util.LOCALE);
  }

}
