package aplicacionesmoviles.avanzado.todosalau.ejemplomagneticsensormvp.modelo;

// Esta clase representa el modelo de datos para los valores del magnetómetro
public class MagnetometerModel {
    private float magneticFieldStrength; // Fuerza del campo magnético
    private float magneticFieldX; // Componente X del campo magnético
    private float magneticFieldY; // Componente Y del campo magnético
    private float magneticFieldZ; // Componente Z del campo magnético

    // Constructor que inicializa los valores del modelo
    public MagnetometerModel(float magneticFieldStrength, float magneticFieldX, float magneticFieldY, float magneticFieldZ) {
        this.magneticFieldStrength = magneticFieldStrength;
        this.magneticFieldX = magneticFieldX;
        this.magneticFieldY = magneticFieldY;
        this.magneticFieldZ = magneticFieldZ;
    }

    // Métodos para obtener los valores de los campos magnéticos

    public float getMagneticFieldStrength() {
        return magneticFieldStrength; // Retorna la fuerza del campo magnético
    }

    public float getMagneticFieldX() {
        return magneticFieldX; // Retorna la componente X del campo magnético
    }

    public float getMagneticFieldY() {
        return magneticFieldY; // Retorna la componente Y del campo magnético
    }

    public float getMagneticFieldZ() {
        return magneticFieldZ; // Retorna la componente Z del campo magnético
    }
}