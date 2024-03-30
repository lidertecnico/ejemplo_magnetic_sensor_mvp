package aplicacionesmoviles.avanzado.todosalau.ejemplomagneticsensormvp.presentador;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

import aplicacionesmoviles.avanzado.todosalau.ejemplomagneticsensormvp.modelo.AccelerometerModel;
import aplicacionesmoviles.avanzado.todosalau.ejemplomagneticsensormvp.vista.AccelerometerView;

// Presenter para el acelerómetro
public class AccelerometerPresenter implements SensorEventListener {
    private AccelerometerView view;
    private SensorManager sensorManager;
    private Sensor accelerometer;
    private boolean isListening = false;

    // Constructor que inicializa el presenter con la vista y el contexto
    public AccelerometerPresenter(AccelerometerView view, Context context) {
        this.view = view;
        sensorManager = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
        if (sensorManager != null) {
            accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        }
    }

    // Método para iniciar la escucha del sensor de acelerómetro
    public void startListening() {
        if (!isListening && sensorManager != null && accelerometer != null) {
            sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
            isListening = true;
        }
    }

    // Método para detener la escucha del sensor de acelerómetro
    public void stopListening() {
        if (isListening && sensorManager != null) {
            sensorManager.unregisterListener(this);
            isListening = false;
        }
    }

    // Método para verificar si el presenter está escuchando el sensor de acelerómetro
    public boolean isListening() {
        return isListening;
    }

    // Método llamado cuando cambian los valores del sensor de acelerómetro
    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            float accelerometerX = event.values[0];
            float accelerometerY = event.values[1];
            float accelerometerZ = event.values[2];

            // Crear el modelo con los valores del acelerómetro
            AccelerometerModel model = new AccelerometerModel(accelerometerX, accelerometerY, accelerometerZ);

            // Mostrar los valores del acelerómetro en la vista
            view.displayAccelerometerValues(model.getAccelerometerX(), model.getAccelerometerY(), model.getAccelerometerZ());
            view.displayAccelerometerX(model.getAccelerometerX());
            view.displayAccelerometerY(model.getAccelerometerY());
            view.displayAccelerometerZ(model.getAccelerometerZ());
            view.displayAccelerationMagnitude(model.getAccelerationMagnitude());
        }
    }

    // Método llamado cuando cambia la precisión del sensor
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // No es necesario implementar nada aquí para este ejemplo
    }
}