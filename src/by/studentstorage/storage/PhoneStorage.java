package by.studentstorage.storage;

import by.studentstorage.domain.Phone;


import java.util.List;

public interface PhoneStorage {
        boolean save(Phone phone);
        Phone remove(int userId);
        Phone updatePhone(Phone phone, int userId);
        List<Phone> getAllPhoneNumber();
        Phone getByNumberUserId(int userId);


}
