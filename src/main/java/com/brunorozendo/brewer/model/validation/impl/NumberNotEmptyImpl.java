package com.brunorozendo.brewer.model.validation.impl;

import com.brunorozendo.brewer.model.validation.NumberNotEmpty;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.util.Locale;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NumberNotEmptyImpl implements ConstraintValidator<NumberNotEmpty, Number> {

  @Override
  public boolean isValid(Number value, ConstraintValidatorContext context) {
    boolean result = false;
    if (value != null) {

      DecimalFormatSymbols symbols = new DecimalFormatSymbols(new Locale("pt", "BR"));
      symbols.setGroupingSeparator('.');
      symbols.setDecimalSeparator(',');
      String pattern = "#,##0.00";
      DecimalFormat decimalFormat = new DecimalFormat(pattern, symbols);
      decimalFormat.setParseBigDecimal(true);

      try {
        decimalFormat.parse(value.toString());
        result = true;
      } catch (ParseException p) {
        //return false
      }
    }
    return result;

  }
}