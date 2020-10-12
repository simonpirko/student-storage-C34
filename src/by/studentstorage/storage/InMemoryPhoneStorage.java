package by.studentstorage.storage;

import by.studentstorage.domain.Phone;
import java.util.ArrayList;
import java.util.List;

public class InMemoryPhoneStorage implements PhoneStorage {
    private List<Phone> phoneList = new ArrayList<>();

    @Override
    public boolean save(Phone phone) {
        if (phoneList.add(phone)) {
            return true;
        }
        return false;
    }

    @Override
    public Phone remove(int userId) {
        Phone phone = null;
        for (int i = 0; i < phoneList.size(); i++) {
            if (phoneList.get(i).getUserId() == userId){
                phone = phoneList.get(i);
                phoneList.remove(i);
            }
        }
        return phone;
    }

    @Override
    public Phone updatePhone(Phone phone, int userId) {
        for (int i = 0; i < phoneList.size(); i++) {
            if (phoneList.get(i).getUserId() == userId) {
                phoneList.get(i).setPhoneNumber(phone.getPhoneNumber());
            }
        }
          return phone;
    }


    @Override
    public List<Phone> getAllPhoneNumber() {
        return phoneList;
    }

    @Override
    public Phone getByNumberUserId(int phoneNumber) {
        for (int i = 0; i < phoneList.size(); i++) {
            if (phoneList.get(i).getPhoneNumber() == phoneNumber) {
                return phoneList.get(i);
            }
        }
        return null;
    }
}
