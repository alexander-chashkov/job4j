package ru.job4j.calculate;
/**
*	@author Alexander Chashkov
*	@since 2018.11.07
*	@version 0.0.0.1
*/
public class Calculate {
	/**
	* Method echo.
	* @param name Your name.
	* @return Echo plus your name.
	*/
	public String echo(String name) {
		return "Echo, echo, echo : " + name;
	}
	/**
	* main
	* @param args - args
	*/
	public static void main(String[] args) {
		Calculate calc = new Calculate();
		System.out.println(calc.echo("Alexander Chashkov"));
	}
}
