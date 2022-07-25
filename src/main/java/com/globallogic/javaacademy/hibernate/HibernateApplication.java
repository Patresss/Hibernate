package com.globallogic.javaacademy.hibernate;

import com.globallogic.javaacademy.hibernate.entity.*;
import com.globallogic.javaacademy.hibernate.service.ContactService;
import com.globallogic.javaacademy.hibernate.service.ContractService;
import com.globallogic.javaacademy.hibernate.service.FarmerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Set;
import java.util.stream.IntStream;

@SpringBootApplication
public class HibernateApplication {

    public static void main(String[] args) {
        final ConfigurableApplicationContext applicationContext = SpringApplication.run(HibernateApplication.class, args);
        final FarmerService farmerService = applicationContext.getBean(FarmerService.class);
        final ContractService addressService = applicationContext.getBean(ContractService.class);

//        final Address address = new Address()
//                .setCity("Kraków")
//                .setPositionX(123L)
//                .setPositionY(321L);
////        addressService.createAddress(address);
//
//        final Farmer farmer = new Farmer()
//                .setName("Inanna3")
//                .setLastName("Address")
//                .setGender(Gender.FEMALE)
//                .setActiveStatus(false)
//                .setAddress(address);
//
//        final Cow contact = new Cow()
//                .setName("Krowa");
//        farmer.addCow(contact);
//        final Cow contact2 = new Cow()
//                .setName("Krowa2");
//        farmer.addCow(contact2);
//
//        farmerService.findBbId(farmer);
//        farmerService.deleteFarmer(251L);

        manyToMany(applicationContext);
    }

    private static void oprahRemoval(final ConfigurableApplicationContext applicationContext) {
        final FarmerService farmerService = applicationContext.getBean(FarmerService.class);

        farmerService.deleteFirstContact(51L);
    }

    private static void manyToMany(final ConfigurableApplicationContext applicationContext) {
        final FarmerService farmerService = applicationContext.getBean(FarmerService.class);
        final Farmer farmer = new Farmer()
                .setName("John")
                .setLastName("Smith")
                .setGender(Gender.MALE)
                .setActiveStatus(true);

        final Address address = new Address()
                .setCity("Kraków")
                .setPosition(new Position().setPositionX(999L).setPositionY(321L));

        final Address address2 = new Address()
                .setCity("Warszawa")
                .setPosition(new Position().setPositionX(4123L).setPositionY(4321L));

        farmer.addAddress(address);
        farmer.addAddress(address2);
        farmerService.saveFarmer(farmer);
    }

    private static void jpaData(final ConfigurableApplicationContext applicationContext) {
        final FarmerService farmerService = applicationContext.getBean(FarmerService.class);


        final Set<Farmer> farmers = farmerService.findFemale();
        final Set<Farmer> actives = farmerService.findActive();
        System.out.println(farmers);
    }


    private static void nPlusOneProblemInit(final ConfigurableApplicationContext applicationContext) {
        final FarmerService farmerService = applicationContext.getBean(FarmerService.class);


        IntStream.range(0, 10).forEach(i -> {
            final Farmer farmer = new Farmer()
                    .setName("Natalia" + i)
                    .setLastName("Smith")
                    .setGender(Gender.FEMALE)
                    .setActiveStatus(true);

            final Contact contact = new Contact()
                    .setPhoneNumber("123432 324 " + i);
            farmer.addContact(contact);
            farmerService.saveFarmer(farmer);

        });

    }

    private static void nPlusOneProblem(final ConfigurableApplicationContext applicationContext) {
        final ContactService contactService = applicationContext.getBean(ContactService.class);

        final Set<String> phones = contactService.findPhonesWithFarmer();
        System.out.println(phones);
    }


}
