package ru.job4j.calculate;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
*	Test
*	@author Alexander Chashkov
*	@since 2018.11.09
*	@version  $Id$
*/
public class CalculateTest {
	/**
	*	Test echo
	*/
	@Test
	public void whenTakeNameThenTreeEchoPlusName() {
		String input = "Alexander Chashkov";
		String expect = "Echo, echo, echo : Alexander Chashkov"; 
		Calculate calc = new Calculate();
		String result = calc.echo(input);
		assertThat(result, is(expect));
	}
}