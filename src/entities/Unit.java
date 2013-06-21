package entities;

public class Unit 
{
	private String _image;
	private int _wood;
	private int _clay;
	private int _iron;
	
	public Unit(int wood, int clay, int iron, String image)
	{
		_wood = wood;
		_clay = clay;
		_iron = iron;
		_image = image;
	}
	
	public String get_image()
	{
		return _image;
	}
	public int get_wood() {
		return _wood;
	}
	public int get_clay() {
		return _clay;
	}
	public int get_iron() {
		return _iron;
	}
	
	
	
}
