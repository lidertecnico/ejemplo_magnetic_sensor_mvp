package aplicacionesmoviles.avanzado.todosalau.ejemplomagneticsensormvp.vista;

// Interfaz para la vista del acelerómetro
public interface AccelerometerView {
    void displayAccelerometerValues(float accelerometerX, float accelerometerY, float accelerometerZ);
    void displayAccelerometerX(float accelerometerX);
    void displayAccelerometerY(float accelerometerY);
    void displayAccelerometerZ(float accelerometerZ);
    void displayAccelerationMagnitude(float accelerationMagnitude);
}