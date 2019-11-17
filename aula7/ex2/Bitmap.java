package aula7.ex2;

import java.io.*;

public class Bitmap {
	BitmapFileHeader bitmapFileHeader;
	BitmapInfoHeader bitmapInfoHeader;
	byte[] data;
	
	public Bitmap(File f) throws IOException {
		
		FileInputStream fis = new FileInputStream(f);
		DataInputStream dis = new DataInputStream(fis);
		
		
		bitmapFileHeader = new BitmapFileHeader(dis.readShort(), dis.readInt(), dis.readShort(), dis.readShort(), dis.readInt());
		bitmapInfoHeader = new BitmapInfoHeader(dis.readInt(),dis.readInt(), dis.readInt(), dis.readShort(), dis.readShort(), dis.readInt(), dis.readInt(), dis.readInt(), dis.readInt(), dis.readInt(), dis.readInt());
		
		System.out.println(bitmapFileHeader +"\n"+ bitmapInfoHeader);
		
		data = new byte[dis.available()];
		dis.read(data);
		
		dis.close();
		fis.close();
	}

	public Bitmap(BitmapFileHeader bitmapFileHeader, BitmapInfoHeader bitmapInfoHeader, byte[] data) {
		this.bitmapFileHeader = bitmapFileHeader;
		this.bitmapInfoHeader = bitmapInfoHeader;
		this.data = data;
	}
	
	public void exportRAW() throws IOException{
		FileOutputStream fos = new FileOutputStream("../prog3/src/aula7/ex2/Figura.raw");
		DataOutputStream dos = new DataOutputStream(fos);
		dos.write(data);
		dos.close();
		fos.close();
	}
	
	public void exportBMP(String name) throws IOException{
		FileOutputStream fos = new FileOutputStream("../prog3/src/aula7/ex2/"+ name + ".bmp");
		DataOutputStream dos = new DataOutputStream(fos);
		
		dos.writeShort(bitmapFileHeader.type);
		dos.writeInt(bitmapFileHeader.size);
		dos.writeShort(bitmapFileHeader.reserved1);
		dos.writeShort(bitmapFileHeader.reserved2);
		dos.writeInt(bitmapFileHeader.offBits);
		
		dos.writeInt(bitmapInfoHeader.size);
		dos.writeInt(bitmapInfoHeader.width);
		dos.writeInt(bitmapInfoHeader.height);
		dos.writeShort(bitmapInfoHeader.planes);
		dos.writeShort(bitmapInfoHeader.bitCount);
		dos.writeInt(bitmapInfoHeader.compression);
		dos.writeInt(bitmapInfoHeader.sizeImage);
		dos.writeInt(bitmapInfoHeader.xPelsPerMeter);
		dos.writeInt(bitmapInfoHeader.yPelsPerMeter);
		dos.writeInt(bitmapInfoHeader.clrUsed);
		dos.writeInt(bitmapInfoHeader.clrImportant);
		
		dos.write(data);
		
		dos.close();
		fos.close();
	}
	
	public Bitmap shrink() {
		int height = Math.abs(bitmapInfoHeader.height);
		int width = Math.abs(bitmapInfoHeader.width)*3;
		byte[] new_data = new byte[data.length/4];
		
		int x=0;
		for(int i=0 ; i<height ; i++) {
			for(int j=0 ; j<width ; i++) {
				if(i%2==0) {
					new_data[x] = data[j + (width * i)];
					new_data[x+1] = data[j + (width * i)+1];
					new_data[x+2] = data[j + (width * i)+2];
					x+=3;
				}
			}
		}
		
		BitmapFileHeader bfh = new BitmapFileHeader(bitmapFileHeader.type, bitmapFileHeader.size - new_data.length * 3, bitmapFileHeader.reserved1, bitmapFileHeader.reserved2, bitmapFileHeader.offBits);
        BitmapInfoHeader bih = new BitmapInfoHeader(bitmapInfoHeader.size, bitmapInfoHeader.width / 2, bitmapInfoHeader.height / 2, bitmapInfoHeader.planes, bitmapInfoHeader.bitCount, bitmapInfoHeader.compression, new_data.length, bitmapInfoHeader.xPelsPerMeter / 2, bitmapInfoHeader.yPelsPerMeter / 2, bitmapInfoHeader.clrUsed, bitmapInfoHeader.clrImportant);
        
        return new Bitmap(bfh, bih, new_data);
	}

	public Bitmap flipHorizontal() {
        int height = Math.abs(bitmapInfoHeader.height);
        int width = Math.abs(bitmapInfoHeader.width) * 3;
        byte[] new_data = new byte[data.length];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j+=3) {
                new_data[(((i+1)*width) - j) - 1]     = data[j + (width * i) + 2];
                new_data[(((i+1)*width) - (j+1)) - 1] = data[j + (width * i) + 1];
                new_data[(((i+1)*width) - (j+2)) - 1] = data[j + (width * i)];
            }
        }
        
        return new Bitmap(bitmapFileHeader, bitmapInfoHeader, new_data);
    }

    public Bitmap flipVertical() {
        int height = Math.abs(bitmapInfoHeader.height);
        int width = Math.abs(bitmapInfoHeader.width) * 3;
        byte[] new_data = new byte[data.length];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j+=3) {
                new_data[(((height-i-1)*width) + j)]     = data[j + (width * i)];
                new_data[(((height-i-1)*width) + (j+1))] = data[j + (width * i) + 1];
                new_data[(((height-i-1)*width) + (j+2))] = data[j + (width * i) + 2];
            }
        }
        
        return new Bitmap(bitmapFileHeader, bitmapInfoHeader, new_data);
    }

    public Bitmap reverseBytes() {
	    BitmapFileHeader bfh = new BitmapFileHeader(Short.reverseBytes(bitmapFileHeader.type),Integer.reverseBytes(bitmapFileHeader.size),Short.reverseBytes(bitmapFileHeader.reserved1),Short.reverseBytes(bitmapFileHeader.reserved2),Integer.reverseBytes(bitmapFileHeader.offBits));
	    BitmapInfoHeader bih = new BitmapInfoHeader(Integer.reverseBytes(bitmapInfoHeader.size), Integer.reverseBytes(bitmapInfoHeader.width), Integer.reverseBytes(bitmapInfoHeader.height), Short.reverseBytes(bitmapInfoHeader.planes), Short.reverseBytes(bitmapInfoHeader.bitCount), Integer.reverseBytes(bitmapInfoHeader.compression),Integer.reverseBytes(bitmapInfoHeader.sizeImage), Integer.reverseBytes(bitmapInfoHeader.xPelsPerMeter), Integer.reverseBytes(bitmapInfoHeader.yPelsPerMeter), Integer.reverseBytes(bitmapInfoHeader.clrUsed), Integer.reverseBytes(bitmapInfoHeader.clrImportant));
	    
        return new Bitmap(bfh, bih, data);
	}
}
