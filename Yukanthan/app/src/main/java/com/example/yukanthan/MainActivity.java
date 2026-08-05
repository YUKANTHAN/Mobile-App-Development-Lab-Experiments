package com.example.yukanthan;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private int[] colors = {Color.RED, Color.GREEN, Color.BLUE, Color.MAGENTA, Color.BLACK, Color.CYAN};
    private Typeface[] fonts = {Typeface.DEFAULT, Typeface.SERIF, Typeface.SANS_SERIF, Typeface.MONOSPACE};
    private int colorIndex = 0;
    private int fontIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        textView = findViewById(R.id.textView_yukanthan);
        Button btnChangeColor = findViewById(R.id.btn_change_color);
        Button btnChangeFont = findViewById(R.id.btn_change_font);

        btnChangeColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                colorIndex = (colorIndex + 1) % colors.length;
                textView.setTextColor(colors[colorIndex]);
            }
        });

        btnChangeFont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fontIndex = (fontIndex + 1) % fonts.length;
                textView.setTypeface(fonts[fontIndex], Typeface.BOLD);
            }
        });
    }
}
