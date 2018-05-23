package chap06;

public class Rectangle implements Transformable {
	int x, y, width, height;

	Rectangle(int x, int y, int width, int height) {
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	@Override
	public void moveTo(int x, int y) {
		// TODO Auto-generated method stub
		this.x = x;
		this.y = y;
	}

	@Override
	public void moveBy(int xOffset, int yOffset) {
		// TODO Auto-generated method stub
		this.x += xOffset;
		this.y += yOffset;
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		this.width = width;
		this.height = height;
	}
}
