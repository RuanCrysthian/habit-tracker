package com.rfdev.habittracker.services.validations;

import com.rfdev.habittracker.controllers.exceptions.FieldMessage;
import com.rfdev.habittracker.dtos.UserInsertDTO;
import com.rfdev.habittracker.models.User;
import com.rfdev.habittracker.repositories.UserRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class UserInsertValidator implements ConstraintValidator<UserInsertValid, UserInsertDTO> {

  @Autowired
  private UserRepository repository;

  @Override
  public void initialize(UserInsertValid ann) {
  }

  @Override
  public boolean isValid(UserInsertDTO dto, ConstraintValidatorContext context) {

    List<FieldMessage> list = new ArrayList<>();

    // Coloque aqui seus testes de validação, acrescentando objetos FieldMessage à lista
    User user = repository.findByEmail(dto.getEmail());
    if (user != null) {
      list.add(new FieldMessage("email", "Email already exists"));
    }

    // inserindo na lista de erros do BeanValidation
    for (FieldMessage e : list) {
      context.disableDefaultConstraintViolation();
      context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
        .addConstraintViolation();
    }
    return list.isEmpty();
  }
}
