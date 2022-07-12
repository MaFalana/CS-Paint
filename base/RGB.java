public class RGB extends Colour
{
   public RGB()
   {

   } // end null constructor

    public RGB(int R, int G, int B)
    {
        this.R = R;
        this.G = G;
        this.B = B;
    }

    public RGB(int R, int G, int B, int A) // RGB color with alpha value
    {
        this.R = R;
        this.G = G;
        this.B = B;
        this.A = A;
    }
}
