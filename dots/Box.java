
public class Box {
	public boolean top;
	public boolean bottom;
	public boolean right;
	public boolean left;
	public char owner;
	public Box(){
		top=bottom=false;
		right=left=false;
		owner = ' ';
	}
	
	public void draw_line(int row, int column, int x, int y) {
		int width = column * 50 + 114;
		int height = row * 50 + 41;
		System.out.println("Box Class : height is " + height + " ,width is" + width);
		int left1 = x - width;
		int right1 = width + 50 - x;
		int top1 = y - height;
		int bottom1 = height + 50 - y;
		if((left1 < right1) && (left1 < top1) && (left1 < bottom1)) {
			left = true;
		}
		else if((right1 < left1) && (right1 < top1) && (right1 < bottom1)) {
			right = true;
		}
		else if((top1 < left1) && (top1 < right1) && (top1 < bottom1)) {
			top = true;
		}
		else if((bottom1 < left1) && (bottom1 < right1) && (bottom1 < top1)) {
			bottom = true;
		}
	}
	public boolean check_box() {
		if((top == true) && (bottom == true) && (left == true) && (right == true)) {
			return true;
		}
		else {
			return false;
		}
	}
}
