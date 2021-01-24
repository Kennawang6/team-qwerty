package com.example.qwertracker.ui.graph;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.qwertracker.R;
import com.example.qwertracker.ui.dashboard.DashboardViewModel;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class GraphFragment extends Fragment {
    EditText firstNum_1, secondNum_1;
    EditText firstNum_2, secondNum_2;
    EditText firstNum_3, secondNum_3;
    EditText firstNum_4, secondNum_4;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_graph, container, false);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        firstNum_1 = view.findViewById(R.id.firstNum_1);
        secondNum_1 = view.findViewById(R.id.secondNum_1);
        firstNum_2 = view.findViewById(R.id.firstNum_2);
        secondNum_2 = view.findViewById(R.id.secondNum_2);
        firstNum_3 = view.findViewById(R.id.firstNum_3);
        secondNum_3 = view.findViewById(R.id.secondNum_3);
        firstNum_4 = view.findViewById(R.id.firstNum_4);
        secondNum_4 = view.findViewById(R.id.secondNum_4);
        final GraphView graph = (GraphView) view.findViewById(R.id.graph);
        Button button = view.findViewById(R.id.addButton);
        graph.setVisibility(View.VISIBLE);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String firstInput_1, secondInput_1;
                String firstInput_2, secondInput_2;
                String firstInput_3, secondInput_3;
                String firstInput_4, secondInput_4;
                //  1 and 5
                firstInput_1 = firstNum_1.getText().toString();
                secondInput_1 = secondNum_1.getText().toString();
                firstInput_2 = firstNum_2.getText().toString();
                secondInput_2 = secondNum_2.getText().toString();
                firstInput_3 = firstNum_3.getText().toString();
                secondInput_3 = secondNum_3.getText().toString();
                firstInput_4 = firstNum_4.getText().toString();
                secondInput_4 = secondNum_4.getText().toString();
                try {
                    LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[]{
                            new DataPoint(0, 1),
                            new DataPoint(Integer.valueOf(firstInput_1), Integer.valueOf(secondInput_1)),
                            new DataPoint(Integer.valueOf(firstInput_2), Integer.valueOf(secondInput_2)),
                            new DataPoint(Integer.valueOf(firstInput_3), Integer.valueOf(secondInput_3)),
                            new DataPoint(Integer.valueOf(firstInput_4), Integer.valueOf(secondInput_4))
                    });
                    graph.addSeries(series);
                } catch (IllegalArgumentException e) {
                    // TODO error handling?
                }
            }
        });
    }
}
