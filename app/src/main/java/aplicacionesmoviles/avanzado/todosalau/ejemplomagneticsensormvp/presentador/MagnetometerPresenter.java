package aplicacionesmoviles.avanzado.todosalau.ejemplomagneticsensormvp.presentador;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

import aplicacionesmoviles.avanzado.todosalau.ejemplomagneticsensormvp.vista.MagnetometerView;

// Presenter para el magnetómetro
public class MagnetometerPresenter implements SensorEventListener {
    private MagnetometerView view;
    private SensorManager sensorManager;
    private Sensor magnetometer;
    private boolean isListening = false;

    // Constructor que inicializa el presenter con la vista y el contexto
    public MagnetometerPresenter(MagnetometerView view, Context context) {
        this.view = view;
        sensorManager = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
        if (sensorManager != null) {
            magnetometer = sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
        }
    }

    // Método para iniciar la escucha del sensor de magnetómetro
    public void startListening() {
        if (!isListening && sensorManager != null && magnetometer != null) {
            sensorManager.registerListener(this, magnetometer, SensorManager.SENSOR_DELAY_NORMAL);
            isListening = true;
        }
    }

    // Método para detener la escucha del sensor de magnetómetro
    public void stopListening() {
        if (isListening && sensorManager != null) {
            sensorManager.unregisterListener(this);
            isListening = false;
        }
    }

    // Método para verificar si el presenter está escuchando el sensor de magnetómetro
    public boolean isListening() {
        return isListening;
    }

    // Método llamado cuando cambian los valores del sensor de magnetómetro
    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_MAGNETIC_FIELD) {
            float magneticFieldStrength = (float) Math.sqrt(
                    event.values[0] * event.values[0] +
                            event.values[1] * event.values[1] +
                            event.values[2] * event.values[2]);

            // Mostrar el valor del campo magnético en la vista
            view.displayMagneticFieldStrength(magneticFieldStrength);
            view.displayMagneticFieldX(event.values[0]);
            view.displayMagneticFieldY(event.values[1]);
            view.displayMagneticFieldZ(event.values[2]);
        }
    }

    // Método llamado cuando cambia la precisión del sensor
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // No es necesario implementar nada aquí para este ejemplo
    }
}