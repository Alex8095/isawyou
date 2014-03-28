/**
 * 
 */
package com.frogorf.isawyou.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

/** @author Tsurkin Alex
 * @version */
public class UserTest {

	@Test
	@Transactional
	public void testUser() {
		assertEquals(1, 1);
	}
}

/* @Test
 * 
 * @Transactional public void testHasPet() { Owner owner = new Owner(); Pet
 * fido = new Pet(); fido.setName("Fido"); assertNull(owner.getPet("Fido"));
 * assertNull(owner.getPet("fido")); owner.addPet(fido); assertEquals(fido,
 * owner.getPet("Fido")); assertEquals(fido, owner.getPet("fido")); } */