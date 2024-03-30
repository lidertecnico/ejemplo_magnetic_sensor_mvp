package aplicacionesmoviles.avanzado.todosalau.ejemplomagneticsensormvp.modelo;

// Esta clase representa el modelo de datos para los valores del acelerómetro
public class AccelerometerModel {
    private float accelerometerX; // Componente X de la aceleración
    private float accelerometerY; // Componente Y de la aceleración
    private float accelerometerZ; // Componente Z de la aceleración
    private float accelerationMagnitude; // Magnitud de la aceleración

    // Constructor que inicializa los valores del modelo y calcula la magnitud de la aceleración
    public AccelerometerModel(float accelerometerX, float accelerometerY, float accelerometerZ) {
        this.accelerometerX = accelerometerX;
        this.accelerometerY = accelerometerY;
        this.accelerometerZ = accelerometerZ;
        this.accelerationMagnitude = calculateMagnitude(); // Calcula la magnitud de la aceleración
    }

    // Métodos para obtener los valores de las componentes del acelerómetro

    public float getAccelerometerX() {
        return accelerometerX; // Retorna la componente X de la aceleración
    }

    public float getAccelerometerY() {
        return accelerometerY; // Retorna la componente Y de la aceleración
    }

    public float getAccelerometerZ() {
        return accelerometerZ; // Retorna la componente Z de la aceleración
    }

    public float getAccelerationMagnitude() {
        return accelerationMagnitude; // Retorna la magnitud de la aceleración
    }

    // Método privado para calcular la magnitud de la aceleración
    private float calculateMagnitude() {
        return (float) Math.sqrt(accelerometerX * accelerometerX +
                accelerometerY * accelerometerY +
                accelerometerZ * accelerometerZ); // Aplica la fórmula de magnitud de un vector
    }
}