package project.web;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import project.models.Emploees;
import project.service.EmployeeServiceEmpl;


@RestController
@RequestMapping(path = "/emploee" )
@CrossOrigin(origins = "http://localhost:3000")
public class EmployeeController {

    private EmployeeServiceEmpl employeeServiceEmpl;

    public EmployeeController(EmployeeServiceEmpl employeeServiceEmpl){
        this.employeeServiceEmpl = employeeServiceEmpl;
    }

    @PostMapping(path = "/add-emploee", consumes="application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Emploees addEmploee(@RequestBody Emploees emploees){
        return employeeServiceEmpl.addEmploee(emploees);
    }

    @GetMapping("/del-emploee/{id}")
    public String deleteEmploee(@PathVariable("id") String id){
        employeeServiceEmpl.deleteEmploee(id);
        return "Выполнено удаление сотрудника";
    }

    @GetMapping("find/{id}")
    public Emploees findEmploee(@PathVariable("id") String id){
        return employeeServiceEmpl.findEmploee(id);
    }

    @GetMapping("/all")
    public Iterable<Emploees> allEmploee(){
        return employeeServiceEmpl.allEmploee();
    }

    @GetMapping("/amount")
    public String getAmount(){
        return employeeServiceEmpl.getAmount();
    }

}
