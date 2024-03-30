package aplicacionesmoviles.avanzado.todosalau.ejemplomagneticsensormvp.vista;

// Interfaz para la vista del magnetómetro
public interface MagnetometerView {
    void displayMagneticFieldStrength(float magneticFieldStrength);
    void displayMagneticFieldX(float magneticFieldX);
    void displayMagneticFieldY(float magneticFieldY);
    void displayMagneticFieldZ(float magneticFieldZ);
}