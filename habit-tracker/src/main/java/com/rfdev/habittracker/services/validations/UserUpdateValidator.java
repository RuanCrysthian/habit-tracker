package com.rfdev.habittracker.services.validations;

import com.rfdev.habittracker.controllers.exceptions.FieldMessage;
import com.rfdev.habittracker.dtos.UserUpdateDTO;
import com.rfdev.habittracker.models.User;
import com.rfdev.habittracker.repositories.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserUpdateValidator implements ConstraintValidator<UserUpdateValid, UserUpdateDTO> {

  @Autowired
  private HttpServletRequest request;

  @Autowired
  private UserRepository repository;

  @Override
  public void initialize(UserUpdateValid ann) {
  }

  @Override
  public boolean isValid(UserUpdateDTO dto, ConstraintValidatorContext context) {

    @SuppressWarnings("unchecked")
    var uriVars = (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
    var userId = uriVars.get("id");

    List<FieldMessage> list = new ArrayList<>();

    // Coloque aqui seus testes de validação, acrescentando objetos FieldMessage à lista
    User user = repository.findByEmail(dto.getEmail());
    if (user != null && !userId.equals(user.getUserId().toString())) {
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
