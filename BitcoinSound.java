public class BitcoinSound {

    private static double[] pickaxe = StdAudio.read("pickaxe.wav");
    private static double[] chimps = StdAudio.read("chimps.wav");
    private static double[] minion = StdAudio.read("minion.wav");
    private static double[] kittens = StdAudio.read("meow.wav");
    private static double[] precepter = StdAudio.read("amogus.wav");
    private static double[] kevinwayne = StdAudio.read("explosion.wav");

    public static void playSound(int i) {
        if (i == 0)
            StdAudio.play(chimps);
        else if (i == 1)
            StdAudio.play(minion);
        else if (i == 2)
            StdAudio.play(kittens);
        else if (i == 3)
            StdAudio.play(precepter);
        else if (i == 4)
            StdAudio.play(kevinwayne);
        else if (i == 5)
            StdAudio.play(pickaxe);
    }

    public static void main(String[] args) {

    }
}
