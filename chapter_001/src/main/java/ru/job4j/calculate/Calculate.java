package ru.job4j.calculate;
/**
*	@author Alexander Chashkov
*	@since 2018.11.07
*	@version 0.0.0.1
*/
public class Calculate {
	public String echo (String value) {
		return String.format("%s %s %s", value, value, value);
	}
	/**
	* main
	* @param args - args
	*/
	public static void main (String []args){
		Calculate calc = new Calculate ();
		System.out.println(calc.echo("aah"));
	}
}