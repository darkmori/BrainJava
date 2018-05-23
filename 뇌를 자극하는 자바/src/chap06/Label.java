package chap06;

public class Label implements Changeable {
	String text;
	int width, height;
	String foreground, background;
	String font;

	Label(String text, int width, int height, String foreground, String background, String font) {
		super();
		this.text = text;
		this.width = width;
		this.height = height;
		this.foreground = foreground;
		this.background = background;
		this.font = font;
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		this.width = width;
		this.height = height;
	}

	@Override
	public void setForeground(String color) {
		// TODO Auto-generated method stub
		this.foreground = color;
	}

	@Override
	public void setBackground(String color) {
		// TODO Auto-generated method stub
		this.background = color;
	}

	@Override
	public void setFont(String font) {
		this.font = font;

	}

}
