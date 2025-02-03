package com.ajay.app.controller;

import com.ajay.app.model.Patient;
import com.ajay.app.service.PatientService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PatientControllerTest {
    @InjectMocks
    PatientController patientController;
    @Mock
    PatientService patientService;

    @Test
    public void testGetAllPatients() {
        Map<String, Patient> Map = new HashMap<>();
        Patient p1 = new Patient("p1","1","A",25,"F");
        Patient p2 = new Patient("p2","2","B",21,"M");
        Patient p3 = new Patient("p3","3","C",43,"M");
        Map.put(p1.getId(), p1);
        Map.put(p2.getId(), p2);
        Map.put(p3.getId(), p3);
        when(patientService.readAllPatients()).thenReturn(Map);
        Map<String, Patient> ResultMap=patientController.getAllPatients();
        assert ResultMap!=null;
        assert ResultMap.size()==3;
        assert ResultMap.get(p1.getId())==p1;
        assert ResultMap.get(p2.getId())==p2;
        assert ResultMap.get(p3.getId())==p3;
    }

    @Test
    public void testCreatePatients() {
        Patient p1 = new Patient("p1","1","A",25,"F");
        when(patientService.createPatient(p1)).thenReturn(p1);
        Patient resultEmployee=patientController.createPatient(p1);
        assert resultEmployee!=null;
        assert resultEmployee.getId()==p1.getId();
        assert resultEmployee.getName().equals("p1");
        assert resultEmployee.getAge()==25;
    }
    @Test
    public void testUpdatePatients() {
        Patient p1 = new Patient("p1","1","A",25,"F");
        Patient p2 = new Patient("p2","2","B",21,"M");
        when(patientService.updatePatient(anyString(),anyString())).thenReturn(p2);
        Patient resultPatient=patientController.updatePatient(p1.getHospitalName(),"D");
        assert resultPatient!=null;
        assert resultPatient.getId()==p2.getId();
        assert resultPatient.getName().equals("p2");
        assert resultPatient.getHospitalName()=="D";
    }
    @Test
    public void testDeleteEmployees() {
        doNothing().when(patientService).deletePatient(anyString());
        patientController.deletePatient("1");
        verify( patientController, atLeast(1)).deletePatient(anyString());
    }

}



