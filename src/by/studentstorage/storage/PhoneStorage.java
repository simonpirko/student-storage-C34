package by.studentstorage.storage;

import by.studentstorage.domain.Phone;


import java.util.List;

public interface PhoneStorage {
        boolean save(Phone phone);
        Phone remove(long userId);
        Phone updatePhone(Phone phone, long userId);
        List<Phone> getAllPhoneNumber();
        Phone getByNumberUserId(long userId);
        boolean contains(Phone phone);


}
