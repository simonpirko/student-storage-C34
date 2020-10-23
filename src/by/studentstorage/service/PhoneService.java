package by.studentstorage.service;

import by.studentstorage.domain.Phone;
import by.studentstorage.storage.InMemoryPhoneStorage;

import java.util.ArrayList;
import java.util.List;

public class PhoneService {
    InMemoryPhoneStorage inMemoryPhoneStorage = new InMemoryPhoneStorage();

    public boolean save(Phone phone){
        return inMemoryPhoneStorage.save(phone);
    }

    public Phone remove(long userId){
        Phone removePhone = inMemoryPhoneStorage.remove(userId);
        if (removePhone == null){
            throw new PhoneNotFoundException();
        }
        return removePhone;
    }
    public Phone updatePhone(Phone phone, long userId){
        if (inMemoryPhoneStorage.contains(phone)){
            return inMemoryPhoneStorage.updatePhone(phone, userId);
        }
        return phone;
    }

    public List<Phone> getAllPhoneNumber(){
        if(inMemoryPhoneStorage.getAllPhoneNumber().size() != 0){
            return inMemoryPhoneStorage.getAllPhoneNumber();
        }
        throw new PhoneNotFoundException();
    }

    public Phone getByNumberUserId(long phoneNumber){
        List<Phone> all = getAllPhoneNumber();
        if (all.size() == 0){
            throw new PhoneNotFoundException();
        }
        List<Phone> byNumber = new ArrayList<>();
        for (int i = 0; i < all.size(); i++) {
            if (all.get(i).getPhoneNumber() == phoneNumber) {
                byNumber.add(all.get(i));
            }
        }
        return (Phone) byNumber;
    }
}
