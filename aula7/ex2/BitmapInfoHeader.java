package aula7.ex2;

public class BitmapInfoHeader {
	int size;
	int width;
	int height;
	short planes;
	short bitCount;
	int compression;
	int sizeImage;
	int xPelsPerMeter;
	int yPelsPerMeter;
	int clrUsed;
	int clrImportant;

	public BitmapInfoHeader(int size, int width, int height, short planes, short bitCount, int compression, int sizeImage, int xPelsPerMeter, int yPelsPerMeter, int clrUsed, int clrImportant) {
		this.size = size;
		this.width = width;
		this.height = height;
		this.planes = planes;
		this.bitCount = bitCount;
		this.compression = compression;
		this.sizeImage = sizeImage;
		this.xPelsPerMeter = xPelsPerMeter;
		this.yPelsPerMeter = yPelsPerMeter;
		this.clrUsed = clrUsed;
		this.clrImportant = clrImportant;
	}

	@Override
    public String toString() {
        return "BitmapInfoHeader{" +
                "size=" + size +
                ", width=" + width +
                ", height=" + height +
                ", planes=" + planes +
                ", bitCount=" + bitCount +
                ", compression=" + compression +
                ", sizeImage=" + sizeImage +
                ", xPelsPerMeter=" + xPelsPerMeter +
                ", yPelsPerMeter=" + yPelsPerMeter +
                ", clrUsed=" + clrUsed +
                ", clrImportant=" + clrImportant +
                '}';
    }
}
