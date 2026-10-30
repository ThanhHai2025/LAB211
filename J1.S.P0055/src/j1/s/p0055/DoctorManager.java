package j1.s.p0055;

import java.util.ArrayList;
import java.util.List;

/**
 * DoctorManager class to manage the doctor as add, update, delete and search.
 *
 * @version 29/10/2026
 * @author HaiNT
 */
public class DoctorManager {

    /**
     * Declare list of doctors in system.
     */
    private List<Doctor> doctorList;

    /**
     * Constructor to initialize the doctor list.
     */
    public DoctorManager() {
        doctorList = new ArrayList<>();
    }

    /**
     * Find a doctor in the list by code.
     *
     * @param code the code of the doctor to find.
     * @return the doctor if found, otherwise null.
     */
    private Doctor findByCode(String code) {
        for (Doctor doctor : doctorList) {
            if (doctor.getCode().equalsIgnoreCase(code)) {
                return doctor;
            }
        }
        return null;
    }

    /**
     * Add new doctor in the system.
     *
     * @param doctorObj the doctor object to be added.
     * @throws Exception if database is code is duplicated.
     */
    public void addDoctor(Doctor doctorObj) throws Exception {
        //Check if code is not null
        if (doctorObj.getCode() != null) {
            doctorObj.setCode(doctorObj.getCode().toUpperCase());
        }

        //Check if code already exist
        if (findByCode(doctorObj.getCode()) != null) {
            throw new Exception("Doctor code already exists!");
        }
        doctorList.add(doctorObj);

        //Outer loop for sorting passes.
        for (int i = 0; i < doctorList.size() - 1; i++) {
            //Inner loop to compare adjeacent items.
            for (int j = 0; j < doctorList.size() - 1 - i; j++) {
                //check if they are out of order.
                if (doctorList.get(j).getCode().compareTo(doctorList.get(j + 1).getCode()) > 0) {
                    //Swap elements to sort ascending.
                    Doctor temp = doctorList.get(j);
                    doctorList.set(j, doctorList.get(j + 1));
                    doctorList.set(j + 1, temp);
                }
            }
        }
    }

    /**
     * Update information of an existing doctor.
     *
     * @param newDoctor doctor object is updated information.
     * @throws Exception if database is code does not exist.
     */
    public void updateDoctor(Doctor newDoctor) throws Exception {
        //Check if database is empty.
        if (doctorList.isEmpty()) {
            throw new Exception("No doctors  doctors in database.");
        }

        String code = newDoctor.getCode().toUpperCase();

        //Find doctor by code.
        Doctor doctor = findByCode(code);

        //Check if doctor code does not exist.
        if (doctor == null) {
            throw new Exception("Doctor code does not exist.");
        }

        //Update name if new name is not empty.
        if (!newDoctor.getName().trim().isEmpty()) {
            doctor.setName(newDoctor.getName());
        }

        //Update specialization if new specialization is not empty.
        if (!newDoctor.getSpecialization().trim().isEmpty()) {
            doctor.setSpecialization(newDoctor.getSpecialization());
        }

        //Update avalability if new availability is valid( >= 0).
        if (newDoctor.getAvailability() >= 0) {
            doctor.setAvailability(newDoctor.getAvailability());
        }
    }

    /**
     * Delete doctor as doctor code.
     *
     * @param code the code to be delete.
     * @throws Exception if database is code does not exist.
     */
    public void deleteDoctor(String code) throws Exception {
        //Check if database is empty
        if (doctorList.isEmpty()) {
            throw new Exception("No doctor in database");
        }

        //Find doctor by code.
        Doctor doctor = findByCode(code.toUpperCase());

        //Check if doctor code does not exist.
        if (doctor == null) {
            throw new Exception("Doctor code does not exist!");
        }

        //Remove doctor from the list.
        doctorList.remove(doctor);
    }

    public List<Doctor> searchDoctor(String text) throws Exception {
        //Check if database is empty.
        if (doctorList.isEmpty()) {
            throw new Exception("No doctors in database!");
        }

        List<Doctor> result = new ArrayList<>();
        String keyword = text.toLowerCase();

        //Loop through each doctor in the list
        for (Doctor doctor : doctorList) {

            //Check if keyword matches code, name or specialization.
            if (doctor.getCode().toLowerCase().contains(keyword)
                    || doctor.getName().toLowerCase().contains(keyword)
                    || doctor.getSpecialization().toLowerCase().contains(keyword)) {
                //Add matching doctor to the result list.
                result.add(doctor);
            }
        }
        //Check if no doctors were found
        if (result.isEmpty()) {
            throw new Exception("No matching doctors found.");
        }
        return result;
    }
}
