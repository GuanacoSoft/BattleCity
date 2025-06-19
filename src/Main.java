public class Main {
    public static void main(String[] args) {
        // Crear una instancia de TankClient y lanzar el juego
        Controllers.TankClient tankClient = Controllers.TankClient.getInstance();
        tankClient.launchFrame();
    }
}