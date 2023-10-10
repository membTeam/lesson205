package project.service;

import org.springframework.stereotype.Component;
import project.config.ConfigProject;
import project.models.Emploees;
import project.repositories.EmploeeRepositories;

@Component
public class EmployeeServiceEmpl implements EmployeeService {

    private EmploeeRepositories emploeeRepositories;
    public EmployeeServiceEmpl(EmploeeRepositories repository){
        emploeeRepositories = repository;
    }

    private boolean verifyExistsEmploee(String id){
        if (!emploeeRepositories.existsById(id)){
            return false;
        } else {
            return true;
        }
    }

    @Override
    public String getAmount(){
        var amount = emploeeRepositories.count();
        var limit = ConfigProject.getLimitAmount();
        return String.format("Кол-во сотрудников: %d (Ограничение: %d)", amount, limit);
    }

    @Override
    public Emploees addEmploee(Emploees emploee) {
        var count = emploeeRepositories.count();
        if ( !(count < ConfigProject.getLimitAmount())){
            throw new EmployeeStorageIsFullException("Переполнение базы");
        }

        return emploeeRepositories.save(emploee);
    }

    @Override
    public void deleteEmploee(String id) {
        if (!verifyExistsEmploee(id)){
            throw new EmployeeNotFoundException("Нет данных");
        }

        emploeeRepositories.deleteById(id);
    }

    @Override
    public Emploees findEmploee(String id) {

        if (!verifyExistsEmploee(id)){
            throw new EmployeeNotFoundException("Нет данных");
        }

        return emploeeRepositories.findById(id).get();
    }

    @Override
    public Iterable<Emploees> allEmploee(){
        var count = emploeeRepositories.count();
        if (count == 0){
            throw new EmployeeNotFoundException("Нет данных");
        }

        return emploeeRepositories.findAll();
    }
}
