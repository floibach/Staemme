package entities;

public class CalculatedUnits 
{
	private Unit _unit;
	private int _count;
	
	public CalculatedUnits(Unit unit, int count)
	{
		_unit = unit;
		_count = count;
	}

	public Unit get_unit() {
		return _unit;
	}

	public int get_count() {
		return _count;
	}
	
	
}
