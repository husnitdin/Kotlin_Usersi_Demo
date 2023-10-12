package com.example.kotlin_basicapi_demo.controller

import com.example.kotlin_basicapi_demo.models.Employee
import com.example.kotlin_basicapi_demo.models.Office
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/api/employee")
class EmployeeController() {

    @PostMapping("hire")
    fun hireEmp(@RequestBody emp: Employee): String {
        return Office.hireEmp(emp)
    }

    @GetMapping("fire/{id}")
    fun fireEmp(@PathVariable id: Int): String {

        if (Office.fireEmp(id))
            return ("person hired with $id")
        else
            return ("person can not be hired with $id")

    }

    @GetMapping("one")
    fun oneEmp(): Employee {
        return Employee(1, "Ali", "ali@gmail.com", "ATTRM")
    }

    @GetMapping("all")
    fun allEmp(): MutableSet<Employee> {

        return Office.getAllEmps()

//        return listOf(
//            Employee(1,"Ali", "ali@gmail.com", "ATTRM"),
//            Employee(2,"Anna", "anna@gmail.com", "NURSE"),
//            Employee(3,"Brian", "brain@gmail.com", "VICE"))
    }


}