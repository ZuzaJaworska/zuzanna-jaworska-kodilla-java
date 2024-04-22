package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.facade.ManyToManyFacade;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CompanyDaoTestSuite {

    @Autowired
    private CompanyDao companyDao;
    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private ManyToManyFacade manyToManyFacade;

    Employee johnSmith = new Employee("John", "Smith");
    Employee stephanieClarkson = new Employee("Stephanie", "Clarkson");
    Employee lindaKovalsky = new Employee("Linda", "Kovalsky");

    Company softwareMachine = new Company("Software Machine");
    Company dataMaesters = new Company("Data Maesters");
    Company greyMatter = new Company("Grey Matter");

    @BeforeEach
    void saveData() {
        softwareMachine.getEmployees().add(johnSmith);
        dataMaesters.getEmployees().add(stephanieClarkson);
        dataMaesters.getEmployees().add(lindaKovalsky);
        greyMatter.getEmployees().add(johnSmith);
        greyMatter.getEmployees().add(lindaKovalsky);

        johnSmith.getCompanies().add(softwareMachine);
        johnSmith.getCompanies().add(greyMatter);
        stephanieClarkson.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(greyMatter);
    }

    @AfterEach
    void cleanUp() {
        try {
            companyDao.deleteAll();
        } catch (Exception e) {
            //do nothing
        }
    }

    @Test
    void testSaveManyToMany() {
        //Given

        //When
        companyDao.save(softwareMachine);
        companyDao.save(dataMaesters);
        companyDao.save(greyMatter);

        //Then
        assertNotEquals(0, softwareMachine.getId());
        assertNotEquals(0, dataMaesters.getId());
        assertNotEquals(0, greyMatter.getId());
    }

    @Test
    void testNamedQueries() {
        //Given
        companyDao.save(softwareMachine);
        companyDao.save(dataMaesters);
        companyDao.save(greyMatter);
        employeeDao.save(johnSmith);
        employeeDao.save(stephanieClarkson);
        employeeDao.save(lindaKovalsky);

        //When
        List<Employee> onlyClarksons = employeeDao.findByLastname("Clarkson");
        List<Company> greCompanies = companyDao.findByThreeFirstLetters("Gre");

        //Then
        assertEquals(1, onlyClarksons.size());
        assertEquals(stephanieClarkson.getLastname(), onlyClarksons.get(0).getLastname());
        assertEquals(1, greCompanies.size());
        assertEquals(greyMatter.getName(), greCompanies.get(0).getName());
    }

    @Test
    void testFacade() {
        //Given
        companyDao.save(softwareMachine);
        companyDao.save(dataMaesters);
        companyDao.save(greyMatter);
        employeeDao.save(johnSmith);
        employeeDao.save(stephanieClarkson);
        employeeDao.save(lindaKovalsky);

        //When
        List<Employee> employeeList = manyToManyFacade.findEmployeeByPartName("lark");
        List<Company> companyList = manyToManyFacade.findCompanyByPartName("ata");

        //Then
        assertEquals(1, employeeList.size());
        assertEquals(stephanieClarkson.getLastname(), employeeList.get(0).getLastname());
        assertEquals(1, companyList.size());
        assertEquals(dataMaesters.getName(), companyList.get(0).getName());
    }
}
