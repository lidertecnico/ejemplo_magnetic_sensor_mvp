package aplicacionesmoviles.avanzado.todosalau.ejemplomagneticsensormvp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import aplicacionesmoviles.avanzado.todosalau.ejemplomagneticsensormvp.modelo.MagnetometerModel;
import aplicacionesmoviles.avanzado.todosalau.ejemplomagneticsensormvp.presentador.AccelerometerPresenter;
import aplicacionesmoviles.avanzado.todosalau.ejemplomagneticsensormvp.presentador.MagnetometerPresenter;
import aplicacionesmoviles.avanzado.todosalau.ejemplomagneticsensormvp.vista.AccelerometerView;
import aplicacionesmoviles.avanzado.todosalau.ejemplomagneticsensormvp.vista.MagnetometerView;

public class MainActivity extends AppCompatActivity implements MagnetometerView, AccelerometerView {
    private AccelerometerPresenter accelerometerPresenter;
    private MagnetometerPresenter presenter;
    private Button startButton;
    private Button startAccelerometerButton;
    private TextView accelerometerDataTextView;
    private TextView magneticFieldTextView;
    private TextView magneticFieldXTextView;
    private TextView magneticFieldYTextView;
    private TextView magneticFieldZTextView;
    private TextView accelerometerDataXTextView;
    private TextView accelerometerDataTYextView;
    private TextView accelerometerDataTZextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Inicializar el presentador para el sensor magnetico
        presenter = new MagnetometerPresenter(this, this);
        // Inicializar el presentador para el acelerómetro
        accelerometerPresenter = new AccelerometerPresenter(this, this);


        // Inicialización de vistas y botón
        magneticFieldTextView = findViewById(R.id.textViewMagneticField);
        magneticFieldXTextView = findViewById(R.id.textViewMagneticFieldX);
        magneticFieldYTextView = findViewById(R.id.textViewMagneticFieldY);
        magneticFieldZTextView = findViewById(R.id.textViewMagneticFieldZ);
        startAccelerometerButton = findViewById(R.id.buttonStartAccelerometer);
        accelerometerDataTextView = findViewById(R.id.textViewAccelerationMagnitude);
        accelerometerDataXTextView = findViewById(R.id.textViewAccelerationX);
        accelerometerDataTYextView = findViewById(R.id.textViewAccelerationY);
        accelerometerDataTZextView = findViewById(R.id.textViewAccelerationZ);
        startButton = findViewById(R.id.buttonStart);

        // Configuración del OnClickListener para el botón de inicio
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!presenter.isListening()) {
                    presenter.startListening();
                    startButton.setText("Stop Magnetic Sensor"); // Cambia el texto del botón a "Stop"
                } else {
                    presenter.stopListening();
                    startButton.setText("Start Magnetic Sensor"); // Cambia el texto del botón a "Start"
                }
            }
        });

        // Configurar OnClickListener para el botón de inicio del acelerómetro
        startAccelerometerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!accelerometerPresenter.isListening()) {
                    accelerometerPresenter.startListening();
                    startAccelerometerButton.setText("Stop Accelerometer");
                } else {
                    accelerometerPresenter.stopListening();
                    startAccelerometerButton.setText("Start Accelerometer");
                }
            }
        });
    }

    // Métodos de la interfaz AccelerometerView
    @Override
    public void displayAccelerometerValues(float accelerometerX, float accelerometerY, float accelerometerZ) {
    //
    }

    @Override
    public void displayAccelerometerX(float accelerometerX) {
    accelerometerDataXTextView.setText("Acelerometer Field x:  " + accelerometerX + " m/s²");
    }

    @Override
    public void displayAccelerometerY(float accelerometerY) {
        accelerometerDataTYextView.setText("Acelerometer Field y:  " + accelerometerY + " m/s²");

    }

    @Override
    public void displayAccelerometerZ(float accelerometerZ) {
        accelerometerDataTZextView.setText("Acelerometer Field z:  " + accelerometerZ + " m/s²");

    }

    @Override
    public void displayAccelerationMagnitude(float accelerationMagnitude) {
        accelerometerDataTextView.setText("Acelerometer Field magnitude:   " + accelerationMagnitude + " m/s²");

    }


    @Override
    public void displayMagneticFieldStrength(float magneticFieldStrength) {
        magneticFieldTextView.setText("Magnetic Field: " + magneticFieldStrength + " μT");
    }

    @Override
    public void displayMagneticFieldX(float magneticFieldX) {
        magneticFieldXTextView.setText("Magnetic field X: " + magneticFieldX + " μT");
    }

    @Override
    public void displayMagneticFieldY(float magneticFieldY) {
        magneticFieldYTextView.setText("Magnetic field Y: " + magneticFieldY + " μT");
    }

    @Override
    public void displayMagneticFieldZ(float magneticFieldZ) {
        magneticFieldZTextView.setText("Magnetic field Z: " + magneticFieldZ + " μT");
    }
}