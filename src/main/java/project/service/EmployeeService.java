package project.service;

import project.models.Emploees;

public interface EmployeeService {
    Emploees addEmploee(Emploees emploee);
    void deleteEmploee(String id);
    Emploees findEmploee(String id);

    Iterable<Emploees> allEmploee();

    String getAmount();
}
