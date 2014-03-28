/**
 * 
 */
package com.frogorf.dictionary.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import com.frogorf.dictionary.domain.Dictionary;
import com.frogorf.dictionary.domain.DictionaryValue;

/** @author Tsurkin Alex
 * @version */
public class DictionaryTest {

	private static final Logger logger = LoggerFactory.getLogger(DictionaryTest.class);

	@Test
	@Transactional
	public void testHasDictionaryValue() {
		Dictionary dictionary = new Dictionary();
		DictionaryValue dictionaryValue = new DictionaryValue();
		dictionaryValue.setName("dictionaryName");
		dictionary.getDictionaryValues().add(dictionaryValue);
		assertEquals(dictionary.getDictionaryValues().size(), 1);
		assertEquals(dictionary.getDictionaryValues().get(0), dictionaryValue);
		assertEquals(dictionary.getDictionaryValues().get(0).getName(), "dictionaryName");
	}
}