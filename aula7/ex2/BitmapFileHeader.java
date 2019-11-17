package aula7.ex2;

public class BitmapFileHeader {
	short type;
	int size;
	short reserved1;
	short reserved2;
	int offBits;

	public BitmapFileHeader(short type, int size, short reserved1, short reserved2, int offBits) {
		this.type = type;
		this.size = size;
		this.reserved1 = reserved1;
		this.reserved2 = reserved2;
		this.offBits = offBits;
	}

	@Override
    public String toString() {
        return "BitmapFileHeader{" +
                "type=" + type +
                ", size=" + size +
                ", reserved1=" + reserved1 +
                ", reserved2=" + reserved2 +
                ", offBits=" + offBits +
                '}';
    }

}
