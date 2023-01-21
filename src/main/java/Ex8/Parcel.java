package Ex8;

public class Parcel {
    private int xLength;
    private int yLength;
    private int zLength;
    private float weight;
    private boolean express;

    public Parcel(int xLength, int yLength, int zLength, float weight, boolean express) {
        this.xLength = xLength;
        this.yLength = yLength;
        this.zLength = zLength;
        this.weight = weight;
        this.express = express;
    }

    @Override
    public String toString() {
        return "Parcel{" +
                "x=" + xLength +
                ", y=" + yLength +
                ", z=" + zLength +
                ", weight=" + weight +
                ", express=" + express +
                '}';
    }

    public int getxLength() {
        return xLength;
    }

    public int getyLength() {
        return yLength;
    }

    public int getzLength() {
        return zLength;
    }

    public float getWeight() {
        return weight;
    }

    public boolean isExpress() {
        return express;
    }
}
