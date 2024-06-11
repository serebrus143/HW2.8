package service.impl;

import stereotype.Service;
import exception.InvalidEmployeeDataException;
import service.EmployeeValidationService;

import static org.apache.commons.lang3.StringUtils.isAlpha;

@Service
public class EmployeeValidationServiceImpl implements EmployeeValidationService {
    @Override
    public void validate(String firstName, String lastName) {
        validateName(firstName);
        validateName(lastName);
    }

    private void validateName(String name) {
        if (!isAlpha(name)) {
            throw new InvalidEmployeeDataException("Некорректное значение имени сотрудника");
        }
    }
}
