/*package com.frogorf.isawyou.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.frogorf.isawyou.domain.User;

*//** <p>
 * Integration test using the 'Spring Data' profile.
 * 
 * @see AbstractisawyouServiceTests AbstractisawyouServiceTests for more
 *      details.
 *      </p>
 * @author Tsurkin Alex *//*
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:WEB-INF/spring/business-context.xml" })
@TransactionConfiguration(transactionManager = "transactionManager")
public class IsawyouServiceTest {

	@Autowired
	protected IsawyouService isawyouService;

	private static final Logger logger = LoggerFactory.getLogger(IsawyouServiceTest.class);

	 @Test
	 * 
	 * @Transactional public void findUser() { List<User> users =
	 * this.isawyouService.findUserByLastName("Davis"); assertEquals(2,
	 * users.size()); users = this.isawyouService.findUserByLastName("Daviss");
	 * assertEquals(0, users.size()); }
	 * 
	 * @Test public void findSingleOwner() { User user1 =
	 * this.isawyouService.findUserById(1);
	 * assertTrue(user1.getLastName().startsWith("Franklin")); User user10 =
	 * this.isawyouService.findUserById(10); assertEquals("Carlos",
	 * user10.getFirstName()); // assertEquals(user1.getPets().size(), 1); } 

	@Test
	@Transactional
	public void testInsertUser() {
		List<User> users = this.isawyouService.findUserAll();
		int found = users.size();
		User user = new User();
		user.setFirstName("Sam");
		user.setLastName("Schultz");
		this.isawyouService.saveUser(user);
		users = this.isawyouService.findUserAll();
		assertEquals("Verifying number of owners after inserting a new one.", found + 1, users.size());
	}

	@Test
	@Transactional
	public void testUpdateUser() throws Exception {
		User user = new User();
		user.setFirstName("Sam");
		user.setLastName("Schultz");
		this.isawyouService.saveUser(user);
		User o1 = this.isawyouService.findUserById(1);
		String old = o1.getLastName();
		o1.setLastName(old + "X");
		this.isawyouService.saveUser(o1);
		o1 = this.isawyouService.findUserById(1);
		assertEquals(old + "X", o1.getLastName());
	}

	 @Test public void findPet() { Collection<PetType> types =
	 * this.isawyouService.findPetTypes(); Pet pet7 =
	 * this.isawyouService.findPetById(7);
	 * assertTrue(pet7.getName().startsWith("Samantha"));
	 * assertEquals(EntityUtils.getById(types, PetType.class, 1).getId(),
	 * pet7.getType().getId()); assertEquals("Jean",
	 * pet7.getOwner().getFirstName()); Pet pet6 =
	 * this.isawyouService.findPetById(6); assertEquals("George",
	 * pet6.getName()); assertEquals(EntityUtils.getById(types, PetType.class,
	 * 4).getId(), pet6.getType().getId()); assertEquals("Peter",
	 * pet6.getOwner().getFirstName()); } 

	 @Test public void getPetTypes() { Collection<PetType> petTypes =
	 * this.isawyouService.findPetTypes();
	 * 
	 * PetType petType1 = EntityUtils.getById(petTypes, PetType.class, 1);
	 * assertEquals("cat", petType1.getName()); PetType petType4 =
	 * EntityUtils.getById(petTypes, PetType.class, 4); assertEquals("snake",
	 * petType4.getName()); } 

	 @Test
	 * 
	 * @Transactional public void insertPet() { Owner owner6 =
	 * this.isawyouService.findOwnerById(6); int found =
	 * owner6.getPets().size(); Pet pet = new Pet(); pet.setName("bowser");
	 * Collection<PetType> types = this.isawyouService.findPetTypes();
	 * pet.setType(EntityUtils.getById(types, PetType.class, 2));
	 * pet.setBirthDate(new DateTime()); owner6.addPet(pet); assertEquals(found
	 * + 1, owner6.getPets().size()); // both storePet and storeOwner are
	 * necessary to cover all ORM tools this.isawyouService.savePet(pet);
	 * this.isawyouService.saveOwner(owner6); owner6 =
	 * this.isawyouService.findOwnerById(6); assertEquals(found + 1,
	 * owner6.getPets().size()); } 

	 @Test
	 * 
	 * @Transactional public void updatePet() throws Exception { Pet pet7 =
	 * this.isawyouService.findPetById(7); String old = pet7.getName();
	 * pet7.setName(old + "X"); this.isawyouService.savePet(pet7); pet7 =
	 * this.isawyouService.findPetById(7); assertEquals(old + "X",
	 * pet7.getName()); } 

	 @Test public void findVets() { Collection<Vet> vets =
	 * this.isawyouService.findVets();
	 * 
	 * Vet v1 = EntityUtils.getById(vets, Vet.class, 2); assertEquals("Leary",
	 * v1.getLastName()); assertEquals(1, v1.getNrOfSpecialties());
	 * assertEquals("radiology", (v1.getSpecialties().get(0)).getName()); Vet v2
	 * = EntityUtils.getById(vets, Vet.class, 3); assertEquals("Douglas",
	 * v2.getLastName()); assertEquals(2, v2.getNrOfSpecialties());
	 * assertEquals("dentistry", (v2.getSpecialties().get(0)).getName());
	 * assertEquals("surgery", (v2.getSpecialties().get(1)).getName()); } 

	 @Test
	 * 
	 * @Transactional public void insertVisit() { Pet pet7 =
	 * this.isawyouService.findPetById(7); int found = pet7.getVisits().size();
	 * Visit visit = new Visit(); pet7.addVisit(visit);
	 * visit.setDescription("test"); // both storeVisit and storePet are
	 * necessary to cover all ORM tools this.isawyouService.saveVisit(visit);
	 * this.isawyouService.savePet(pet7); pet7 =
	 * this.isawyouService.findPetById(7); assertEquals(found + 1,
	 * pet7.getVisits().size()); } 
}*/