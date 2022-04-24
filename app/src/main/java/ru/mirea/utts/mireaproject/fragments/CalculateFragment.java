package ru.mirea.utts.mireaproject.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import ru.mirea.utts.mireaproject.R;

public class CalculateFragment extends Fragment {
    private EditText editText;
    private TextView textView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_calculate, container, false);
        view.findViewById(R.id.calculateButton).setOnClickListener(this::onClickCalculate);
        editText = view.findViewById(R.id.editTextCalculate);
        textView = view.findViewById(R.id.textViewResult);
        return view;
    }

    public void onClickCalculate(View view) {
        String input = editText.getText().toString();
        String[] arr = input.split(" ");
        double result = 0;

        try {
            double x = Double.parseDouble(arr[0]);
            double y = Double.parseDouble(arr[2]);
            switch (arr[1]) {
                case "+":
                    result = x + y;
                    break;
                case "-":
                    result = x - y;
                    break;
                case "*":
                    result = x * y;
                    break;
                case "/":
                    result = x / y;
                    break;
            }

            textView.setText(Double.toString(result));
        } catch (Exception e) {
            textView.setText("Вы ввели некорректное выражение");
        }
    }
}